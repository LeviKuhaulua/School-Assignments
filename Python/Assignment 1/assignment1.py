'''Assignment 1 to fill canvas with squares and hexagon'''
from turtle import Turtle, Screen
from math import sqrt

def draw_square(side_length=100,): 
    '''Draws a square'''
    for _ in range(4): 
        honu.fd(side_length) 
        honu.right(90)

def go_there(pos: tuple[float, float]): 
    '''Takes honu to a position'''
    honu.penup()
    honu.goto(pos)
    honu.pendown()

def in_row_square(): 
    '''Honu will draw remaining 2 sides for rest of squares in row'''
    for _ in range(2): 
        honu.fd(100)
        honu.rt(90)

def first_row_square(): 
    '''Honu will draw remaining 3 sides for rest of squares in first row'''
    for _ in range(3): 
        honu.fd(100)
        honu.rt(90)

def new_row_square(): 
    '''Honu will draw remaining 3 sides for every 1st square in new row'''
    for _ in range(3): 
        honu.fd(100)
        honu.lt(90)

def draw_hexagon(): 
    ''' Honu will draw a hexagon'''
    for _ in range(6): 
        honu.fd(100)
        honu.rt(60)

honu_hale = Screen() 
honu = Turtle()
honu.speed(15)

HALE_WIDTH = honu_hale.xscale * honu_hale.canvwidth
HALE_HEIGHT = honu_hale.yscale * honu_hale.canvheight


# Set up the canvas boundaries 
honu_hale.mode("world")
honu_hale.setup(HALE_WIDTH, HALE_HEIGHT)
honu_hale.setworldcoordinates(-HALE_WIDTH, -HALE_HEIGHT, HALE_WIDTH, HALE_HEIGHT)


# PART ONE: Fill Canvas with Squares

honus_spot = (-HALE_WIDTH, HALE_HEIGHT)
go_there(honus_spot) # Takes honu to starting position (top-left of canvas)

start_x = -HALE_WIDTH
start_y = HALE_HEIGHT
flag = True
boundary = (HALE_WIDTH, -HALE_HEIGHT + 100)

while(flag):
    # Checks when honu reaches the other side
    if (int(honu.xcor()) == int(HALE_WIDTH)):
        start_y -= 100
        start_x = -HALE_WIDTH 
        go_there((start_x, start_y)) # bring honu back to starting side for new row
    draw_square()
    start_x += 100 
    honu.goto((start_x, start_y)) 
    # Stops drawing squares once honu reaches the end
    if (honu.pos() == boundary): 
        flag = False
        # reset starting position
        start_x = -HALE_WIDTH
        start_y = HALE_HEIGHT

# PART TWO: Fill canvas with squares without overlapping

honu_hale.clearscreen() 
honu = Turtle()
flag = True

# Draw first row of canvas with squares 
go_there(honus_spot)
draw_square() 
start_x = -HALE_WIDTH 

while (flag): 
    start_x += 100
    go_there((start_x, start_y))
    first_row_square()
    honu.seth(0)
    # Once Honu reaches other side, go back to starting side
    if (start_x == HALE_WIDTH - 100): 
        flag = False
        start_y -= 100
        start_x = -HALE_WIDTH # Honu's new starting spot
        go_there((start_x, start_y))

# reset flag
flag = True 
start_x += 100

while (flag): 
    # When honu is at starting spot, draw first square of new row 
    if (int(honu.xcor()) == int(-HALE_WIDTH)): 
        honu.seth(270)
        new_row_square()
    start_x += 100
    go_there((start_x, start_y)) # brings honu to next square position 
    honu.seth(270)
    in_row_square() # draws the in-line squares
    # Bring Honu back to starting side when he reaches the end 
    if (int(honu.xcor()) == HALE_WIDTH - 100):  
        # Stops drawing when Honu reaches the end of the canvas
        if (int(honu.ycor()) == -HALE_HEIGHT): 
            flag = False
        # Brings honu to new row
        start_y -= 100
        start_x = -HALE_WIDTH + 100
        go_there((-HALE_WIDTH, start_y))
    
# PART THREE: Fill Canvas with Hexagons 
honu_hale.clearscreen()
honu = Turtle()
honu.seth(0) # force honu to face right 
y_value = 50 * sqrt(3) # where honu will start to draw the hexagon
start_x = -HALE_WIDTH + 50
start_y = HALE_HEIGHT - 100 + y_value

go_there((start_x, start_y))
flag = True
while (flag): 
    getx_coord = honu.xcor()
    gety_coord = honu.ycor() 
    draw_hexagon()
    # Honu will stop once he reaches the boundary 
    if (getx_coord == HALE_WIDTH - 150 and gety_coord < 0): break 
    # go to new starting point 
    start_x += 200
    # if honu reaches the other side, bring him back to the starting side 
    if (getx_coord == HALE_WIDTH - 150): 
        start_y -= (2 * y_value)
        start_x = -HALE_WIDTH + 50
        go_there((start_x, start_y))
    go_there((start_x, start_y))

honu_hale.mainloop()
