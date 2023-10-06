package day25
import chisel3._
import chisel3.util._

class Mux_Lookup extends Module {
  val io = IO(new Bundle {
    val sel = Input(UInt(2.W))
    val out = Output(UInt(3.W))
  })


  io.out := MuxLookup(io.sel, false.B, Array(
    (0.U) -> 0.U,
    (1.U) -> 2.U,
    (2.U) -> 4.U,
    (3.U) -> 6.U)
  )
}