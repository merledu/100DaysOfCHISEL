circuit SWITCH :
  module SWITCH :
    input clock : Clock
    input reset : UInt<1>
    input io_sel : UInt<3>
    input io_in_a : UInt<32>
    input io_in_b : UInt<32>
    output io_out : UInt<2>

    node _T = eq(UInt<1>("h0"), io_sel) @[Conditional.scala 37:30]
    node _io_out_T = add(io_in_a, io_in_b) @[switch.scala 29:31]
    node _io_out_T_1 = tail(_io_out_T, 1) @[switch.scala 29:31]
    node _T_1 = eq(UInt<1>("h1"), io_sel) @[Conditional.scala 37:30]
    node _io_out_T_2 = sub(io_in_a, io_in_b) @[switch.scala 32:31]
    node _io_out_T_3 = tail(_io_out_T_2, 1) @[switch.scala 32:31]
    node _T_2 = eq(UInt<2>("h2"), io_sel) @[Conditional.scala 37:30]
    node _io_out_T_4 = div(io_in_a, io_in_b) @[switch.scala 35:31]
    node _T_3 = eq(UInt<2>("h3"), io_sel) @[Conditional.scala 37:30]
    node _io_out_T_5 = mul(io_in_a, io_in_b) @[switch.scala 38:31]
    node _GEN_0 = mux(_T_3, _io_out_T_5, UInt<1>("h0")) @[Conditional.scala 39:67 switch.scala 38:20 switch.scala 26:12]
    node _GEN_1 = mux(_T_2, _io_out_T_4, _GEN_0) @[Conditional.scala 39:67 switch.scala 35:20]
    node _GEN_2 = mux(_T_1, _io_out_T_3, _GEN_1) @[Conditional.scala 39:67 switch.scala 32:20]
    node _GEN_3 = mux(_T, _io_out_T_1, _GEN_2) @[Conditional.scala 40:58 switch.scala 29:20]
    io_out <= bits(_GEN_3, 1, 0)
