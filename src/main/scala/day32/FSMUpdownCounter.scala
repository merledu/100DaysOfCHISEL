package day32

import chisel3._
import chisel3.util._

class CounterUpDown(n: Int) extends Module {
  // Define the module's input and output ports
  val io = IO(new Bundle {
    val data_in = Input(UInt(n.W))  // Input data of type UInt with 'n' bits
    val out = Output(Bool())       // Output signal of type Bool
  })

  // Create a counter register with an initial value of 0
  val counter = RegInit(0.U(n.W))

  // Create a maximum count register with an initial value of 6
  val max_count = RegInit(6.U(n.W))

  // Define the states of the state machine using an Enumeration
  val init :: up :: down :: Nil = Enum(3)
  val state = RegInit(init)  // Initialize the state machine with the 'init' state

  // Define flags to check if the counter is at its maximum or minimum value
  val up_flag = (counter === max_count)
  val down_flag = (counter === 0.U)

  // Implement a state machine using a switch-case construct
  switch(state) {
    is(init) {
      // If the current state is 'init', transition to the 'up' state
      state := up
    }
    is(up) {
      when(up_flag) {
        // If the counter is at its maximum value, transition to the 'down' state
        state := down
        counter := counter - 1.U  // Decrement the counter
      }.otherwise {
        // If not at the maximum, increment the counter
        counter := counter + 1.U
      }
    }
    is(down) {
      when(down_flag) {
        // If the counter is at its minimum value, transition to the 'up' state
        state := up
        counter := counter + 1.U  // Increment the counter
        max_count := io.data_in   // Load the counter with the input data
      }.otherwise {
        // If not at the minimum, decrement the counter
        counter := counter - 1.U
      }
    }
  }

  // Set the output signal to true if the counter is at its maximum or minimum value
  io.out := up_flag | down_flag
}
