package day14
import org.scalatest._
import chiseltest._
import chisel3._

class Adder_param_Test extends FreeSpec with ChiselScalatestTester{
    "Adder_param" in  {
            test(new Adder(32)){c=>
            c.io.in_0.poke(12.U)
            c.io.in_1.poke(4.U)
        c.clock.step(100)}
        }
}
