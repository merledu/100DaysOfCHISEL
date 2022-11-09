package day12	
import chisel3 . _
import chisel3.util._
class LM_IO_Interface_decoder_with_valid extends Bundle {
    val in = Input ( UInt (2. W ) )
    val out = Valid(Output ( UInt (4. W ) ))
}
class decoder_with_valid extends Module {
    val io = IO ( new LM_IO_Interface_decoder_with_valid )
        io . out.bits := "b100" . U
        io.out.valid := 1.B
    switch(io.in){
        is("b00" . U ){
              io . out.bits := "b0001" . U
        io.out.valid := 0.B
        }
        is("b01" . U){
        io . out.bits := "b0010" . U
        io.out.valid := 1.B
        }
        is("b10" . U){
        io . out.bits := "b0011" . U
        io.out.valid := 1.B
        }
    }

}
