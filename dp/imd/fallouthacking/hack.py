#/r/DailyProgrammer Intermediate Challenge 163
#uses dotnetperls-controls enable1.txt dictionary
import sys
import random
import fileinput

DICTIONARY_LOCATION = sys.argv[1]
DICTIONARY_MIN = 4 #inclusive
DICTIONARY_MAX = 15 #inclusive
MAX_GUESSES = 4 #inclusive
POSSIBLE_WORDS = 7 #inclusive

#popdictionary
#dic is of form Array of Array of word of specific length
#in: string file location, min word length, max word length
#out: dictionary populated with words from text file
def popDictionary(loc, min, max):
    dic = []
    for i in range(min, max+1):
        dic.append([])
    with fileinput.input(files=(loc)) as f:
        for line in f:
            word = line.rstrip('\n')
            if (len(word)>=min and len(word)<=max):
                dic[len(word)-min].append(word)
    return dic

#getword
#in: possibles
#out: a word of length n from dictionary
def getWord(possibles):
    return random.sample(possibles,1)[0]
    
#getwords
#in: int n, dictionary, number of words
#out: some words of length n from dictionary
def getWords(n, dic, number):
    position = n - len(dic[0][0])
    return random.sample(dic[position],number)

#getlevel - what level to play at?
#standard in: level of difficulty
#out: word length
def getLevel():
    level = int(input('Difficulty (1-5)? '))
    if (level==1):
        return random.sample([4,5],1)[0]
    if (level==2):
        return random.sample([6,7,8],1)[0]
    if (level==3):
        return random.sample([9,10],1)[0]
    if (level==4):
        return random.sample([11,12],1)[0]
    if (level==5):
        return random.sample([13,14,15],1)[0]

#playgame
#in: number of guesses available
#out: win/lose state
def playGame(guesses, word):
    correct = checkGuess(word, getGuess(guesses))
    print(str(correct)+'/'+str(len(word))+' correct')
    if (correct == len(word)):
        return (0==0)
    if (guesses == 1):
        return (0==1)
    else:
        return playGame(guesses-1, word)

#getguess
#in: guess number
#standard in: guess string
#lowercased guess string
def getGuess(guessno):
    return input("Guess ({0} left)? ".format(str(guessno))).lower()

#checkguess
#in: word, guess
#out: number correct letters
def checkGuess(word, guess):
    correct = 0
    for i in range(0, len(guess)):
        for j in range(0, len(word)):
            if (word[j]==guess[i]) :
                correct = correct+1
                break
    return correct

#win
#print win message
def msgWin():
    print('You Win!')

#lose
#print lose message
def msgLose():
    print('Out of guesses. You Lose.')


dic = popDictionary(DICTIONARY_LOCATION, DICTIONARY_MIN, DICTIONARY_MAX)
possibles = getWords(getLevel(), dic, POSSIBLE_WORDS)
for word in possibles:
    print(word.upper())
win = playGame(MAX_GUESSES, getWord(possibles))
if win:
    msgWin()
else:
    msgLose()