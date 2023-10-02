package day21

import chisel3._
import chisel3.util._

// Define a Chisel module called up_down_counter with a parameter 'max'
class up_down_counter(val max: Int) extends Module {
    // Define the module's IO ports
    val io = IO(new Bundle {
        val out = Output(UInt(log2Ceil(max).W)) // Output for the counter value
        val up_down = Input(Bool()) // Input to control count direction (up or down)
    })

    // Define a register called 'count' initialized to 0
    val count = RegInit(0.U(log2Ceil(max).W))

    // Check if 'up_down' is asserted (true) and 'count' is not at the maximum value
    when((io.up_down === true.B) && (count =/= (max.U - 1.U))) {
        count := count + 1.U // Increment 'count' if conditions are met
    }.elsewhen((io.up_down === false.B) || (count =/= 0.U)) {
        count := count - 1.U // Decrement 'count' if conditions are met
    }

    // Assign the value of 'count' to the 'out' output
    io.out := count
}
