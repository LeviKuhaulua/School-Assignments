#1: 
./memory  70,0,0,0
produces this output:

0 | 1024 | 1152 | 2176 | 2304 | 3328 | 3360 | 4384 | 4512 | 
--------------
The 70-byte chunk was allocated at address 2234
would you conclude that the heap allocator allocates new chunks of RAM at the beginning (i.e., lower addresses) or at the end (i.e., higher addresses) of holes in memory? To explain why, use a contraposition argument (e.g., if the heap allocator did X then Y would happen, but instead Z happens).

The heap allocator allocates new chunks of RAM at the beginning. 
Let's assume that the 70-byte chunk would be allocated to the 
end of the holes in memory, then by that it would've chosen
any of the holes in memory starting at address 2,256 and ending at 4,512,
however, it chooses address 2,234 which is at the lower end of the addreses.
Therefore, the heap allocator allocates at the beginning holes in memory. 

* Higher holes in memory => 4512 / 2 = 2256


#2: 
./memory  80,20,30,10
produces this output:

0 | 1024 | 1152 | 2176 | 2304 | 3328 | 3360 | 4384 | 4512 | 

--------------
The 80-byte chunk was allocated at address 1072
The 20-byte chunk was allocated at address 1052
The 30-byte chunk was allocated at address 3330
The 10-byte chunk was allocated at address 4502
would you say that the heap allocator uses

first fit
best fit
worst fit
none of the above?

First fit:
Holes: 
1052 -> 1152 (100 bytes)
3330 -> 3360 (30 bytes)
4502 -> 4512 (10 bytes)

When 80, we choose the biggest hole that can supply it and start it at 1072. 
Then when 20 arrives, we then choose the next biggest hole which is at address 1052. Then 30, we choose address 3330 for 30 bytes to be
allocated and then 10 to be allocated at 4502. 



#3: 
./memory  1100,105,100,20
produces this output:

0 | 1024 | 1152 | 2176 | 2304 | 3328 | 3360 | 4384 | 4512 | 
--------------
The 1100-byte chunk was allocated at address 52
The 105-byte chunk was allocated at address 2199
The 100-byte chunk was allocated at address 4412
The 20-byte chunk was allocated at address 2179
would you say that the heap allocator uses

first fit
best fit
worst fit
none of the above?

Holes:
52 -> 1152 (1152 bytes)
2199 -> 2304 (105 bytes)
4412 -> 4512 (100 bytes)
2179 -> 2199 (20 bytes)

worst fit: 
this is because of the 100-byte chunk that was allocated at address 4412
this means that the heap allocator chose 4412 to be the 100-byte chunk
even though it is not the leftmost hole because it is the biggest hole that
the 100-byte chunk can have. Which is why the 20-byte chunk is allocated at 
2179 instead because that is the biggest hole after 100-byte chunk is done. 

4:
Input: 500,100,100,20
0 | 1024 | 1152 | 2176 | 2304 | 3328 | 3360 | 4384 | 4512 | 

unsigned long sizes[9] = {1024, 128, 1024, 128, 1024, 32, 1024, 128, 1024}; 

Every even i (including 0): prts[i] = (char *)calloc(1024, 1)
Every odd i: prts[i] = (char *)calloc(128, 1)
EXCEPT i = 5 where prts[5] = (char *)calloc(32, 1)

free(ptrs[0]); free(ptrs[1]); free(ptrs[3]); free(ptrs[5]); free(ptrs[7]);
1024 bytes;    128 bytes;     128 bytes;     32 bytes;      128 bytes; 
0 -> 1024      1024 -> 1152   2176 -> 2304   3328 -> 3360   4384 -> 4512

Holes: 0 -> 1152, 2176 -> 2304, 3328 -> 3360, 4383 -> 4512 

Output: 
The 500-byte chunk was allocated at address 256.
The 100-byte chunk was allocated at address 2240.
The 100-byte chunk was allocated at address 4448.
The 20-byte chunk was allocated at address  3360