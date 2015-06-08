#/r/DailyProgrammer Easy 218
import sys

#import number[s] from args - return array
def importNumbers():
    numbers = [];
    #loop
    for i in range (1, len(sys.argv)):
        #if input is number
        if(sys.argv[i].isdigit()):
              #add it to list of numbers
              numbers.append(sys.argv[i])
        #else
        else:
              #break out of loop
              return numbers
    return numbers

#find solutions for inputs
def findSolutions():
    #import numbers
    numbers = importNumbers()
    if (len(numbers)==0):
        print("Not enough arguments given.")
    #for each
    for i in numbers:
        steps = 0
        currentNumber = i
        #loop
        while(True):
            #if steps > 10000
            if(steps>10000):
                #output no solution under 10000, quit
                print("No solution found under 10000 steps.")
                break
            #if palindrome
            if(isPalindrome(currentNumber)):
                #output solution
                print(str(i)+" gets palindromic after "+str(steps)+" steps: "+str(currentNumber))
                break
            #else
            else:
                #generate next number
                currentNumber = genNext(currentNumber)
                #steps++
                steps += 1

#generate next number - in number - return newnumber
def genNext(num):
    #return number + reversedNumber
    return (int(num) + int(revNum(num)))
  
#reverse a number - in number - return reversed number
def revNum(num):
    #convert to string
    numstr = str(num)
    #reverse the string
    numstr = numstr[::-1]
    #convert to number
    newnum = int(numstr, 10)
    #return the number
    return newnum

#check if a number is a palindrome - in number - out bool
def isPalindrome(num):
    #if digit is length 1
    if(len(str(num))==1):
        #return true
        return True
    #else if digit is length 2
    if (len(str(num))==2):
        #return pos[0]==pos[1]
        return (str(num)[0]==str(num)[1])
    #else return pos[1]==pos[end] && palindrome(number.substring)
    else:
      return ((str(num)[0]==str(num)[len(str(num))-1]) and isPalindrome(int(str(num)[1:((len(str(num))-1))])))
      
findSolutions()