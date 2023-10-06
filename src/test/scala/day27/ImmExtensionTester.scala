package day27

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class ImmExtensionTester extends FreeSpec with ChiselScalatestTester {

  "Immediate Extension Tester " in {
    test(new ImmExtension){ dut =>
        val hexValue = "00900093"
        // Convert hexadecimal string to BigInt and then to UInt
        val intValue = BigInt(hexValue, 16)
        dut.io.instr.poke(intValue.U)
        dut.io.pc_in.poke(4.S)
        dut.clock.step(10)
        dut.io.immd_se.expect(9.U)
        }
    }
}
