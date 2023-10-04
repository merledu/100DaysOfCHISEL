package day24

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._


class MuxCaseTest extends FreeSpec with ChiselScalatestTester{
  "Mux case tester " in {
    test(new Mux_Case){ a=>
      a.io.select.poke(1.B)
      a.io.out.expect(8.U)
      a.clock.step(2)

    }
  }
}