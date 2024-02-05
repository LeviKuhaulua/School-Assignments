# Tasks 

1. Create Half-Adder and Full-Adder Gate 
2. Create the Add16 Gate

<br> 

## Thought Process: 

### Half-Adder Gate

Truth-Table: 


| `a` | `b` | sum | carry | 
|:---:|:---:|----:|------:|
|  0  |  0  |  0  |  0    |
|  0  |  1  |  1  |  0    | 
|  1  |  0  |  1  |  0    | 
|  1  |  1  |  0  |  1    | 

- The **carry** only occurs when both `a` and `b` are `1` 
- `a`, `b` and `sum` can be handled by the `Xor` gate 
- `a`, `b`, and `carry` can be handled by the `And` gate

### Full-Adder Gate

Truth-Table: 

| a | b | c | sum | carry |
|:-:|:-:|:-:|----:|------:|
| 0 | 0 | 0 |   0 |     0 |
| 0 | 0 | 1 |   1 |     0 |
| 0 | 1 | 0 |   1 |     0 |
| 0 | 1 | 1 |   0 |     1 |
| 1 | 0 | 0 |   1 |     0 |
| 1 | 0 | 1 |   0 |     1 |
| 1 | 1 | 0 |   0 |     1 |
| 1 | 1 | 1 |   1 |     1 |

- Carry occurs when at least two variables are `1` 
- Sum can only be `1` when two or all variables are `1`  

Sum can still be represented by `Xor` gate then finding the equivalency to handle 3 input pings. 

Sum: A **xor** B **xor** C ==> [(A **xor** B) **and** (**not** C)] **or** [(**not** A **xor** B) **and** C]  

<br> 

Carry: [A **and** B] **or** [(A **xor** B) **and** C]

### Add16

Can be represented by 16 `FullAdder` Gates. 



