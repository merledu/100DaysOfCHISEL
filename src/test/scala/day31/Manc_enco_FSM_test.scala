package day31

import chisel3._
import org.scalatest.FreeSpec
import chiseltest._

class ManchesterDecoderTest extends FreeSpec with ChiselScalatestTester {
  "ManchesterDecoder Module Test" in {
    test(new ManchesterDecoder) { c =>
      // Initialize the encoded signal input
      c.io.encodedSignal.poke(true.B)

      // Step the clock to simulate behavior
      c.clock.step(10)

      // Add more test cases and assertions as needed
    }
  }
}
