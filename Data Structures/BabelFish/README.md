# BabelFish Problem

Taken from [Kattis](https://open.kattis.com/problems/babelfish) website. 


## Problem Description

Input consists of up to 100,000 dictionary entries, followed by a blank line, followed by a message of up to 100,000
words. Each dictionary entry is a line containing an English word, followed by a space and a foreign language word. No foreign word appears more than once in the dictionary. The message is a sequence of words in the foreign language, one word on each line. Each word in the input is a non-empty sequence of at most 10 lowercase letters.

Output is the message translated to English with foreign words not in the dictionary being "eh". 

## Thought Process

The first segment / part will be the dictionary entries, in other words, key-value pairs (Java Dictionary = `HashMap`). Should make the foreign word the `key` and the English translation the `value`. Dictionary Entries follow the format: `English Word + Space + Foreign Translation`, therefore we can get the Key-Value pair by splitting up the dictionary entry by the space. 

The end of the first segment is noted by a blank line, which means that `while` the line is not empty, then add to the `HashMap` if it didn't previously exist. 

The second segment is the foreign words that need to be translated to the English equivalent. Since the foreign word is the `key` in our Dictionary, we check to see if it exists, output it if it does, otherwise output `eh` if it doesn't exist. 

