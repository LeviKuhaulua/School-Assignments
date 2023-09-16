'''
Author: Levi Kuhaulua
Course: Python 3371
Professor: Dr. Crawford 
09-13-2023
Github: https://github.com/LeviKuhaulua/School-Assignments/tree/main/Python/Random%20Walk

Random Walk Assignment: 

Turtle will choose a random direction to walk in and repeat that process until they reach back to their original position.
Turtle will also make sure to not choose a direction they've already walked in
'''

from turtle import Turtle, Screen
from random import choice

# Make awiwi travel in a random location and stop when they get back home. 

# Initialize Turtle and Screen 
awiwi = Turtle() 
awiwi_hale = Screen()
awiwi_hale.mode("world")
awiwi_hale.setworldcoordinates(-400, -300, 400, 300) 

# List to store all directions: East, North, West, South (from left to right)
face_direction = [0, 90, 180, 270]
awiwi.fd(30) 



# Have awiwi travel around until they get back home 
while (not abs(awiwi.pos()) < 1): 
    awiwi.seth(choice(face_direction))
    # checks if awiwi will go out of bounds if they move forward 
    if int(awiwi.xcor()) + 30 > 400: 
        awiwi.seth(choice([n for n in face_direction if n != 0]))
    if int(awiwi.xcor()) - 30 < -400: 
        awiwi.seth(choice([n for n in face_direction if n != 180]))
    if (int(awiwi.ycor()) + 30 > 300): 
        awiwi.seth(choice([n for n in face_direction if n != 90]))
    if (int(awiwi.ycor()) - 30 < 300): 
        awiwi.seth(choice([n for n in face_direction if n != 270]))
    
    awiwi.fd(30) 







# So that the turtle graphics do not disappear at the end. 
awiwi_hale.mainloop() 