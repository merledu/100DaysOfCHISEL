;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit Gates : 
  module Gates : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip a : UInt<4>, flip b : UInt<4>, AND : UInt<4>, OR : UInt<4>, XOR : UInt<4>, NOT : UInt<4>, NAND : UInt<4>, NOR : UInt<4>, XNOR : UInt<4>}
    
    node _io_AND_T = and(io.a, io.b) @[Gates.scala 24:20]
    io.AND <= _io_AND_T @[Gates.scala 24:12]
    node _io_OR_T = or(io.a, io.b) @[Gates.scala 25:19]
    io.OR <= _io_OR_T @[Gates.scala 25:11]
    node _io_XOR_T = xor(io.a, io.b) @[Gates.scala 26:20]
    io.XOR <= _io_XOR_T @[Gates.scala 26:12]
    node _io_NOT_T = not(io.a) @[Gates.scala 27:15]
    io.NOT <= _io_NOT_T @[Gates.scala 27:12]
    node _io_NAND_T = and(io.a, io.b) @[Gates.scala 28:23]
    node _io_NAND_T_1 = not(_io_NAND_T) @[Gates.scala 28:16]
    io.NAND <= _io_NAND_T_1 @[Gates.scala 28:13]
    node _io_NOR_T = or(io.a, io.b) @[Gates.scala 29:22]
    node _io_NOR_T_1 = not(_io_NOR_T) @[Gates.scala 29:15]
    io.NOR <= _io_NOR_T_1 @[Gates.scala 29:12]
    node _io_XNOR_T = xor(io.a, io.b) @[Gates.scala 30:23]
    node _io_XNOR_T_1 = not(_io_XNOR_T) @[Gates.scala 30:16]
    io.XNOR <= _io_XNOR_T_1 @[Gates.scala 30:13]
    
