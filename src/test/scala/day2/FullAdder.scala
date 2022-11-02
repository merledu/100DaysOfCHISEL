package day2

import chisel3._
import org.scalatest._
import chiseltest._

class FullAdderTests extends FreeSpec with ChiselScalatestTester {
    "Full Adder Test" in {
        test(new FullAdder()) {c =>
            c.io.a.poke(8.U)
            c.io.b.poke(15.U)
            c.io.c.poke(1.U)

            c.clock.step(1)

            c.io.sum.expect(6.U)
            c.io.carryout.expect(9.U)
        }
    }
}
