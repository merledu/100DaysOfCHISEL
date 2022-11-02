circuit Gates :
  module Gates :
    input clock : Clock
    input reset : UInt<1>
    input io_a : UInt<4>
    input io_b : UInt<4>
    output io_AND : UInt<4>
    output io_OR : UInt<4>
    output io_XOR : UInt<4>
    output io_NOT : UInt<4>
    output io_NAND : UInt<4>
    output io_NOR : UInt<4>
    output io_XNOR : UInt<4>

    node _io_AND_T = and(io_a, io_b) @[Gates.scala 24:20]
    node _io_OR_T = or(io_a, io_b) @[Gates.scala 25:19]
    node _io_XOR_T = xor(io_a, io_b) @[Gates.scala 26:20]
    node _io_NOT_T = not(io_a) @[Gates.scala 27:15]
    node _io_NAND_T = and(io_a, io_b) @[Gates.scala 28:23]
    node _io_NAND_T_1 = not(_io_NAND_T) @[Gates.scala 28:16]
    node _io_NOR_T = or(io_a, io_b) @[Gates.scala 29:22]
    node _io_NOR_T_1 = not(_io_NOR_T) @[Gates.scala 29:15]
    node _io_XNOR_T = xor(io_a, io_b) @[Gates.scala 30:23]
    node _io_XNOR_T_1 = not(_io_XNOR_T) @[Gates.scala 30:16]
    io_AND <= _io_AND_T @[Gates.scala 24:12]
    io_OR <= _io_OR_T @[Gates.scala 25:11]
    io_XOR <= _io_XOR_T @[Gates.scala 26:12]
    io_NOT <= _io_NOT_T @[Gates.scala 27:12]
    io_NAND <= _io_NAND_T_1 @[Gates.scala 28:13]
    io_NOR <= _io_NOR_T_1 @[Gates.scala 29:12]
    io_XNOR <= _io_XNOR_T_1 @[Gates.scala 30:13]
