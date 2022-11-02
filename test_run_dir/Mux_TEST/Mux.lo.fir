circuit Mux :
  module Mux :
    input clock : Clock
    input reset : UInt<1>
    input io_a : SInt<4>
    input io_b : SInt<4>
    input io_sel : UInt<1>
    output io_out : SInt<4>

    node _io_out_T = mux(io_sel, io_a, io_b) @[Mux.scala 14:18]
    io_out <= _io_out_T @[Mux.scala 14:12]
