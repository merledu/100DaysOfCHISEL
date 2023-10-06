package day25

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class Mux_LookupTest extends FreeSpec with ChiselScalatestTester{
  "Mux LookUP tester " in {
    test(new Mux_Lookup){ a=>
      a.io.sel.poke(1.U)
      a.io.out.expect(2.U)
      a.clock.step()

    }
  }
}