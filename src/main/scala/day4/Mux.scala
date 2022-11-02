package day4 

import chisel3._

class Mux extends Module {
     val io = IO(new Bundle {
         val a = Input(SInt(4.W))
         val b = Input(SInt(4.W))
         val sel =Input(Bool())

         val out = Output(SInt(4.W))
    })

    io.out := Mux(io.sel,io.a,io.b)
}
