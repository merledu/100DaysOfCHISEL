circuit PARA_MUX :
  module PARA_MUX :
    input clock : Clock
    input reset : UInt<1>
    input io_in1 : UInt<32>
    input io_in2 : UInt<32>
    input io_sel : UInt<1>
    output io_out : UInt<32>

    node _io_out_T = mux(io_sel, io_in2, io_in1) @[parameterizedMux.scala 17:66]
    io_out <= _io_out_T @[parameterizedMux.scala 19:12]
