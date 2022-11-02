;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit Condition : 
  module Condition : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip in : UInt<2>, out : UInt<4>}
    
    node _T = eq(io.in, UInt<1>("h00")) @[Conditions.scala 13:17]
    when _T : @[Conditions.scala 13:30]
      io.out <= UInt<1>("h01") @[Conditions.scala 14:16]
      skip @[Conditions.scala 13:30]
    else : @[Conditions.scala 15:36]
      node _T_1 = eq(io.in, UInt<1>("h01")) @[Conditions.scala 15:23]
      when _T_1 : @[Conditions.scala 15:36]
        io.out <= UInt<2>("h02") @[Conditions.scala 16:16]
        skip @[Conditions.scala 15:36]
      else : @[Conditions.scala 17:36]
        node _T_2 = eq(io.in, UInt<2>("h02")) @[Conditions.scala 17:23]
        when _T_2 : @[Conditions.scala 17:36]
          io.out <= UInt<3>("h04") @[Conditions.scala 18:16]
          skip @[Conditions.scala 17:36]
        else : @[Conditions.scala 19:17]
          io.out <= UInt<4>("h08") @[Conditions.scala 20:16]
          skip @[Conditions.scala 19:17]
    
