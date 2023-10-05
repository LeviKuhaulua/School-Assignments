# Luhn's Algorithm 

What is [Luhn's Algorithm](https://en.wikipedia.org/wiki/Luhn_algorithm)? This algorithm is used to verify ID numbers for information like credit cards or gift cards by verifying that the operations performed on the numbers or **Payload** would equal the **Check-Digit** 

**Process** 
1. Drop the **Check-Digit** if it is in the number
    - Most likely that digit is the last number. 
    - Rest of the numbers are the ***payload***

2. On the **Payload**, start at the right-most digit and move left
    - every odd / other value is multiplied by two (***INCLUDING THE RIGHT-MOST DIGIT***)
    - if number is double-digits then sum the place digits

3. Sum all the values

4. To find / validate the **Check-Digit**. Perform this on the sum: `10 - (s mod 10)`

<br> 

**Assignment** <br> 

Create program to validate / find the check-sum digit. 