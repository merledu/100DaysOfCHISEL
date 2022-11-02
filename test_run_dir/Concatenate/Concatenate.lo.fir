circuit Concatenate :
  module Concatenate :
    input clock : Clock
    input reset : UInt<1>
    input io_lowBits : UInt<2>
    input io_highBits : UInt<2>
    output io_concatenatedBits : UInt<4>

    node _io_concatenatedBits_T = cat(io_highBits, io_lowBits) @[Cat.scala 30:58]
    io_concatenatedBits <= _io_concatenatedBits_T @[Concatenate.scala 14:25]
