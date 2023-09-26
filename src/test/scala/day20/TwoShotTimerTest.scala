package day20

import chisel3._
import org.scalatest.FreeSpec
import chiseltest._

class TwoShotTimerTest extends FreeSpec with ChiselScalatestTester{
   "TwoShotTimerTest test" in{
       test(new Timer ()){c =>
         c.clock.step(10) 
        }
    }   
}