;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit FullAdder : 
  module FullAdder : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip a : UInt<4>, flip b : UInt<4>, flip c : UInt<4>, sum : UInt<4>, carryout : UInt<4>}
    
    node _io_sum_T = xor(io.a, io.b) @[FullAdder.scala 15:20]
    node _io_sum_T_1 = xor(_io_sum_T, io.c) @[FullAdder.scala 15:27]
    io.sum <= _io_sum_T_1 @[FullAdder.scala 15:12]
    node _io_carryout_T = and(io.a, io.b) @[FullAdder.scala 16:26]
    node _io_carryout_T_1 = xor(io.a, io.b) @[FullAdder.scala 16:42]
    node _io_carryout_T_2 = and(_io_carryout_T_1, io.c) @[FullAdder.scala 16:50]
    node _io_carryout_T_3 = or(_io_carryout_T, _io_carryout_T_2) @[FullAdder.scala 16:34]
    io.carryout <= _io_carryout_T_3 @[FullAdder.scala 16:17]
    
