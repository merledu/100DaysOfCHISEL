package day1
import chisel3._
import org.scalatest._
import chiseltest._

class GatesTests extends FreeSpec with ChiselScalatestTester {
    "Gates Test" in {
        test(new Gates()) {c =>
            c.io.a.poke(1.U)
            c.io.b.poke(2.U)

            c.clock.step(3)

            c.io.AND.expect(0.U)
            c.io.OR.expect(3.U)
            c.io.NOT.expect(14.U)
            c.io.NOR.expect(12.U)
            c.io.XOR.expect(3.U)
            c.io.XNOR.expect(12.U)
        }
    }
}
