# Inheritance, Polymorphism, Abstract Classes & Interfaces. 
__Purpose: To learn about inheritance and specific uses of abstract classes and interfaces__

### What is Inheritance 
Two classes >> Super-Class & Sub-Class
* Other name: Parent & Child Class

Keyword >> `extends` - which is used in the child class 

Example: 
`public class Dog extends Animal`

**Child-Class Gets:**
 - any methods that can be used
    - think accessifiers >> public, private and protected 
    - :star: public and maybe protected (? didn't learn about protected yet). 
 - Their own methods to use >> something unique to the child class 

**IMPORTANT NOTE:** For child-classes, their constructor will need to include the parameters of super-class constuctor 

Example: 
```
public class Dog extends Animal {
    public Dog (String name, int age, String breed) {
        super(name, age); 
        this.breed = breed; 
    }
}
```
*Super* keyword refers to the parent class of the child class 
 - can use super to access other things in parent class not available in child class
    - Like `super.getName()` or `super.getAge()`

## Polymorphism
**One method having multiple forms - different parameters, in a different class, etc.**

Benefits
 - Display generic or specific information depending on the object 
 - can be used to manipulate information based on the data you have 

Example of Polymorphism: 
```
public class Animal {
    public void noise() {
        System.out.println("grrrrr"); 
    }
}
```
In Child Class
```
public class Cat extends Animal {
    public void noise() {
        System.out.println("meow"); 
    }
}
```

In Demo File: 

```
Animal someAnimal = new Animal(); 
someAnimal.noise(); 
Cat myCat = new Cat(); 
myCat.noise(); 
```
`myCat.noise()` will print out `meow` while `someAnimal.noise()` will print out `grrrrr`


## Abstract classes 
Keyword >> `abstract` 

Example: `public abstract class Shape`

What do abstract classes contain: 
 - normal methods 
 - normal fields >> private double, private String, etc. 
 - abstract methods 

**Abstract methods also contain `abstract`**
Syntax >> `public abstract void show();`

:star: For Abstract Methods, they don't contain any body or code >> only the method head and signature 

### How to: Abstract Method 

__In Child Class >> make sure you copy over the abstract method and include method body plus the `@Override`__

If Parent-class had `public abstract void show();`

Then Child-class has 
```
@Override
public void show() {
    System.out.println("I want to show you something"); 
}
```

**Important: Cannot create an instance of an abstract class**
`Shape aShape = new Shape(...);` >> will result in an error message 

`Shape aShape;` >> will not throw an error message 

`Shape aShape = new Rectangle(...);` >> will also not throw an error message 
    - Data Type is Shape | Instance is Rectangle

**In UML Diagram** Abstract classes are marked by `<<Abstract>>`

Finally, in the inheritance chain, an Abstract Class cannot be the last/bottom member. Always has to be a concrete class. 

## Type Casting
Use this example: 
```
Shape[] shapeArray = new Shape[1]; 
shapeArray[0] = new Rectangle(...); 
```

Notice that the data type of `shapeArray` is Shape but the instance of shapeArray[0] is a Rectangle. 

If you tried to do `Rectangle aRectangle = shapeArray[0]` >> that will result in an error message 

**This is because the data type of `aRectangle` is rectangle but is trying to use the data type of `Shape` as an instance.**

To avoid this use __Type-Casting__

`Rectangle aRectangle = (Rectangle) shapeArray[0]` >> converts Shape to Rectangle instance.  

**As long as Instance is smaller than data type >> can use instance to point to the bigger data type.**

`Square aSquare = (Rectangle) shapeArray[0]` >> will throw an error message since Rectangle is bigger than Square

## Interface

**Interfaces are very similar to abstract classes**
Keyword >> `interface`

Example: `public interface Display`

Interfaces Include: 
- Methods 
- Fields 

For Methods >> They are like abstract where it's only the method head and signature

For Fields >> They must have `final` and `static` keywords

To use an interface, you must use `implements` keyword

Example: `public class Rectangle extends Shape implements Display`

*NOTE: classes can only inherit one class but can implement multiple interfaces*

**If a method is not in the interface, then you can't use method for what you are trying to do**
Example: 
    Display[] shapeArray = new Display[1]; 
    shapeArray[0] = new Rectangle(...); 
    shapeArray[1] = new Square(...); 
    
    // Display Interface has only show method and not getArea() for shapes
    shapeArray[0].show() // no error message 
    shapeArray[1].getArea() // results in error message

*Interfaces are good for only allowing certain methods that you want programmer or user to access.*
*Doing something like type-casting goes against purpose of Interface*


