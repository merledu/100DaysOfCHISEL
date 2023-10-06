# README for LM_IO_Interface_ImmdValGen and ImmExtension

This repository contains Chisel code for a module that performs immediate value generation based on the RISC-V architecture. The code is organized into several components, including IO interfaces and the main module.

## LM_IO_Interface_ImmdValGen

### IO Definition

The `LM_IO_Interface_ImmdValGen` bundle defines the input and output ports for the immediate value generation module.

- `instr`: Input, UInt(32.W)
  - Description: 32-bit instruction input.
- `pc_in`: Input, SInt(32.W)
  - Description: 32-bit signed program counter input.
- `immd_se`: Output, UInt(32.W)
  - Description: 32-bit signed immediate output.

## imm Object


The `imm` object contains opcode values defined according to the RISC-V standard. These opcode values are used to identify different instruction types during immediate extension.

- `i`: 19.U(7.W)
  - Description: i-type opcode.
- `s`: 35.U(7.W)
  - Description: s-type opcode.
- `sb`: 99.U(7.W)
  - Description: sb-type opcode.
- `u`: 55.U(7.W)
  - Description: u-type opcode.
- `uj`: 111.U(7.W)
  - Description: uj-type opcode.
- `ei`: 0.U(32.W)
  - Description: Extra immediate, defined as zero in the immediate.

## ImmExtension Module

### IO Definition

The `ImmExtension` module uses the IO definition from `LM_IO_Interface_ImmdValGen`. It takes an instruction (`instr`) and a program counter (`pc_in`) as inputs and produces the immediate value (`immd_se`) as output.

### Immediate Extension Logic

The immediate extension logic is implemented using nested `Mux` statements based on the opcode values from the `imm` object. Different instruction types are identified, and the immediate value is extended accordingly.

## ImmExtensionTester

The `ImmExtensionTester` is a ScalaTest specification for testing the `ImmExtension` module. It includes a test case where an instruction is poked into the module, and the result is checked against the expected immediate value after a certain number of clock cycles.

Feel free to adapt and modify the code according to your specific requirements.
