'''
Levi Kuhaulua
Dr. Crawford
09/20/2023

Character Count Frequency
Reading a text file and output the amount of characters found in the text in descending order
'''
from collections import Counter

# Step 1: Grab each line of the text file. 
lines = [line.strip() for line in open('test.txt', 'r', errors='ignore')]
# print(lines)

# Step 2: Grab each character of the text file 
characters = [char for line in lines for char in line if char.isalpha()]
# print(characters)

'''Alternative
characters = [ char for line in open('test.txt', 'r', errors='ignore') if char.isalpha() ] 
'''

# Step 3: Count each character frequency using a Dictionary instead. 
'''chars_in_file = {} 

for line in open('test.txt', 'r', errors='ignore'): 
    for char in line: 
        if char.isalpha(): 
            if char in chars_in_file: 
                chars_in_file[char] += 1
            else: 
                chars_in_file[char] = 1

descending_order = sorted(chars_in_file.items(), key= lambda char: char[1], reverse=True)

print("Character Count")
for (char, quantity) in descending_order: 
    print(f'{char:<12}{quantity}')'''

# Step 4: Count each character frequency using Counter from Collections
count_char = Counter([ char for line in open('test.txt', 'r', errors='ignore') for char in line if char.isalpha() ])

print('Character Count')
for char, quantity in count_char.most_common(): 
    print(f'{char:<12}{quantity}')

# Step 5: Count each character frequency using a Generator Expression


'''for char, quantity in ( count_char.items() ): 
    print(f'{char:<12}{quantity}')'''
