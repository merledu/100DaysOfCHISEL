package day23

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class Mux_2to1test extends FreeSpec with ChiselScalatestTester{
  "lab 2 ex1Tester " in {
    test(new Mux_2to1){ a=>
      a.io.in_A.poke(45.U) // input A
      a.io.in_B.poke(55.U) // input B
      a.io.select.poke(1.B) // select pin selects which input to send as output
      a.io.out.expect(45.U) // output received
      a.clock.step(4)

    }
  }
}