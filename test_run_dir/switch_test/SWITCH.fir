;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit SWITCH : 
  module SWITCH : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip sel : UInt<3>, flip in_a : UInt<32>, flip in_b : UInt<32>, out : UInt<2>}
    
    io.out <= UInt<1>("h00") @[switch.scala 26:12]
    node _T = eq(UInt<1>("h00"), io.sel) @[Conditional.scala 37:30]
    when _T : @[Conditional.scala 40:58]
      node _io_out_T = add(io.in_a, io.in_b) @[switch.scala 29:31]
      node _io_out_T_1 = tail(_io_out_T, 1) @[switch.scala 29:31]
      io.out <= _io_out_T_1 @[switch.scala 29:20]
      skip @[Conditional.scala 40:58]
    else : @[Conditional.scala 39:67]
      node _T_1 = eq(UInt<1>("h01"), io.sel) @[Conditional.scala 37:30]
      when _T_1 : @[Conditional.scala 39:67]
        node _io_out_T_2 = sub(io.in_a, io.in_b) @[switch.scala 32:31]
        node _io_out_T_3 = tail(_io_out_T_2, 1) @[switch.scala 32:31]
        io.out <= _io_out_T_3 @[switch.scala 32:20]
        skip @[Conditional.scala 39:67]
      else : @[Conditional.scala 39:67]
        node _T_2 = eq(UInt<2>("h02"), io.sel) @[Conditional.scala 37:30]
        when _T_2 : @[Conditional.scala 39:67]
          node _io_out_T_4 = div(io.in_a, io.in_b) @[switch.scala 35:31]
          io.out <= _io_out_T_4 @[switch.scala 35:20]
          skip @[Conditional.scala 39:67]
        else : @[Conditional.scala 39:67]
          node _T_3 = eq(UInt<2>("h03"), io.sel) @[Conditional.scala 37:30]
          when _T_3 : @[Conditional.scala 39:67]
            node _io_out_T_5 = mul(io.in_a, io.in_b) @[switch.scala 38:31]
            io.out <= _io_out_T_5 @[switch.scala 38:20]
            skip @[Conditional.scala 39:67]
    
