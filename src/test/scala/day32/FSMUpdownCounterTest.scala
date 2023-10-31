package day32

import chisel3._
import org.scalatest.FreeSpec
import chiseltest._

class FSMUpdownCounterTest extends FreeSpec with ChiselScalatestTester {
  "FSMUpdownCounterTest" in {
    // Define a test for the CounterUpDown module
    test(new CounterUpDown(4)) { c =>
      // Within this test block, 'c' represents an instance of the CounterUpDown module

      // Set the input 'data_in' to 2 (poke the input)
      c.io.data_in.poke(2.U)

      // Advance the simulation by 100 clock cycles
      c.clock.step(100)
    }
  }
}
