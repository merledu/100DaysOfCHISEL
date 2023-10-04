package day25

import chisel3._
import org.scalatest.FreeSpec
import chiseltest._

// Define a test class for the MuxLookup module
class mux_lookupTest extends FreeSpec with ChiselScalatestTester{
   "mux_lookupTest test" in{
       test(new MuxLookup()){c =>
         c.io.in0.poke(1.B)           // Set input signals for the MuxLookup module
         c.io.in1.poke(0.B)
         c.io.in2.poke(0.B)
         c.io.in3.poke(0.B)
         c.io.in4.poke(1.B)
         c.io.in5.poke(1.B)
         c.io.in6.poke(0.B)
         c.io.in7.poke(1.B)
         c.io.sel.poke(4.U)
         c.clock.step(10)             // Advance the simulation clock by 10 cycles
         c.io.out.expect(1.B)         // Check the expected output of the MuxLookup module
       } 
   }
}   