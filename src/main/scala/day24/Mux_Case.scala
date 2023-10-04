package day24
import chisel3._
import chisel3.util._
class LM_IO_Interface extends Bundle {
  // 3 bit input
  val select = Input(UInt(3.W))
  // 32 bit output
  val out = Output (UInt (32.W))
}
class Mux_Case extends Module {
  val io = IO (new LM_IO_Interface )
  //when the select pin matches with any of the condition that value is returned from the mux case
  // if no match is found the 0 is returned as the default value
  io.out := MuxCase(0.U, Array(
    (io.select === "b000".U) -> 0.U,
    (io.select === "b001".U) -> 8.U,
    (io.select === "b010".U) -> 16.U,
    (io.select === "b011".U) -> 24.U,
    (io.select === "b100".U) -> 32.U,
  ) )

}