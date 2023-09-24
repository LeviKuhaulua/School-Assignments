days_word = "accurate"


combo_words = set() # set to hold all the words that can be derived from 'Accurate'

eng_dict = (word.strip() for word in open("testWords.txt", "r")) # Generator Expression that will eventually be used for WordEn.txt (HUUUUUGE FILE)

# Solution 1: Takes the list of words from a text file (in this case: testWords.txt) and sees if it can be derived from 'Accurate'. 

for word in eng_dict: 
    build_word = ""
    for letter in word:  
        letter_freq = word.count(letter)
        if letter in word and days_word.count(letter) >= letter_freq: build_word += letter
    if len(build_word) >= 4: combo_words.add(build_word)
    

print(combo_words) # Output should be: curate, rate, erat, tear. Excluded: rater, rates

            
