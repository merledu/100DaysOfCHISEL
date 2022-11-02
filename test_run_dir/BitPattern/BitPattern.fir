;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit BitPattern : 
  module BitPattern : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip in : UInt<8>, out : UInt<1>}
    
    node _T = and(io.in, UInt<8>("h09e")) @[BitPattern.scala 17:17]
    node _T_1 = eq(UInt<5>("h016"), _T) @[BitPattern.scala 17:17]
    when _T_1 : @[BitPattern.scala 17:30]
      io.out <= UInt<1>("h01") @[BitPattern.scala 18:16]
      skip @[BitPattern.scala 17:30]
    else : @[BitPattern.scala 19:17]
      io.out <= UInt<1>("h00") @[BitPattern.scala 20:16]
      skip @[BitPattern.scala 19:17]
    
