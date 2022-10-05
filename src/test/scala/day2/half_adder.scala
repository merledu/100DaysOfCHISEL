package day2
import chisel3._
import org.scalatest._
import chiseltest._

class halfadderTests extends FreeSpec with ChiselScalatestTester {

    "HALF ADDER TEST" in {
       test(new halfadder()){ c =>
       c.io.a.poke(8.S)
       c.io.b.poke(-15.S)
       c.clock.step(1)
       c.io.sum.expect(-7.S)
       c.io.carryout.expect(0.S)
       }
    }
}