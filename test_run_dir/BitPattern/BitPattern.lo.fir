circuit BitPattern :
  module BitPattern :
    input clock : Clock
    input reset : UInt<1>
    input io_in : UInt<8>
    output io_out : UInt<1>

    node _T = and(io_in, UInt<8>("h9e")) @[BitPattern.scala 17:17]
    node _T_1 = eq(UInt<5>("h16"), _T) @[BitPattern.scala 17:17]
    node _GEN_0 = mux(_T_1, UInt<1>("h1"), UInt<1>("h0")) @[BitPattern.scala 17:30 BitPattern.scala 18:16 BitPattern.scala 20:16]
    io_out <= _GEN_0
