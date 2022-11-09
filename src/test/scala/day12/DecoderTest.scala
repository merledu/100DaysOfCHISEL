package day12
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class Deoder_Valid_Test extends FreeSpec with ChiselScalatestTester{
    "Decoder"  in {
     test (new decoder_with_valid()){ c =>
        c.io.in.poke("b11".U)




        c.io.out.valid.expect(1.B)
      
      
         
        c.clock.step(10)
        }
    }
}
