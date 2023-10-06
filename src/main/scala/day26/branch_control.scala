package day26

import chisel3._
import chisel3.util._
import chisel3.stage.ChiselStage

class LM_IO_Interface_BranchControl extends Bundle {
    val fnct3 = Input ( UInt (3.W ) )
    val branch = Input ( Bool () )
    val arg_x = Input ( UInt (4.W ) )
    val arg_y = Input ( UInt (4.W ) )
    val br_taken = Output ( Bool () )
}

class BranchControl extends Module{
    val io = IO (new LM_IO_Interface_BranchControl)

when( io.branch === 1.B ){                           // Check if the branch signal is high
    when ( io.fnct3 === 0.U ) {
        io.br_taken :=  io.arg_x === io.arg_y        // Branch taken if arg_x is equal to arg_y
    }.elsewhen ( io.fnct3 === 1.U ) {
        io.br_taken :=  io.arg_x =/= io.arg_y        // Branch taken if arg_x is not equal to arg_y
    }.elsewhen ( io.fnct3 === 4.U ) {
        io.br_taken :=  io.arg_x < io.arg_y          // Branch taken if arg_x is less than arg_y
    }.elsewhen ( io.fnct3 === 5.U ) {
        io.br_taken :=  io.arg_x > io.arg_y          // Branch taken if arg_x is greater than arg_y
    }.otherwise{
        io.br_taken := 0.B                           // Default case: branch not taken
    }

}.otherwise{
    io.br_taken := 0.B
}

}