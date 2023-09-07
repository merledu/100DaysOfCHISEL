package day17

import chisel3._
import chisel3.util._

// Define a counter module with adjustable maximum and minimum values
class counter(val max: Int, val min: Int = 0) extends Module {
  val io = IO(new Bundle {
    val out = Output(UInt(log2Ceil(max).W)) // Output is a UInt with width determined by log2(max)
  })

  val counter = RegInit(min.U(log2Ceil(max).W)) // Initialize the counter register with the minimum value

  // Calculate the next counter value using a Mux based on conditions
  val count_buffer = Mux((isPow2(max) && (min == 0)).B, counter + 1.U, Mux(counter === max.U, min.U, counter + 1.U))

  // Update the counter with the new value
  counter := count_buffer

  // Connect the output to the current counter value
  io.out := counter
}
