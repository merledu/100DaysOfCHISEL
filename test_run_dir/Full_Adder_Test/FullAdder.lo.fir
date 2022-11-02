circuit FullAdder :
  module FullAdder :
    input clock : Clock
    input reset : UInt<1>
    input io_a : UInt<4>
    input io_b : UInt<4>
    input io_c : UInt<4>
    output io_sum : UInt<4>
    output io_carryout : UInt<4>

    node _io_sum_T = xor(io_a, io_b) @[FullAdder.scala 15:20]
    node _io_sum_T_1 = xor(_io_sum_T, io_c) @[FullAdder.scala 15:27]
    node _io_carryout_T = and(io_a, io_b) @[FullAdder.scala 16:26]
    node _io_carryout_T_1 = xor(io_a, io_b) @[FullAdder.scala 16:42]
    node _io_carryout_T_2 = and(_io_carryout_T_1, io_c) @[FullAdder.scala 16:50]
    node _io_carryout_T_3 = or(_io_carryout_T, _io_carryout_T_2) @[FullAdder.scala 16:34]
    io_sum <= _io_sum_T_1 @[FullAdder.scala 15:12]
    io_carryout <= _io_carryout_T_3 @[FullAdder.scala 16:17]
