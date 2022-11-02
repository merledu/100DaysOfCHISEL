circuit HalfAdder :
  module HalfAdder :
    input clock : Clock
    input reset : UInt<1>
    input io_a : UInt<4>
    input io_b : UInt<4>
    output io_sum : UInt<4>
    output io_carryout : UInt<4>

    node _io_sum_T = xor(io_a, io_b) @[HalfAdder.scala 14:20]
    node _io_carryout_T = and(io_a, io_b) @[HalfAdder.scala 15:25]
    io_sum <= _io_sum_T @[HalfAdder.scala 14:12]
    io_carryout <= _io_carryout_T @[HalfAdder.scala 15:17]
