days_word = "accurate"

derived_words = set() # set to hold all the words that can be derived from 'Accurate'

eng_dict = (word.strip() for word in open("WordEn.txt", "r")) # Generator Expression for WordEn.txt (HUUUUGE FILE)

# Solution 1: Grabs the characters from the words in WordEn.txt file and checks if it can be made from 'Accurate'

for word in eng_dict: 
    build_word = "" # Reset and try to build a new word
    for letter in word: 
        letter_freq = word.count(letter)
        if letter in word and days_word.count(letter) >= letter_freq: build_word += letter
    # Validates if the word is a valid word before adding to the set. 
    if build_word == word and len(build_word) >= 4: derived_words.add(build_word) 


print('Words derived from Accurate')
for word in derived_words: print(word)


            
