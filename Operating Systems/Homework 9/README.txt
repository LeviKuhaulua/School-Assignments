Homework #9
Levi Kuhaulua

Hex: A - F => 10 - 15


Exercise #1:

1: 0xA56

Decimal: (10 * 16^2) + (5 * 16) + (6 * 1) 
       
        =>  256 * 10   +    80    +    6
        =>  2560 + 80 + 6
        =   2646d

Binary: 0xA56 => 2646d

2646d % 2d = 0
1323d % 2d = 1
661d  % 2d = 1
330d  % 2d = 0
165d  % 2d = 1
82d   % 2d = 0
41d   % 2d = 1
20d   % 2d = 0
10d   % 2d = 0
5d    % 2d = 1
2d    % 2d = 0
1d    % 2d = 1

= 1010 0101 0110b


2: 0x5CE

Decimal: (5 * 16^2) + (12 * 16) + 14
        
        => 5 * 256 + 192 + 14
        => 1280 + 192 + 14
        => 1486d

Binary: 1486d

1486d % 2d = 0
743d  % 2d = 1
371d  % 2d = 1
185d  % 2d = 1
92d   % 2d = 0
46d   % 2d = 0
23d   % 2d = 1
11d   % 2d = 1
5d    % 2d = 1
2d    % 2d = 0
1d    % 2d = 1

=> 1011 1001 110b


3: 1010 1101 1011 0110b

Decimal: 

0110 = (1 * 2^2) + (1 * 2^1) = 6d
1011 = (1 * 2^7) + (1 * 2^5) + (1 * 2^4) = 176d
1101 = (1 * 2^11) + (1 * 2^10) + (1 * 2^8) = 3328d
1010 = (1 * 2^15) + (1 * 2^13) = 40960d

=> 44470d

Hexadecimal: 44470d

44470d % 16d = 6
2779d  % 16d = B
173d   % 16d = D
10d    % 16d = A

=> 0xADB6

4: 256d

Binary: 2^8 or 0001 0000 0000b
Hex: 16^2 or 0x100


5: 1111 1111b

Decimal 
1111 = 1 * 2^3 + 1 * 2^2 + 1 * 2^1 + 1 * 2^0 = 15
1111 = 1 * 2^7 + 1 * 2^6 + 1 * 2^5 + 1 * 2^4 = 240

=> 255d

Hex: 

255d % 16d = F
15d  % 16d = F

0xFF


Exercise 2:

1:
  1 1 1 1 1           1 1 1 1 1 1   
  0 F E D C B A 0 1 2 3 4 5 6 7 8 9 
+ 0 0 9 8 7 6 5 4 3 2 1 F E D C B A
  1 0 8 6 4 1 F 4 4 4 5 4 4 4 4 4 3

Answer: 0x108641F4445444443

2:
  1 1 1           1     1 1 1 1 1  
  0 1 1 1 0 1 0 1 0 1 0 0 1 1 1 1 1
+ 0 1 1 1 0 0 1 0 0 1 1 0 0 0 1 0 1
  1 1 1 0 0 1 1 1 1 0 1 1 0 0 1 0 0

Answer = 0001 1100 1111 0110 0100b

3: 
                     15          19 20 21 22 23 25
                  9  16 17    2  3  4  5  6  7   
   F  E  D  C  B  A  0  1  2  3  4  5  6  7  8  9
-  0  9  8  7  6  5  4  3  2  1  F  E  D  C  B  A
   F  5  5  5  5  4  B  E  0  1  4  6  8  A  C  F
                                                
Answer = 0xF55554BE01468ACF

4:
             2    2  2  2
           0   0 1  0
  1 1 1 0  1 0 1 0  1 0 0 1  1 1 1 1
- 1 1 1 0  0 1 0 0  1 1 0 0  0 1 0 1
  0 0 0 0  0 1 0 1  1 1 0 1  1 0 1 0


Answer = 0101 1101 1010b


Exercise 4:

1: 1 MiB = 2^20 Bytes

2: 
1 MB = 10^6 bytes = 1,000,000 bytes
1 MiB = 2^20 bytes = 1,048,576 bytes

log (1,000,000) = 19.93156856933 (using calculator),
therefore, the answer is:

2^(19.93156856933)

3:

 4 KiB = 2^12
32 GiB = 2^35 

2^35 / 2^12 = 2^13 chunks


Exercise 5:

1: 
x / 7.

To find out how many 7-egg boxes you'll need to fit 'x' amount of eggs, 
divide the # of eggs by 7 or x / 7 to get the # of boxes. 

2: 
z = x mod 7;   where z < 7

This is because you won't have enough 'z' eggs to fill up all the spaces
of the last 7-egg box, so 'z' represents the remainder. 


Exercise #6:

8 GiB = 2^30 x 2^3 = 2^33

You'll need 33 bits to represent the 