package day11

import chisel3._
import chiseltest._
import org.scalatest._

class FilllTest extends FreeSpec with ChiselScalatestTester {
    "Fill" in {
        test(new Filll) {f =>
            f.io.fill.poke(1.U)

            f.clock.step(1)

            f.io.out.expect(21.U)
        }
    }
}
