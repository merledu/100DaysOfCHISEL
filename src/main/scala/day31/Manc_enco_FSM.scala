package day31

import chisel3._
import chisel3.util._

class ManchesterDecoder extends Module {
  val io = IO(new Bundle {
    val encodedSignal = Input(Bool())  // Input: Manchester-encoded signal
    val decodedData = Output(UInt(1.W))  // Output: Decoded data bit (0 or 1)
  })

  // Define states for the FSM
  val stateIdle :: stateBit :: Nil = Enum(2)

  // State register initialization
  val stateReg = RegInit(stateIdle)

  // Define a register to store the previously received bit
  val prevBitReg = RegNext(io.encodedSignal)

  // Initialize the output signal
  io.decodedData := 0.U

  // FSM logic
  switch(stateReg) {
    is(stateIdle) {
      // Transition to stateBit when a rising edge is detected (10 transition)
      when(prevBitReg === true.B && io.encodedSignal === false.B) {
        stateReg := stateBit
        io.decodedData := 0.U  // Decoded data is 0
      }
    }
    is(stateBit) {
      // Transition to stateIdle when a falling edge is detected (01 transition)
      when(prevBitReg === false.B && io.encodedSignal === true.B) {
        stateReg := stateIdle
        io.decodedData := 1.U  // Decoded data is 1
      }
    }
  }
}
