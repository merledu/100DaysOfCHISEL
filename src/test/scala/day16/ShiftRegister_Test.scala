package day16

import chisel3._
import org.scalatest._
import chiseltest._

class ShiftRegisterTest extends FreeSpec with ChiselScalatestTester {
  "Shift Register" in {
    test(new ShiftRegister()) { dut =>
      // Initialize test values
      val testInput = 3.U // Binary: 0011
      val testClockCycles = 10

      // Apply input to the shift register
      dut.io.in.poke(testInput)

      // Verify the initial output is 0
      dut.io.out.expect(0.B)

      // Clock the module for a few cycles
      for (_ <- 0 until testClockCycles) {
        dut.clock.step()
      }


      // You can continue testing additional cases or conditions here
    }
  }
}
