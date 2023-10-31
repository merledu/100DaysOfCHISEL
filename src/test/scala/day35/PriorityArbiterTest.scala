package day35

import chisel3._
import org.scalatest.FreeSpec
import chiseltest._

class PriorityArbiterTest extends FreeSpec with ChiselScalatestTester {
  "PriorityArbiterTest test" in {
    // Define a test for the Priority_arb module
    test(new Priority_arb()) { c =>
      // Within this test block, 'c' represents an instance of the Priority_arb module

      // Set the input for in1: data = 2, valid = 1 (poke the input)
      c.io.in1.bits.poke(2.U)
      c.io.in1.valid.poke(1.B)

      // Set the input for in2: data = 1, valid = 1 (poke the input)
      c.io.in2.bits.poke(1.U)
      c.io.in2.valid.poke(1.B)

      // Advance the simulation by 5 clock cycles
      c.clock.step(5)

      // Check the expected output values
      // The output bits are expected to be 2
      c.io.out.bits.expect(2.U)
      // The output valid signal is expected to be 1
      c.io.out.valid.expect(1.B)
      // The output ready signal is expected to be 0
      c.io.out.ready.expect(0.B)
    }
  }
}