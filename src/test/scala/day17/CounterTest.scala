package day17

import chisel3._
import org.scalatest._
import chiseltest._

class counterTest extends FreeSpec with ChiselScalatestTester {
  "Lab 6 Counter Test" in {
    test(new counter(9)) { dut =>
      // Advance the clock for 50 cycles
      dut.clock.step(50)

      // You can add more test cases or assertions here to validate the counter's behavior
    }
  }
}
