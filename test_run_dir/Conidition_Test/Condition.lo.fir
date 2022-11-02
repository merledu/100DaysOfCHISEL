circuit Condition :
  module Condition :
    input clock : Clock
    input reset : UInt<1>
    input io_in : UInt<2>
    output io_out : UInt<4>

    node _T = eq(io_in, UInt<1>("h0")) @[Conditions.scala 13:17]
    node _T_1 = eq(io_in, UInt<1>("h1")) @[Conditions.scala 15:23]
    node _T_2 = eq(io_in, UInt<2>("h2")) @[Conditions.scala 17:23]
    node _GEN_0 = mux(_T_2, UInt<3>("h4"), UInt<4>("h8")) @[Conditions.scala 17:36 Conditions.scala 18:16 Conditions.scala 20:16]
    node _GEN_1 = mux(_T_1, UInt<2>("h2"), _GEN_0) @[Conditions.scala 15:36 Conditions.scala 16:16]
    node _GEN_2 = mux(_T, UInt<1>("h1"), _GEN_1) @[Conditions.scala 13:30 Conditions.scala 14:16]
    io_out <= _GEN_2
