# Tasks

1. Provide the CNF of the following function and simplify it.

<br>

`f = NOT(abc + b(c + d) + NOT(c)d)`

2. Design the Boolean Circuit (using logical gates) to achieve the following function.

   Input: two numbers `A` and `B` with 3 bits

   - A = < a<sub>2</sub> a<sub>1</sub> a<sub>0</sub>>
   - B = < b<sub>2</sub> b<sub>1</sub> b<sub>0</sub>>

   Output: if A = B, then output 1, otherwise, output 0.

## Answers / Thought Process

Objective: Check if a<sub>n</sub> and b<sub>n</sub> are the same bit value - `0` or `1`. If ALL pairs of a<sub>n</sub> and b<sub>n</sub> are the **SAME**, then return `1`, otherwise return `0`. 

Truth Table for what `a` and `b` should return: 

| a | b | Value |
|:-:|:-:|------:|
| 0 | 0 |   1   |
| 0 | 1 |   0   |
| 1 | 0 |   0   |
| 1 | 1 |   1   |

Same bit values return 1 and different bit values return 0. 

We can achieve this Truth Table by doing `Not(Xor(a, b))`. `XOR` returns a `True` or `1` if both bit values are different, by applying `NOT` then we return `True` when both bit values for `a` and `b` are the **SAME**. 

<br> 

Objective 2: How to check if A is equal to B overall. 

Since the result of `Not(Xor(a, b))` returns `1` when the bit values are the same, we can use the `And` gate / logical operator because if it returns `1` then we know that all Bit Values are the same for A and B. 

