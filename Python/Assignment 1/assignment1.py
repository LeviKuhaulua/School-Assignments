'''Assignment 1 to fill canvas with squares and hexagon'''
from turtle import Turtle, Screen

def draw_square(side_length=100): 
    '''Draws a square'''
    for _ in range(4): 
        honu.fd(side_length) 
        honu.right(90)

def go_there(pos:tuple[float, float]): 
    '''Takes honu to a position'''
    honu.penup()
    honu.goto(pos)
    honu.pendown()


honu_hale = Screen() 
honu = Turtle()


HALE_WIDTH = honu_hale.xscale * honu_hale.canvwidth
HALE_HEIGHT = honu_hale.yscale * honu_hale.canvheight


# Set up the canvas boundaries 
honu_hale.mode("world")
honu_hale.setworldcoordinates(-HALE_WIDTH, -HALE_HEIGHT, HALE_WIDTH, HALE_HEIGHT)


# PART ONE: Fill Canvas with Squares

go_there((-HALE_WIDTH, HALE_HEIGHT)) # Takes honu to starting position (top-left of canvas)

start_x = -HALE_WIDTH
flag = True
boundary = (HALE_WIDTH, -HALE_HEIGHT + 100) # Flag for when honu reaches end of canvas 

while(flag):
    # Checks when honu reaches the other side
    if (start_x == HALE_WIDTH): 
        HALE_HEIGHT -= 100
        start_x = -HALE_WIDTH
        go_there((start_x, HALE_HEIGHT)) # bring honu back to starting side 
    draw_square()
    start_x += 100 
    honu.goto((start_x, HALE_HEIGHT))
    # Stops drawing squares once honu reaches the end
    if (honu.pos() == boundary): 
        flag = False
    
    


honu_hale.mainloop()

