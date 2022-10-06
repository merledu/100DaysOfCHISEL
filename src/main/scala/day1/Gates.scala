package day1
import chisel3._
import chisel3.util._
class Gates extends Module{
    val io = IO(new Bundle{
    val a = Input(SInt(4.W))
    val b = Input(SInt(4.W))
    val AND = Output(SInt(4.W))
    val OR = Output(SInt(4.W))
    val NOT = Output(SInt(4.W))
    val NOR = Output(SInt(4.W))
    val XOR = Output(SInt(4.W))
    val XNOR = Output(SInt(4.W))
    })
    io.AND := io.a & io.b
    io.OR := io.a | io.b
    io.NOT := ~ io.a 
    io.NOR := ~(io.a | io.b)
    io.XOR := io.a ^ io.b
    io.XNOR := ~(io.a ^ io.b)

}