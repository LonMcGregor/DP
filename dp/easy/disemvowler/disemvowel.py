#/r/DailyProgrammer Easy 149

import sys

def isVowel(c):
    return (c=='a' or c=='e' or c=='i' or c=='o' or c=='u')
    
sentence = ""
for i in range(1, len(sys.argv)):
    sentence = sentence + sys.argv[i]

disem = ""
vowels = ""
for i in range(0, len(sentence)):
    if isVowel(sentence[i]):
        vowels = vowels + sentence[i]
    else:
        disem = disem + sentence[i]

print(disem)
print(vowels)   
    