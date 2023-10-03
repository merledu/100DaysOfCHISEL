package day22

import chisel3._
import org.scalatest._
import chiseltest._

class Mux_8to1Test extends FreeSpec with ChiselScalatestTester {
  "Mux_8to1 Test" in {
    test(new Mux_8to1) { c =>
      // Test case 1: Select input 0 with s2=0, s1=0, and s0=0
      c.io.in.poke(0.U)
      c.io.s2.poke(false.B)
      c.io.s1.poke(false.B)
      c.io.s0.poke(false.B)
      c.clock.step(1)

      // Test case 2: Select input 3 with s2=0, s1=1, and s0=1
      c.io.in.poke(3.U)
      c.io.s2.poke(false.B)
      c.io.s1.poke(true.B)
      c.io.s0.poke(true.B)
      c.clock.step(1)

      // You can add more test cases as needed
    }
  }
}
