package day33

import chisel3._
import chisel3.stage.ChiselStage
import chisel3.util._
import scala.util._

// Define a case class for UART parameters
case class UART_Params(
  dataBits: Int = 8,
  stopBits: Int = 2,
  divisorBits: Int = 5,
  oversample: Int = 2,
  nSamples: Int = 3,
  nTxEntries: Int = 4,
  nRxEntries: Int = 4
) {
  def oversampleFactor = 1 << oversample
  require(divisorBits > oversample)
  require(oversampleFactor > nSamples)
}

// Define the UART_Tx module
class UART_Tx(c: UART_Params) extends Module {
  val io = IO(new Bundle {
    val en = Input(Bool())
    val in = Flipped(Decoupled(UInt(c.dataBits.W)))
    val out = Output(Bool())
    val div = Input(UInt(c.divisorBits.W))
    val nstop = Input(UInt(c.stopBits.W))
  })

  // Define internal registers
  val prescaler = RegInit(0.U(c.divisorBits.W))
  val pulse = (prescaler === 0.U)
  private val n = c.dataBits + 1
  val counter = Reg(UInt(n.W))
  val shifter = Reg(UInt(n.W))
  val out = RegInit(0.U((log2Floor(n + c.stopBits) + 1).W))
  val busy = RegInit(true.B)
  val state1 = busy
  val state2 = RegInit(false.B)

  io.in.ready := (counter =/= 0.U)
  io.out := out

  when(state1) {
    shifter := Cat(io.in.bits, false.B)
    counter := n.U
    val stopBitsValid = (0 to c.stopBits).map(i => io.nstop === i.U)
    out := Mux1H(stopBitsValid.zipWithIndex.map { case (valid, i) => valid -> (n + i + 2).U })

  }

  when(state2) {
    prescaler := Mux(pulse, (io.div - 1.U), prescaler - 1.U)
    when(pulse) {
      counter := counter - 1.U
      shifter := Cat(true.B, shifter >> 1)
      out := shifter(0)
    }
  }
}