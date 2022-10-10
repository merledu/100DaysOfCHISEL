package day2
import chisel3._
import org.scalatest._
import chiseltest._

class FullAdderTests extends FreeSpec with ChiselScalatestTester {
     "FULL ADDER TEST" in {
       test(new FullAdder()){ c =>
       c.io.a.poke(8.S)
       c.io.b.poke(-15.S)
       c.io.c.poke(1.S)
       c.clock.step(1)
       c.io.sum.expect(-8.S)
       c.io.carryout.expect(1.S)
       }
    }
}