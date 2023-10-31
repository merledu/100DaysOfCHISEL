package day34

import chisel3._
import org.scalatest.FreeSpec
import chiseltest._

class DetectSequenceTest extends FreeSpec with ChiselScalatestTester {
  "DetectSequenceTest test" in {
    // Define a test for the Detect_Seq module
    test(new Detect_Seq()) { c =>
      // Within this test block, 'c' represents an instance of the Detect_Seq module

      // Set the input 'in' to 1 (poke the input)
      c.io.in.poke(1.B)

      // Advance the simulation by 3 clock cycles
      c.clock.step(3)

      // Expect the output 'out' to be 0 (the expected value)
      c.io.out.expect(0.B)
    }
  }
}
