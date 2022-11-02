package day8

import chisel3.util._
import chisel3._
import chiseltest._
import org.scalatest._
import scala.util.Random
import operations._

class Switchtest extends FreeSpec with ChiselScalatestTester{
    "switch test" in {
        test(new SWITCH) {c =>
            var array_sel = Array(ADD,SUB,DIVIDE,MULTIPLY)
            
            c.io.in_a.poke(9.U)
            c.io.in_b.poke(3.U)
            c.io.sel.poke(1.U)

            c.clock.step(1)

            c.io.out.expect(2.U)
        }
    }
}
