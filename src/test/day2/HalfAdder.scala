package day2

import chisel3._
import org.scalatest._
import chiseltest._

class HalfAdderTests extends FreeSpec with ChiselScalatestTester {
    "HALF ADDER TEST" in {
        test(new HalfAdder()) {c =>
            c.io.a.poke(8.U)
            c.io.b.poke(4.U)

            c.clock.step(1)

            c.io.sum.expect(2.U)
            c.io.carryout.expect(1.U)
        }
    }
}
