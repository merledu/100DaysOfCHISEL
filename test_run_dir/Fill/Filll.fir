;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit Filll : 
  module Filll : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip fill : UInt<2>, out : UInt<6>}
    
    node io_out_lo = cat(io.fill, io.fill) @[Cat.scala 30:58]
    node _io_out_T = cat(io.fill, io_out_lo) @[Cat.scala 30:58]
    io.out <= _io_out_T @[Filll.scala 13:12]
    
