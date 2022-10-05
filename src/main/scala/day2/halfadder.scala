package day2
import chisel3._
class halfadder extends Module{
     val io=IO(new Bundle{
         val a= Input(SInt(4.W))
         val b= Input(SInt(4.W))
         val sum= Output(SInt(4.W))
         val carryout= Output(SInt(4.W))
    })
    io.sum :=io.a ^ io.b
    io.carryout :=io.a & io.b
}