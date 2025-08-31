# Homework 1
# Levi Kuhaulua


# Key Information
* First 3 bits give the instruction
* Next bit identifies register: 0 = A, 1 = B
* Last 5 bits is operand, these last 5 bits will depend on instruction

=================

Part 1 


1.1: What does the instruction encoded by 110010001 do? Show your work.

110 = JE or Jump on Error 
0 = Register A however, we're ignoring it b/c we need to check the error register
10001 = Address [10001]

When checking Error Register: 

Error register is 0:
Since there is no error, we are going to increment the Program Counter by 1 and reset value of error register to 0

Error register is 1: 
Since there is an error, we are going to set the value of the PC to the operand, in this case, it's going to be 10001. 


1.2: Translate “LOAD A, [10110]” to binary. Show your work.

LOAD instruction = 010
Register A = 0
Operand = [10110]

Combining in that order gives us 010010110


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

We know that the PC stores the address of the NEXT instruction, which is 01100 so if 01100 is the next instruction
then the first instruction's address must be the one before it which is 01011. 

The contents of 01011 is 010000001, when translated:

010 = LOAD
0 = Register A
00001 = Address [00001]

So we set value of A with the content of Address [00001] 

A's content  = 110101001b = 425d

Then we set the value of the error register to 0 based on instructions for LOAD.



2.2: Detail the program execution instruction by instruction (the program stops after executing the first STOP).

LOAD A, [00001]; Set value of A to 110101001b = 425d
LOAD A, [10110]; Set value of A to 111000001b = 449d (override previous value stored in A)
LOAD B, [10111]; Set value of B to 010111100b = 188d
ADD A, B; Add value from B to value from A and store result in A. Leads to overflow error, so set value of error register to 1
JE 10001; Jump to instruction at address 10001
STOP; terminate program


2.3:

What is the content at address 10010 after the program in Question 2.2 has completed? 010010111

What is the content at address 10110 after the program in Question 2.2 has completed? 111000001


2.4:

The last STORE instruction writes to memory the output of the program. 
What does this program compute? Also consider other cases with different input values. Explain.

I think the program computes the sum of 2 numbers that the user provides. If the user doesn't provide a
value then it will default to the first number. If the 2nd number is big where it causes an overflow then the register will store
-1. 
