
Exercise 1:
page size = 8 KiB = 2^13 bytes = 8192 bytes;
Logical has pages from 0-15 or 2^16 = 65536 bytes
Physical has frames from 0-13 or 2^14 = 16384 bytes

a) 20

20 // 8192 = 0 so 20 is in page 0
Page 0 maps to frame 13
20 mod 8192 = 20 = offset

13 * 1892 + 20 = 106516 = physical address

b) 9100

9100 // 8192 = 1 so 9100 is in page 1
Page 1 maps to frame 8
9100 mod 8192 = 971 = offset

8 * 8192 + 971 = 66507

c) 50321

50321 // 8192 = 6 so 50321 is in page 6
page 6 maps to an invalid entry so an error occurs. 

d) 81589

81589 // 8192 = 9 so 81589 is in page 9
page 9 maps to frame 2 
81589 mod 8192 = 7861 = offset

2 * 8192 + 7861 = 24245

Exercise 2: 

32 pages = 2^5 pages; 5 bits to address
page size = 2048 = 2^11 bytes; 
8 frames = 2^3 frames; 3 bits to address

a) 
take page size bits and add page bits to get the bits for logical address
5 + 11 = 16 bits for the logical address

b) 
take frame size bits and add page size bits to get the physical address
3 + 11 = 14 bits for the physical address


Exercise 3:
32-bit logical address = 2^32
8 KiB page size = 2^13 or 13 bits to address
2 GiB physical memory = 2^31 or 31 bits to address



a) conventional single-level page table

logical address / page size => 2^32 / 2^13 = 2^19

b) inverted page table

physical memory / page size = 2^31 / 2^13 = 2^18

Exercise 4:
38-bit logical address = 2^38
32 KiB page size = 2^15 KiB
8 bytes per table entry = 2^3


a) 

# of pages: 2^38 / 2^15 = 2^23 (8 MiB)

b) 

2^15 KiB = 15 bits to address; offset = 15

inner table = 2^15 / 2^3 = 2^12, 12 bits
outer table = 38 - 12 - 15 = 11 bits

c) 
if the inner table takes 2^12 page entries,
the outer table takes 2^11 page entries,
and we have a page size of 2^15 then: 

2^12 + 2^11 + 2^15 gives us the memory in # of page frames