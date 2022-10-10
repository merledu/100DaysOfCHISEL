package day4
import chisel3._
import org.scalatest._
import chiseltest._

class MuxTest extends FreeSpec with ChiselScalatestTester {

    "Mux TEST" in {
       test(new Mux()){ c =>
       c.io.a.poke(-8.S)
       c.io.b.poke(5.S)
       c.io.sel.poke(1.B)
       c.clock.step(1)
       c.io.out.expect(-8.S)
       
       }
    }
}
