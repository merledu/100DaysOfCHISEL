package day1
import chisel3._
import org.scalatest._
import chiseltest._
class Day1 extends FreeSpec with ChiselScalatestTester{
    " gates Test" in {
        test(new Gates()){ c=>
        c.io.a.poke(1.S)
        c.io.b.poke(2.S)
        c.clock.step(3)
        c.io.AND.expect(0.S)
        c.io.OR.expect(3.S)
        c.io.NOT.expect(-2.S)
        c.io.NOR.expect(-4.S)
        c.io.XOR.expect(3.S)
        c.io.XNOR.expect(-4.S)

        }
    }
}