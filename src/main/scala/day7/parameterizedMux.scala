package day7

import chisel3.util._
import chisel3._

class mux_IO [T <: Data] (data_type : T) extends Bundle {
    val in1 = Input(data_type)
    val in2 = Input(data_type)
    val sel = Input(Bool())

    val out = Output(data_type)
}

class PARA_MUX extends Module {
    val io = IO(new mux_IO(UInt(32.W)))

    def Mux2_to_1[ T<: Data] (in1: T, in2: T, sel: Bool):T = {Mux(sel, in2, in1)}

    io.out := Mux2_to_1(io.in1, io.in2, io.sel)
}
