# /r/DailyProgrammer Easy #211 Challenge

import sys

vowels = "AEIOU"

start = sys.argv[1]
i = len(start) - 1
name = start[0:i]

cutname = name.lstrip("BCDFGHJKLMNPQRSTVWXZ").lower()


x = name + ", " + name + " bo B" + cutname + "," + "\n" \
+ "Bonana fanna fo F" + cutname + "," + "\n" \
+ "Fee fy mo M" + cutname + "," + "\n" \
+ start

print(x)