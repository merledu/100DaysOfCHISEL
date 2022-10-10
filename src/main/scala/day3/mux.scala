package day3
import chisel3._
import chisel3.util._

class Mux_Io extends Bundle{
    val in0 = Input(UInt(1.W))
    val in1 = Input(UInt(1.W))
    val sel = Input(UInt(1.W))
    val out = Output(UInt(1.W))
}

class Mux extends Module{
    val io = IO(new Mux_Io)
    io.out := Mux(io.sel === 0.U, io.in0, io.in1) // if io.sel == 0==> out = in0 else out = in1

}
