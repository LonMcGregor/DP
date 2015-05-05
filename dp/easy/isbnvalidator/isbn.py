#/r/DailyProgrammer Easy 197

import sys
f = sys.argv[1]
i = []
for j in range(0, 9):
    i.append(int(f[j]))
if f[9]=='x' or f[9]=='X':
    i.append(10)
else:
    i.append(int(f[9]))
print(((10*i[0] + 9*i[1] + 8*i[2] + 7*i[3] + 6*i[4] + 5*i[5] + 4*i[6] + 3*i[7] + 2*i[8] + 1*i[9])%11)==0)