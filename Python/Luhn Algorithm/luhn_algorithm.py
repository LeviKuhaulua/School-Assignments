# psuedo-code 


# Levi Kuhaulua
# Dr. Crawford
# 10-04-2023
# Luhn's Algorithm 
# Create a program that will validate the Check-Digit number of an account number. Assume that check-digit number is the last digit.

id = '37648' 
payload = [ x for x in id[:-1] ] 
check_digit = int(id[-1])
check_sum = 0

# Intialized Dictionary containing values when doing Luhn's Algorithm. 
luhn_v = {"0": 0, "1": 2, "2": 4, "3": 6, "4": 8, \
    "5": 1, "6": 3, "7": 5, "8": 7, "9": 9}

even_digits = [ luhn_v.get(x) for x in payload[-1::-2] ] # Get the corresponding value for each key. 
odd_digits = [ int(x) for x in payload[-2::-2] ] 

check_sum = 10 - (sum(even_digits + odd_digits) % 10) # finds the supposed check-digit. 

# Debug. 
if check_sum == check_digit: print("It's right")
else: print("time to debug.") 

    

