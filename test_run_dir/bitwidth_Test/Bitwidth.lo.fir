circuit Bitwidth :
  module Bitwidth :
    input clock : Clock
    input reset : UInt<1>
    input io_input : UInt<4>
    output io_output : SInt<4>

    node _temp_T = asSInt(io_input) @[Bitwidth.scala 13:22]
    node temp = _temp_T @[Bitwidth.scala 12:20 Bitwidth.scala 13:10]
    io_output <= temp @[Bitwidth.scala 14:15]
