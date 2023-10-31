package day34

import chisel3._
import chisel3.util._
import chisel3.experimental.ChiselEnum

class Detect_Seq extends Module {
  val io = IO(new Bundle {
    val in = Input(Bool())   // Input signal
    val out = Output(Bool()) // Output signal
  })

  // Define an enumeration for the states of the state machine
  val s0 :: s1 :: s2 :: Nil = Enum(3)
  val state = RegInit(s0)  // Initialize the state machine with 's0'

  // Define the output based on the current state and the input signal
  io.out := (state === s2) && (!io.in)  // This is a Mealy type state machine

  // Implement the state machine using a switch-case construct
  switch(state) {
    is(s0) {
      // If the current state is 's0', check the input signal
      when(io.in) {
        state := s1  // Transition to state 's1' if the input is true
      }
    }
    is(s1) {
      // If the current state is 's1', check the input signal
      when(io.in) {
        state := s2  // Transition to state 's2' if the input is true
      }.otherwise {
        state := s0  // Transition back to state 's0' if the input is false
      }
    }
    is(s2) {
      // If the current state is 's2', check the input signal
      when(!io.in) {
        state := s0  // Transition back to state 's0' if the input is false
      }
    }
  }
}
