package day5

import chisel3._
import chisel3.util._

class Condition extends Module {
    val io = IO(new Bundle {
        val in = Input(UInt(2.W))

        val out = Output(UInt(4.W))
    })

    when (io.in === "b00".U) {        //chisel uses the when keyword to implement decision control.
        io.out := "b0001".U
    }.elsewhen (io.in === "b01".U) {  //Use the elsewhen condition is used to include multiple conditional expression
        io.out := "b0010".U           //after the when condition or between the when and otherwise conditions.
    }.elsewhen (io.in === "b10".U) {
        io.out := "b0100".U
    }.otherwise {                     //Along with the when and elsewhen statement, the otherwise condition can be optionally used  
        io.out := "b1000".U           //to define an alternate block of statements to be executed .
    }
}
