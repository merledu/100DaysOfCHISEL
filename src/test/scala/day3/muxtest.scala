package day3
import chisel3._
import org.scalatest._
import chiseltest._

class MuxTest extends FreeSpec with ChiselScalatestTester{
    "Mux Test" in {
        test(new Mux){c =>
            c.io.in0.poke(1.U)
            c.io.in1.poke(0.U)
            c.io.sel.poke(0.U)
            c.clock.step(1)
            c.io.out.expect(1.U)
        }
    }
}
