
<h1 align="center">Wires, Data Types & TypeCasting</h1>
<h2 align="left">Wires:</h2>
<p> Wires in CHISEL are a utility for constructing hardware wires.</p>
<img src= "https://user-images.githubusercontent.com/110234585/194366236-a28d8abb-6ff2-4fc6-9b38-7bdc45cfe99f.PNG"</img>
<p> The given code explains the usage of Wires in a CHISEL code. 
<h2 align="left"> Data Types:</h2>
<p> Chisel datatypes are used to specify the type of values held in state elements or flowing on wires.</p>
<p>Some of the CHISEL Data Types are:</p>
<p> - Unsigned Integer (UInt)</p>
<p> - Signed Integer (SInt) </p>
<p> - Boolean (Bool) </p>

<p><b> Example:</p></b>

![bundle](https://user-images.githubusercontent.com/110234585/194366200-6472a61c-ddf7-4ace-b130-4230ead363f8.PNG)
 <h2 align="left"> TypeCasting:</h2>
 <p> Typecast is a way of changing an object from one data type to the next.</p>

![tp](https://user-images.githubusercontent.com/110234585/194366217-4c8fbf2c-c037-4518-adb2-d2aab5da2d8d.PNG)
  <p>In the above example io.input is being typecasted in to Signed Integer (SInt) by the use of syntax ".asSInt".
</p> 
<h2 align="left">Bitwidth:</h2>
<p> Bitwidth in a CHISEL code helps in explicitly defining the bits of any data.</p>
\