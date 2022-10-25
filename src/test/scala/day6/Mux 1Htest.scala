package day6
import org.scalatest._
import chiseltest._
import chisel3._

class MUX1Htest extends FreeSpec with ChiselScalatestTester{
    "MUX1H test" in {
        test (new MUX1H){ c =>
        c.io.in0.poke(3.U)
        c.clock.step(1)
        c.io.in1.poke(3.U)
        c.clock.step(1)
        c.io.in2.poke(3.U)
        c.clock.step(1)
        c.io.in3.poke(3.U)
        c.clock.step(1)
        c.io.sel.poke(2.U)
        c.clock.step(1)
        c.io.out.expect(3.U)
        c.clock.step(1)
        c.io.out1.expect(3.U)
        c.clock.step(100)
        }
    }
}
