#/r/DailyProgrammer Easy #139 + bonus

n = int(input("Number of lines:"))


s = []
for i in range(0, n):
    s.append(input().lower().replace("0","").replace("1","").replace("2","").replace("3","").replace("4","").replace("5","").replace("6","").replace("7","").replace("8","").replace("9","").replace(" ","").replace(".",""))

def makeAlphabet():
    c = []
    for i in range(0,26):
        c.append(0)
    return c;
        
for i in range(0, len(s)):
    c = makeAlphabet()
    for j in range(0, len(s[i])):
        c[ord(s[i][j])-97] = c[ord(s[i][j])-97] + 1
    p = (0==0)
    for j in range(0, 26):
        p = p and (c[j]>0)
    out = "a: "+str(c[0])
    for j in range(1, 26):
        out = out + ", " + chr(j+97) + ": " + str(c[j])
        
    print(p)
    print(out)