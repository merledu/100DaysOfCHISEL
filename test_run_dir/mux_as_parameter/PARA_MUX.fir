;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit PARA_MUX : 
  module PARA_MUX : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip in1 : UInt<32>, flip in2 : UInt<32>, flip sel : UInt<1>, out : UInt<32>}
    
    node _io_out_T = mux(io.sel, io.in2, io.in1) @[parameterizedMux.scala 17:66]
    io.out <= _io_out_T @[parameterizedMux.scala 19:12]
    
