package day35

import chisel3._
import chisel3.util._

class Priority_arb extends Module {
  val io = IO(new Bundle {
    val in1 = Flipped(Decoupled(UInt(4.W)))  // Input 1 with data and valid signals
    val in2 = Flipped(Decoupled(UInt(4.W)))  // Input 2 with data and valid signals
    val out = Decoupled(UInt(4.W))          // Output with data and valid signals
  })

  // Create two queues, one for each input, to handle incoming data
  val queue = Queue(io.in1, 5)  // Queue for input 1 with a depth of 5
  val queue1 = Queue(io.in2, 5) // Queue for input 2 with a depth of 5

  // Create an arbiter module with two inputs
  val arb_priority = Module(new Arbiter(UInt(), 2))

  // Connect the inputs of the arbiter to the output of the respective queues
  arb_priority.io.in(0) <> queue   // Connect input 1 to the first queue
  arb_priority.io.in(1) <> queue1  // Connect input 2 to the second queue

  // Connect the output of the arbiter to the module's output
  io.out <> arb_priority.io.out
}