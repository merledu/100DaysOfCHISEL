package day10

import chisel3._
import chisel3.util._

class Concatenate extends Module {
    val io = IO(new Bundle {
        val lowBits = Input(UInt(2.W))
        val highBits = Input(UInt(2.W))

        val concatenatedBits = Output(UInt(4.W))
    })

    io.concatenatedBits := Cat(io.highBits, io.lowBits)
}
