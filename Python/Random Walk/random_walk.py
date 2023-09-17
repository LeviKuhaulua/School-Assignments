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
 

# Initialize Turtle and Screen 
awiwi = Turtle() 
awiwi_hale = Screen()
awiwi_hale.mode("world") # make user defined coordinates 
awiwi_hale.setworldcoordinates(-400, -300, 400, 300) 

face_direction = [0, 90, 180, 270] 

# "Do" Part of while statement, have awiwi travel once in a random direction to make while statement true
awiwi.seth(choice(face_direction))
awiwi.fd(30) 

paths_took = [awiwi.pos()] 



# Awiwi will keep travelling until they reach back home (0, 0)
while (not abs(awiwi.pos()) < 1): 
    # grab the coordinates of awiwi
    awiwi.seth(choice(face_direction))
    # Checks if turtle will go out of bounds and choose a different direction if it will
    if int(x_cord) + 30 > 400 and awiwi.heading() == 0: awiwi.seth(choice([d for d in face_direction if d != awiwi.heading()]))
    elif int(x_cord) - 30 < -400 and awiwi.heading() == 180: awiwi.seth(choice([d for d in face_direction if d != awiwi.heading()]))

    if int(y_cord) + 30 > 300 and awiwi.heading() == 90: awiwi.seth(choice([d for d in face_direction if d != awiwi.heading()]))
    elif int(y_cord) - 30 < -300 and awiwi.heading() == 270: awiwi.seth(choice([d for d in face_direction if d != awiwi.heading()]))

    
    
    awiwi.fd(30) 
    paths_took += [awiwi.pos()]







# So that the turtle graphics do not disappear at the end. 
awiwi_hale.mainloop() 

