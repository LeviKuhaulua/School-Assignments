# Word Game

**Goal:** A program that will create many words from one word. 

Example: Accurate (this is also the word that we will be using) <br> 
- rate
- curate
- crate

Rules: 
1. Words must be four or more letters
- you cannot make a four-letter word by adding s. 
2. Only one form of the word is used (i.e no past tense / future tense) 
3. No Proper Nouns
4. No Slang 

<br> 

Challenge: <br> 
Find two solutions to the answer. 

Notes: <br> <br> 

Solution One: 
1. Get the word from the text file. 
2. Get the characters in that word 
3. Check if the characters of that word are found in 'Accurate'
    - check if there is enough characters. `.count()` method
4. If all characters are found then add that word to overall list
5. repeat process for new word. 

Solution Two: 
1. Take each character of 'accurate'
2. See which words can be made with that letter
3. Get next letter of a derived word 
4. Check if accurate has that next letter
5. Repeat process until derived word is made or move on to the next word 

