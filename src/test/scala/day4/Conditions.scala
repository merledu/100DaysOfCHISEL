package day4
import chisel3._
import org.scalatest._
import chiseltest._

class Conditiontest extends FreeSpec with ChiselScalatestTester{
    " whenelsewhen Test" in {
        test(new Condition()){ c=>
        c.io.in.poke(1.U)
        c.clock.step(3)
        c.io.out.expect(2.U)
        }
    }
}