;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit Bitwidth : 
  module Bitwidth : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip input : UInt<4>, output : SInt<4>}
    
    wire temp : SInt<4> @[Bitwidth.scala 12:20]
    node _temp_T = asSInt(io.input) @[Bitwidth.scala 13:22]
    temp <= _temp_T @[Bitwidth.scala 13:10]
    io.output <= temp @[Bitwidth.scala 14:15]
    
