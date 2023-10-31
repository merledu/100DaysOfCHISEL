package day33

import chisel3._
import chisel3.stage.ChiselStage
import chisel3.util._
import org.scalatest.FreeSpec
import chiseltest._

class UART_TxTesterTest extends FreeSpec with ChiselScalatestTester {
  "UART_Tx Module Test" in {
    test(new UART_Tx(UART_Params())) { c =>
      // Test sending a single character (8 bits)
      val characterToSend = 0x41 // ASCII code for 'A'
      c.io.en.poke(1.B)
      c.io.in.valid.poke(1.B)
      c.io.in.bits.poke(characterToSend.U)
      c.io.div.poke(10.U) // Set divisor (for baud rate)
      c.io.nstop.poke(2.U) // Set number of stop bits
      c.clock.step(10) // Simulate for some cycles
    }
  }
}
