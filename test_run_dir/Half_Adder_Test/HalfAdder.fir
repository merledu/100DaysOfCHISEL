;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit HalfAdder : 
  module HalfAdder : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip a : UInt<4>, flip b : UInt<4>, sum : UInt<4>, carryout : UInt<4>}
    
    node _io_sum_T = xor(io.a, io.b) @[HalfAdder.scala 14:20]
    io.sum <= _io_sum_T @[HalfAdder.scala 14:12]
    node _io_carryout_T = and(io.a, io.b) @[HalfAdder.scala 15:25]
    io.carryout <= _io_carryout_T @[HalfAdder.scala 15:17]
    
