package day2

import chisel3._

class HalfAdder extends Module {
    val io = IO(new Bundle {
        val a = Input(UInt(4.W))
        val b = Input(UInt(4.W))

        val sum = Output(UInt(4.W))
        val carryout = Output(UInt(4.W))
    })

    io.sum := io.a ^ io.b
    io.carryout := io.a & io.b
}
