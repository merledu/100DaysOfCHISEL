circuit Filll :
  module Filll :
    input clock : Clock
    input reset : UInt<1>
    input io_fill : UInt<2>
    output io_out : UInt<6>

    node io_out_lo = cat(io_fill, io_fill) @[Cat.scala 30:58]
    node _io_out_T = cat(io_fill, io_out_lo) @[Cat.scala 30:58]
    io_out <= _io_out_T @[Filll.scala 13:12]
