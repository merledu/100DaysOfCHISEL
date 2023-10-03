package day21

import chisel3._
import org.scalatest._
import chiseltest._

// Define a test class for the up_down_counter module
class up_down_counterTest extends FreeSpec with ChiselScalatestTester {
    "Lab 6 up down counter" in {
        // Start a ChiselTest with a new instance of the up_down_counter module with max value 16
        test(new up_down_counter(16)) { C =>
            // Inside the test block

            // Set the 'up_down' input to 0
            C.io.up_down.poke(0.B)

            // Advance the clock for 50 cycles
            C.clock.step(50)
        }
    }
}
