package day3

import chisel3._

class Bitwidth extends Module {
    val io = IO(new Bundle {           //Bundle Definition
        val input = Input(UInt(4.W))   //Datatype

        val output = Output(SInt(4.W))
    })

    val temp = Wire(SInt(4.W)) //wiring
    temp := io.input.asSInt    //typecasting
    io.output := temp
}
