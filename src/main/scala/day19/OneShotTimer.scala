package day19

import chisel3._
import chisel3.util._

class OneShotTimerModule extends Module {
  val io = IO(new Bundle {
    // Input signal to start the timer countdown
    val start = Input(Bool())

    // Output signal that generates a pulse when the countdown reaches zero
    val pulse = Output(Bool())
  })

  // Register to store the countdown value
  val timer_count = RegInit(0.U(8.W))

  // Register to control whether the timer is actively counting
  val counting = RegInit(false.B)

  // When the 'start' input is asserted, initialize the countdown
  when(io.start) {
    counting := true.B
    timer_count := io.start // Load the countdown value
  }

  // While counting is enabled
  when(counting) {
    // If the countdown reaches zero, stop counting and generate a pulse
    when(timer_count === 0.U) {
      counting := false.B
    }.otherwise {
      // Otherwise, decrement the countdown value
      timer_count := timer_count - 1.U
    }
  }

  // Generate a pulse when counting is active and the countdown reaches zero
  io.pulse := counting && (timer_count === 0.U)
}