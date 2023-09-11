package day18
import chisel3._
import org.scalatest.FreeSpec
import chiseltest._

class My_QueueTest extends FreeSpec with ChiselScalatestTester {
    "QueueTest" in {
        test(new My_Queue) { c =>
            // Test case description: Test the My_Queue module.

            // Set the input data to 4 (bits) and indicate that it's valid.
            c.io.in.bits.poke(4.U)
            c.io.in.valid.poke(1.B)

            // Advance the simulation clock by 5 cycles.
            c.clock.step(5)

            // Expect that the output bits should be 4.
            c.io.out.bits.expect(4.U)
        }
    }
}
