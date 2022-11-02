package day9

import chisel3._
import chisel3.util._

class BitPatternIO extends Bundle {
    val in = Input(UInt(8.W))

    val out = Output(Bool())
}

class BitPattern extends Module {
    val io = IO(new BitPatternIO)

    val pattern = BitPat("b0??1011?")

    when (io.in === pattern) {
        io.out := 1.B
    }.otherwise {
        io.out := 0.B
    }
}
