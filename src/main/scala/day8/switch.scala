package day8

import chisel3._
import chisel3.util._

class Switch_IO extends Bundle {
    val sel = Input(UInt(3.W))
    val in_a = Input(UInt(32.W))
    val in_b = Input(UInt(32.W))

    val out = Output(UInt(2.W))
}

object operations {
    val ADD = 0
    val SUB = 1
    val DIVIDE = 2
    val MULTIPLY = 3
}

import operations._

class SWITCH extends Module{
    val io = IO(new Switch_IO)

    io.out := 0.U
    switch (io.sel) {
        is (ADD.U) {
            io.out := io.in_a + io.in_b
        }
        is (SUB.U) {
            io.out := io.in_a - io.in_b
        }
        is (DIVIDE.U) {
            io.out := io.in_a / io.in_b
        }
        is (MULTIPLY.U) {
            io.out := io.in_a * io.in_b
        }
    }
}
