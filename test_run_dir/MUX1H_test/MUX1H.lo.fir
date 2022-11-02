circuit MUX1H :
  module MUX1H :
    input clock : Clock
    input reset : UInt<1>
    input io_in0 : UInt<32>
    input io_in1 : UInt<32>
    input io_in2 : UInt<32>
    input io_in3 : UInt<32>
    input io_sel : UInt<4>
    output io_out : UInt<32>
    output io_out1 : UInt<32>

    node _io_out_T = bits(io_sel, 0, 0) @[Mux.scala 29:36]
    node _io_out_T_1 = bits(io_sel, 1, 1) @[Mux.scala 29:36]
    node _io_out_T_2 = mux(_io_out_T, io_in0, UInt<1>("h0")) @[Mux.scala 27:72]
    node _io_out_T_3 = mux(_io_out_T_1, io_in1, UInt<1>("h0")) @[Mux.scala 27:72]
    node _io_out_T_4 = or(_io_out_T_2, _io_out_T_3) @[Mux.scala 27:72]
    node _io_out1_T = bits(io_sel, 0, 0) @[Mux.scala 29:36]
    node _io_out1_T_1 = bits(io_sel, 1, 1) @[Mux.scala 29:36]
    node _io_out1_T_2 = mux(_io_out1_T, io_in2, UInt<1>("h0")) @[Mux.scala 27:72]
    node _io_out1_T_3 = mux(_io_out1_T_1, io_in3, UInt<1>("h0")) @[Mux.scala 27:72]
    node _io_out1_T_4 = or(_io_out1_T_2, _io_out1_T_3) @[Mux.scala 27:72]
    node _io_out_WIRE = _io_out_T_4 @[Mux.scala 27:72 Mux.scala 27:72]
    node _io_out1_WIRE = _io_out1_T_4 @[Mux.scala 27:72 Mux.scala 27:72]
    io_out <= _io_out_WIRE @[Mux 1H.scala 18:12]
    io_out1 <= _io_out1_WIRE @[Mux 1H.scala 19:13]
