package day28

import chisel3._
import chisel3.util._

// Define a black-box adder with input A, input B, and output Sum.
class BlackBoxAdder extends BlackBox {
  val io = IO(new Bundle {
    val A = Input(UInt(4.W)) // Input A of 4-bit wide
    val B = Input(UInt(4.W)) // Input B of 4-bit wide
    val Sum = Output(UInt(4.W)) // Output Sum of 4-bit wide
  })

  // Perform the addition operation and connect it to the output Sum
  io.Sum := io.A + io.B
}

// Define a Chisel module
class MyChiselModule extends Module {
  val io = IO(new Bundle {
    val inA = Input(UInt(4.W)) // Input inA of 4-bit wide
    val inB = Input(UInt(4.W)) // Input inB of 4-bit wide
    val outSum = Output(UInt(4.W)) // Output outSum of 4-bit wide
  })

  // Instantiate the black-box adder
  val adder = Module(new BlackBoxAdder)

  // Connect inputs inA and inB to the black-box adder inputs A and B
  adder.io.A := io.inA
  adder.io.B := io.inB

  // Connect the black-box adder output Sum to the module's output outSum
  io.outSum := adder.io.Sum
}
