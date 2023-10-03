package day23

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class Mux_2to1test extends FreeSpec with ChiselScalatestTester{
  "lab 2 ex1Tester " in {
    test(new Mux_2to1){ a=>
      a.io.in_A.poke(45.U)
      a.io.in_B.poke(55.U)
      a.io.select.poke(1.B)
      a.io.out.expect(45.U)
      a.clock.step(4)

    }
  }
}