def build_word(word_list): 
    '''Takes a list of words and finds the possible words that can be made out of that list'''
    build_word = "" 
    for letter in word_list: 
        letter_freq = word_list.count(letter)
        # Checks if days_word has enough letters to make one of it's possible words
        if days_word.count(letter) >= letter_freq: build_word += letter
    # Validates if it's a real word and then add it to the set. Excludes days_word from set as well. 
    if build_word == word and len(build_word) >= 4 and build_word != days_word: derived_words.add(build_word)

days_word = "accurate"

derived_words = set() # set to hold all the words that can be derived from 'Accurate'

# Solution 1: Grabs the characters from the words in WordEn.txt file and checks if it can be made from 'Accurate'

for word in (word.strip() for word in open("WordEn.txt", "r")): 
    build_word(word)


print('Words derived from Accurate')
for word in derived_words: print(word)


# Solution 2: Takes characters from 'accurate' and sees what words it can make
derived_words.clear() 

for letter in days_word: 
    # Generates possible list of words based on index of days_word
    possible_words = [word for word in (word.strip() for word in open("WordEn.txt", "r")) if word.startswith(letter)] 
    
    for word in possible_words: 
        build_word(word)

print('Words derived from Accurate')
for word in derived_words: print(word)
        
    





            
