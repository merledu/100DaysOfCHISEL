
package day3
import chisel3._
import org.scalatest._
import chiseltest._

class Bitwidthtest extends FreeSpec with ChiselScalatestTester{
    "bitwidth Test" in { 
        test(new Bitwidth ()){ c=>
        c.io.input.poke(4.U)
        c.clock.step(1)
        c.io.output.expect(4.S)}}}
