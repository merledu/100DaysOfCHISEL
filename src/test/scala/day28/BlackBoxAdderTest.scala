package day28

import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._

class MyChiselModuleTest extends FreeSpec with ChiselScalatestTester {
    "BlackBoxAdderTest " in{
        test(new MyChiselModule) { c =>
      // Set input values
            c.io.inA.poke(2.U)
            c.io.inB.poke(3.U)

      // Advance the clock
            c.clock.step(1)

      // Check the output
            c.io.outSum.expect(5.U)
        }
    }
}
