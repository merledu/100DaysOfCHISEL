package day18

import chisel3._
import chisel3.util._

// Chisel module representing a two-stage queue
class My_Queue extends Module {
  val io = IO(new Bundle {
    // Input interface for the queue (data to be enqueued)
    val in = Flipped(Decoupled(UInt(8.W)))

    // Output interface for the queue (dequeued data)
    val out = Decoupled(UInt(8.W))
  })

  // Create a queue with a depth of 5 elements, taking input from io.in
  val queue = Queue(io.in, 5)

  // Create a second-stage queue with a depth of 5 elements, taking input from the first queue
  val q1 = Queue(queue, 5)

  // Connect the output of the second-stage queue (q1) to the output interface (io.out)
  io.out <> q1
}