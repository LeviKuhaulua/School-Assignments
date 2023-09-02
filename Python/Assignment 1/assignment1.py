""" Assignment 1 to fill canvas with squares and hexagon """
from turtle import Turtle, Screen

honu_hale = Screen()
honu = Turtle()

HALE_WIDTH = honu_hale.xscale * honu_hale.canvwidth
HALE_HEIGHT = honu_hale.yscale * honu_hale.canvheight


honu_hale.mode("world")
honu_hale.setup(HALE_WIDTH, HALE_HEIGHT)
honu_hale.setworldcoordinates(-HALE_WIDTH, -HALE_HEIGHT, HALE_WIDTH, HALE_HEIGHT)

# PART ONE: Fill Canvas with Squares
honu.penup()
honu.goto((-HALE_WIDTH, HALE_HEIGHT))
honu.pendown()

start_pos = -HALE_WIDTH
y_coord = honu_hale.canvheight
flag = True

while(flag):
    if (start_pos == HALE_WIDTH): 
        HALE_HEIGHT -= 100
        start_pos = -HALE_WIDTH
        honu.penup()
        honu.goto((-HALE_WIDTH, HALE_HEIGHT))
        honu.pendown()
    for _ in range(4): 
        honu.fd(100)
        honu.right(90)
    start_pos += 100
    honu.goto((start_pos, HALE_HEIGHT))
    if (honu.pos() == (HALE_WIDTH, -200)): 
        flag = False
    
    




honu_hale.mainloop()