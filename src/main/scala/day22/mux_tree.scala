package day22

import chisel3._

// Define an input and output interface for the module
class LM_IO_Interface extends Bundle {
  val in = Input(UInt(8.W))
  val s0 = Input(Bool())
  val s1 = Input(Bool())
  val s2 = Input(Bool())
  val out = Output(Bool())
}

// Define the 8-to-1 multiplexer module
class Mux_8to1 extends Module {
  val io = IO(new LM_IO_Interface)

  // Create two 4-to-1 multiplexers (Mux4_to_1_a and Mux4_to_1_b)
  val Mux4_to_1_a = Mux(
    io.s1,
    Mux(io.s0, io.in(3), io.in(2)),
    Mux(io.s0, io.in(1), io.in(0))
  )
  val Mux4_to_1_b = Mux(
    io.s1,
    Mux(io.s0, io.in(7), io.in(6)),
    Mux(io.s0, io.in(5), io.in(4))
  )

  // Create a 2-to-1 multiplexer (Mux2_to_1) to select between Mux4_to_1_a and Mux4_to_1_b
  val Mux2_to_1 = Mux(io.s2, Mux4_to_1_b, Mux4_to_1_a)

  // Connect the output of the 2-to-1 Mux to the module's output port
  io.out := Mux2_to_1
}
