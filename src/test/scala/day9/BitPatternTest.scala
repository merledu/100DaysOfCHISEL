package day9

import chisel3._
import chiseltest._
import org.scalatest._

class BitPatternTest extends FreeSpec with ChiselScalatestTester {
    "BitPattern" in {
        test(new BitPattern) { bp =>
            bp.io.in.poke("b01010110".U)
            bp.clock.step(10)
            bp.io.out.expect(1.B)
        }
    }
}
