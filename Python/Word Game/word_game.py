days_word = "accurate"


combo_words = set() # set to hold all the words that can be derived from 'Accurate'

sample_test = ['curate', 'rate', 'erat', 'tear', 'rater', 'rates'] # Experiment to test out words that have letters in different positions and those that may have multiple letters


# Solution 1: Takes the list (for now 'sample_test') - then checks the character for each word and sees if Accurate can supply those letters

for word in sample_test: 
    build_word = ""
    for letter in word: 
        letter_freq = word.count(letter)
        if letter in word and days_word.count(letter) >= letter_freq: # checks if there is enough letters to make the word
            #print(f'Accurate has enough {letter}\'s for {word}') 
            build_word += letter
        # else: print(f'Accurate does not have enough {letter}\'s for {word}') << Initial check to see if there were enough letters to make the word from Accurate 
    if build_word in sample_test: combo_words.add(build_word)

print(combo_words) # Should output: curate, rate, erat, tear.
            
