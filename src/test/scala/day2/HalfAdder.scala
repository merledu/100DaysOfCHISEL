package day2

import chisel3._
import org.scalatest._
import chiseltest._

class HalfAdderTests extends FreeSpec with ChiselScalatestTester {
    "Half Adder Test" in {
        test(new HalfAdder()) {c =>
            c.io.a.poke(8.U)
            c.io.b.poke(15.U)

            c.clock.step(1)

            c.io.sum.expect(7.U)
            c.io.carryout.expect(8.U)
        }
    }
}
