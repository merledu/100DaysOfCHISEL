package day27

import chisel3._
import chisel3.util._

class LM_IO_Interface_ImmdValGen extends Bundle {
    val instr = Input ( UInt (32. W ) )
    val pc_in = Input ( SInt (32. W ) )
    val immd_se = Output ( UInt (32. W ) )
}

object imm{
    val i = 19.U(7.W) // i-type opcode define as risc-V standard
    val s = 35.U(7.W) // s-type opcode define as risc-V standard
    val sb = 99.U(7.W) // sb-type opcode define as risc-V standard
    val u = 55.U(7.W) // u-type opcode define as risc-V standard
    val uj = 111.U(7.W) // uj-type opcode define as risc-V standard
    val ei = 0.U(32.W)  // extra immediate which will be define as zero in immediate
}

class ImmExtension extends Module {
    val io = IO ( new LM_IO_Interface_ImmdValGen)
    io.immd_se := Mux(
        
    io.instr(6, 0) === imm.i || io.instr(6, 0) === "b0000011".U || io.instr(6, 0) === "b1100111".U,
    Cat(imm.ei(19, 0), io.instr(31, 20)),
    Mux(
      io.instr(6, 0) === imm.s,
      Cat(imm.ei(19, 0), io.instr(31, 25), io.instr(11, 7)),
      Mux(
        io.instr(6, 0) === imm.sb,
        Cat(imm.ei(19, 0), io.instr(31), io.instr(7), io.instr(30, 25), io.instr(11, 8), "b0".U) + (io.pc_in).asUInt,
        Mux(
          io.instr(6, 0) === imm.u,
          Cat(io.instr(31, 12), imm.ei(11, 0)),
          Mux(
            io.instr(6, 0) === imm.uj,
            Cat(imm.ei(11, 0), io.instr(31), io.instr(19, 12), io.instr(20), io.instr(30, 21), "b0".U) + (io.pc_in).asUInt,
            0.U
          ).asUInt
        )
      )
    )
  )
}
