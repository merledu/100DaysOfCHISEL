package day6

import chisel3._
import chisel3.util._

class MUX1H extends Module {
    val io = IO(new Bundle {
        val in0 = Input(UInt(32.W))
        val in1 = Input(UInt(32.W))
        val in2 = Input(UInt(32.W))
        val in3 = Input(UInt(32.W))
        val sel = Input(UInt(4.W))

        val out = Output(UInt(32.W))
        val out1 = Output(UInt(32.W))
    })

    io.out := Mux1H(io.sel, Seq(io.in0, io.in1))
    io.out1 := Mux1H(io.sel, Seq(io.in2, io.in3))
}
