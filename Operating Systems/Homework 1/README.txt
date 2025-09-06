# Homework 1
# Levi Kuhaulua


# Key Information
* First 3 bits give the instruction
* Next bit identifies register: 0 = A, 1 = B
* Last 5 bits is operand, these last 5 bits will depend on instruction

=================

Part 1 

1.1: What does the instruction encoded by 110010001 do? Show your work.

110 = JE
0 = Ignore because we care about operand
10001 = Operand

JE, [10001] so set PC to value in address [10001] if there is error in error register. 


1.2: Translate “LOAD A, [10110]” to binary. Show your work.

LOAD instruction = 010
Register A = 0
Operand = [10110]

010010110


1.3: Among the instruction encodings below, which one is invalid? Give an explanation.

1. 110101100
2. 100110111
3. 011110100

2 is wrong because the opcode is 100 however we don't have 100 in the CPU instruction set, so it is invalid. 

==============================

Part 2

Assume that initially:

The Program Counter value is set to 12d=01100b; The values of the other registers are undefined.


2.1: What is the address and the first instruction executed by the program? Explain.

The address and the first instruction executed by the program is address [01100b] because that is what the program counter is set to.

2.2: Detail the program execution instruction by instruction (the program stops after executing the first STOP).

1st step: 010010110;  LOAD A, [10110]; A = 111000001b = 449d

2nd Step: 010110111;  LOAD B, [10111]; B = 010111100b = 188d

3rd Step: 101100000;  ADD A, B; 449 + 188 results in overflow so we set error register to 1

4th Step: 110010001; JE, [10001]; Set PC to value in [10001] since error register is 1

5th Step: 111000000;   Program terminates

2.3:

What is the content at address 10010 after the program in Question 2.2 has completed? 010010111

What is the content at address 10110 after the program in Question 2.2 has completed? 111000001


2.4:
The last STORE instruction writes to memory the output of the program. 
What does this program compute? Also consider other cases with different input values. Explain.

I think the program computes and returns the sum of 2 different numbers as long as they don't overflow.
If there are smaller numbers that are added that don't add up to 512, then we can successfully return the sum.
Otherwise we get an error.