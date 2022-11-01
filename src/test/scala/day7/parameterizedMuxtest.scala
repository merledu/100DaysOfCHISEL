package day7
import chisel3.util._
import chisel3._
import chiseltest._
import org.scalatest._

class PARA_MUXtest extends FreeSpec with ChiselScalatestTester{
    "mux as parameter" in {
        test (new PARA_MUX){ c=> 
        c.io.in1.poke(8.U)
        c.clock.step(1)
        c.io.in2.poke(6.U)
        c.clock.step(1)
        c.io.sel.poke(1.B)
        c.clock.step(1)
        c.io.out.expect(6.U)
        c.clock.step(200)
        }
    }
}
