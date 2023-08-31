# Python Notes
""" Quick Introduction to Python Syntax and Functions """

# Python is loosely typed. Flexible with data types and changing them for variables

# Variable Declaration
x = 4
y = 5
_ = 1 # Yes, you can use an underscore as a variable

# Arithmetic Operations - this is not including addition, subtraction or multiplication
print(20.5 // 3) # // = floor division. Truncates decimal
print(2 ** 5) # Exponentiation = number after ** is exponent
print(10 % 5) # Value equals Remainder. 0 if no remainder. 

# If Statement
if (x > y): 
    print (x, 'is bigger than', y)
elif (x == y): # elif = else if, Python version of else if
    print (x, 'is equal to y')
else: 
    print (x, 'is not bigger than', y)

# Can also use keywords and, or, not to specify the conditions that must be met

# While Statement
while (y > _): 
    print (y)
    y -= 1

# For Statement 
for _ in range(4): 
    print(_)

# Cool Print Stuff
print("Welcome", "to", "Python") # Concantenate and add spaces 

for letter in "Programming": 
    print(letter, end=' ') # chooses the end value as a space rather than a new-line 

print(10, 20, 30, sep=",") # chooses what value should appear in between each value

print(f'This is what {x} is') # Formatted String. Able to input values where {} are located. 

# Functions

# General Syntax
def square (x, y):
    """ Returns the Square of a number """
    return x ** y

# Good to know
# *args = wildcard --> user can input as many parameters into function as they want. *args needs to be the right-most parameter. 
# as keyword can be used to define a library / module. statistics as stats. Think of it like a nickname
