;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit Mux : 
  module Mux : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip a : SInt<4>, flip b : SInt<4>, flip sel : UInt<1>, out : SInt<4>}
    
    node _io_out_T = mux(io.sel, io.a, io.b) @[Mux.scala 14:18]
    io.out <= _io_out_T @[Mux.scala 14:12]
    
