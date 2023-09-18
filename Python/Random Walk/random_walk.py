'''
Levi Kuhaulua
Professor: Dr. Crawford 
Date: 09/17/2023
Github: https://github.com/LeviKuhaulua/School-Assignments/blob/main/Python/Random%20Walk/

Random Walk Assignment: 
Make turtle choose a random cardinal direction and go 30 pixels forward. 
Challenge is to have turtle not go to coordinates it's already been to. 
'''

from turtle import Turtle, Screen
from random import choice



def potential_move(): 
    '''Calculates the coordinates of the possible places that awiwi can travel to'''
    get_direction = awiwi.heading()
    
    potential_x, potential_y = round(awiwi.xcor()), round(awiwi.ycor()) # rounds numbers to prevent decimal issues 
    
    # Calculate coordinates awiwi can travel to depending on his 
    if get_direction == 0: potential_x += 30 
    elif get_direction == 90: potential_y += 30 
    elif get_direction == 180: potential_x -= 30 
    elif get_direction == 270: potential_y -= 30 
    
    return potential_x, potential_y # returns the potential coordinates of the location awiwi wants to travel to 

def check_validity(xcord, ycord): 
    '''Checks if awiwi has already went to those coordinates'''
    return (xcord, ycord) in paths_taken


# Initializing Turtle and Screen
awiwi = Turtle() 
awiwi_hale = Screen() 
awiwi.speed(3)

face_direction = [0, 90, 180, 270] # Each value represents a cardinal direction. 0 = East, 90 = North, 180 = West, 270 = South 
paths_taken = [] 

awiwi.fd(30)


while(not abs(awiwi.pos()) < 1): # have awiwi keep going until they reach back home 
    awiwi.seth(choice(face_direction))
    x, y = potential_move() # calculates the potential places that awiwi can go

    while(check_validity(x, y)): # checks if where awiwi is moving is a new location or an old one 
        # have awiwi change direction then calculate it's next potential location again. 
        awiwi.seth(choice(face_direction))
        x, y = potential_move()
    
    awiwi.fd(30) 

    paths_taken.append((x, y))
    
        
    








awiwi_hale.mainloop() 