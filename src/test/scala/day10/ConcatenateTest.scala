package day10

import chisel3._
import chiseltest._
import org.scalatest._

class ConcatenateTest extends FreeSpec with ChiselScalatestTester {
    "Concatenate" in {
        test(new Concatenate) {c =>
            c.io.lowBits.poke(1.U)
            c.io.highBits.poke(2.U)

            c.clock.step(1)

            c.io.concatenatedBits.expect(9.U)
        }
    }
}
