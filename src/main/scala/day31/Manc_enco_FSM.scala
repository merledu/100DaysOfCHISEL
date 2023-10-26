package day31

import chisel3._
import chisel3.util._

class ManchesterDecoder extends Module {
  val io = IO(new Bundle {
    val encodedSignal = Input(Bool())  // Manchester-encoded signal
    val decodedData = Output(UInt(1.W))  // Decoded data bit (0 or 1)
  })

  // Define states for the FSM
  val stateIdle :: stateBit :: Nil = Enum(2)
  val stateReg = RegInit(stateIdle)

  // Define a register to store the previously received bit
  val prevBitReg = RegNext(io.encodedSignal)

  // FSM logic
  switch(stateReg) {
    is(stateIdle) {
      when(io.encodedSignal === false.B) {
        stateReg := stateBit
        io.decodedData := 0.U
      }.otherwise {
        stateReg := stateIdle
      }
    }
    is(stateBit) {
      when(io.encodedSignal === true.B) {
        stateReg := stateIdle
        io.decodedData := 1.U
      }.otherwise {
        stateReg := stateBit
        io.decodedData := 0.U
      }
    }
  }
}