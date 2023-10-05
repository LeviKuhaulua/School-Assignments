# Levi Kuhaulua
# Dr. Crawford
# 10-04-2023
# Luhn's Algorithm 
# Create a program that will validate the Check-Digit number of an account number. Assume that check-digit number is the last digit.

id = '37648' 
# Intialized Dictionary containing values when doing Luhn's Algorithm. 
luhn_v = {"0": 0, "1": 2, "2": 4, "3": 6, "4": 8, \
    "5": 1, "6": 3, "7": 5, "8": 7, "9": 9}
if 10 - (sum([ luhn_v.get(x) for x in id[-2::-2]] + [ int(x) for x in id[-3::-2]]) % 10) == int(id[-1]): print('it matches up') 
else: print("it doesn't match up") 


    


