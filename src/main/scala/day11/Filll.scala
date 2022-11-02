package day11

import chisel3._
import chisel3.util._

class Filll extends Module {
    val io = IO(new Bundle {
        val fill = Input(UInt(2.W))
        
        val out = Output(UInt(6.W))
    })

    io.out := Fill(3, io.fill)
}
