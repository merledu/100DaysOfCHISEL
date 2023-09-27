package day19

import chisel3._
import org.scalatest.FreeSpec
import chiseltest._

class OneShotTimerTest extends FreeSpec with ChiselScalatestTester{
   "OneShotTimerTest test" in{
       test(new OneShotTimerModule()){c =>
         c.clock.step(10)       
      }
   }      
}