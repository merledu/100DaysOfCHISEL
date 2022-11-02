;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit Concatenate : 
  module Concatenate : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip lowBits : UInt<2>, flip highBits : UInt<2>, concatenatedBits : UInt<4>}
    
    node _io_concatenatedBits_T = cat(io.highBits, io.lowBits) @[Cat.scala 30:58]
    io.concatenatedBits <= _io_concatenatedBits_T @[Concatenate.scala 14:25]
    
