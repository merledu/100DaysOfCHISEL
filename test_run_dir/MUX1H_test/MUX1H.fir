;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit MUX1H : 
  module MUX1H : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip in0 : UInt<32>, flip in1 : UInt<32>, flip in2 : UInt<32>, flip in3 : UInt<32>, flip sel : UInt<4>, out : UInt<32>, out1 : UInt<32>}
    
    node _io_out_T = bits(io.sel, 0, 0) @[Mux.scala 29:36]
    node _io_out_T_1 = bits(io.sel, 1, 1) @[Mux.scala 29:36]
    node _io_out_T_2 = mux(_io_out_T, io.in0, UInt<1>("h00")) @[Mux.scala 27:72]
    node _io_out_T_3 = mux(_io_out_T_1, io.in1, UInt<1>("h00")) @[Mux.scala 27:72]
    node _io_out_T_4 = or(_io_out_T_2, _io_out_T_3) @[Mux.scala 27:72]
    wire _io_out_WIRE : UInt<32> @[Mux.scala 27:72]
    _io_out_WIRE <= _io_out_T_4 @[Mux.scala 27:72]
    io.out <= _io_out_WIRE @[Mux 1H.scala 18:12]
    node _io_out1_T = bits(io.sel, 0, 0) @[Mux.scala 29:36]
    node _io_out1_T_1 = bits(io.sel, 1, 1) @[Mux.scala 29:36]
    node _io_out1_T_2 = mux(_io_out1_T, io.in2, UInt<1>("h00")) @[Mux.scala 27:72]
    node _io_out1_T_3 = mux(_io_out1_T_1, io.in3, UInt<1>("h00")) @[Mux.scala 27:72]
    node _io_out1_T_4 = or(_io_out1_T_2, _io_out1_T_3) @[Mux.scala 27:72]
    wire _io_out1_WIRE : UInt<32> @[Mux.scala 27:72]
    _io_out1_WIRE <= _io_out1_T_4 @[Mux.scala 27:72]
    io.out1 <= _io_out1_WIRE @[Mux 1H.scala 19:13]
    
