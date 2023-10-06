package day26

import chisel3._
import org.scalatest.FreeSpec
import chiseltest._

// Define a test class for the BranchControl module
class branch_controlTest extends FreeSpec with ChiselScalatestTester{
   "branch_controlTest test" in{
       test(new BranchControl()){c =>
         c.io.fnct3.poke(1.U)              // Set input signals for the BranchControl module
         c.io.branch.poke(1.B)
         c.io.arg_x.poke(1.U)
         c.io.arg_y.poke(0.U)
         c.clock.step(10)                  // Advance the simulation clock by 10 cycles
         c.io.br_taken.expect(1.B)         // Check the expected output of the BranchControl module
       } 
    }      
}