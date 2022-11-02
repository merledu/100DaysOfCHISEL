package day1

import chisel3._

// Module instantiation
class Gates extends Module {
    // Bundle instantiation
    val io = IO(new Bundle {
        // Defining Inputs
        val a = Input(UInt(4.W))
        val b = Input(UInt(4.W))

        // Defining Outputs
        val AND = Output(UInt(4.W))
        val OR = Output(UInt(4.W))
        val XOR = Output(UInt(4.W))
        val NOT = Output(UInt(4.W))
        val NAND = Output(UInt(4.W))
        val NOR = Output(UInt(4.W))
        val XNOR = Output(UInt(4.W))
    })

    // Wiring logic gates to output ports
    io.AND := io.a & io.b
    io.OR := io.a | io.b
    io.XOR := io.a ^ io.b
    io.NOT := ~io.a 
    io.NAND := ~(io.a & io.b)
    io.NOR := ~(io.a | io.b)
    io.XNOR := ~(io.a ^ io.b)
}
