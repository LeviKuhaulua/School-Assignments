# Classwork (3/30/23) on Inheritance 

**Assignment**
1. Create an array with 2 books, 2 magazines and 1 textbook 
2. Output the information of each object 
    1. Book - Title, ISBN, Publisher, Author & Date
    2. Textbook - Title, ISBN, Publisher, Author, Date & Grade
    3. Magazine - Title, ISBN, Publisher, Date & Style 
3. Change all publishers to IEEE
4. Output the Publishers to verify that change was successfull. 


**Classes** 
- <<Abstract>> Publication
    - Strings title and ISBN
    - Publication Constructor with String type, title, ISBN 
    - setters and getters
    - Abstract method of show
- Book
    - Fields >> Strings Author, Publisher, Date
    - Sub-Class: Textbook 
        - Field >> Grade (int) like K through 12 textbook 
- Magazine 
    - Fields >> Publisher, Date, Style 

**Book & Magazine will implement Publisher interface** 


**Interface**
- Publisher 
    - methods for setPublisher and getPublisher

