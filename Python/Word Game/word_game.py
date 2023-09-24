days_word = "accurate"

derived_words = set() # set to hold all the words that can be derived from 'Accurate'

eng_dict = (word.strip() for word in open("WordEn.txt", "r")) # Generator Expression for WordEn.txt (HUUUUGE FILE)



# Solution 2: Takes characters from 'accurate' and sees what words it can make

for letter in days_word: 
    possible_words = [word.strip() for word in open("testWords.txt", "r") if word.startswith(letter) and len(word) >= 4]
    
    for word in possible_words: 
        build_word = ""
        for letter in word: 
            letter_freq = word.count(letter)
            if days_word.count(letter) >= letter_freq: build_word += letter
        if build_word == word and build_word != days_word: derived_words.add(build_word)

print(derived_words) # Desired Output: aurae, aurate, cart, crate, urea, rate, race, tare, tear, eruct
print(len(derived_words))
        
    



# Solution 1: Grabs the characters from the words in WordEn.txt file and checks if it can be made from 'Accurate'

'''for word in eng_dict: 
    build_word = "" # Reset and try to build a new word
    for letter in word: 
        letter_freq = word.count(letter)
        # Checks if 'Accurate' has that letter. Also accounts if there is multiple same letters. 
        if days_word.count(letter) >= letter_freq: build_word += letter 
    # Validates if the word is a valid word before adding to the set. 
    if build_word == word and len(build_word) >= 4 and build_word != 'accurate': derived_words.add(build_word) 


print('Words derived from Accurate')
for word in derived_words: print(word)
print(len(derived_words))'''

            
