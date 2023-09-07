package day16

import chisel3._

// Define a Chisel module for a 4-bit serial-in, serial-out shift register
class ShiftRegister(val init: Int = 1) extends Module {
  // Define the module's IO ports
  val io = IO(new Bundle {
    val in = Input(UInt(4.W))   // 4-bit input
    val out = Output(Bool())    // Single-bit output
  })

  // Initialize the output to 0
  io.out := 0.B

  // Define a 4-bit shift register state
  val state = RegInit(0.U(4.W))

  // Define a flag register for control
  val flag = RegInit(0.U(4.W))

  // When the flag is not zero, shift the state and set the output
  when(flag =/= 0.U) {
    io.out := state
    state := state >> 1
  }.otherwise {
    // When the flag is zero, load the state with the input and increment the flag
    flag := flag + 1.U
    state := io.in
  }
}
