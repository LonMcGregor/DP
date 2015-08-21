# /r/DailyProgrammer Hard Challenge 227

import re

VERTEX = re.compile("[a-z]")
EMPTY  = " "
EDGEH  = "-"
EDGEV  = "|"
EDGEDI = "\\"
EDGEID = "/"
CORNER = "#"

noLines = int(input("Number of lines: "))
lines = []

noColumns = 0
for i in range(noLines):
	newLine = input("> ")
	newLineLength = len(newLine)
	if newLineLength > noColumns:
		noColumns = newLineLength
	lines.append(newLine)

for i in range(noLines):
	while(len(lines[i]) < noColumns):
		lines[i] += EMPTY
	
partialEdges = []

#states:
#0 looking for a vertex
#1 looking for a vertex's first edge piece
#2 looking for more edge pieces
#3 looking for more edge pieces or a vertex

for row in range(noLines):
	currentLine = lines[row]
	state = 0
	previousCharacter = ""
	currentEdgeStart  = ""
	for col in range(len(currentLine)):
		currentChar = currentLine[col]
		if state==0:
			if VERTEX.match(currentChar) or currentChar==CORNER:
				currentEdgeStart = currentChar
				currentEdgeStartRow = row
				currentEdgeStartCol = col
				state = 1
		elif state==1:
			if currentChar==EDGEH:
				state = 3
			elif VERTEX.match(currentChar) or currentChar==CORNER:
				currentEdgeStart = currentChar
				currentEdgeStartRow = row
				currentEdgeStartCol = col
				state = 1
			else:
				state = 0
		elif state==2:
			if currentChar==EDGEH:
				state = 3
			elif currentChar==EMPTY:
				state = 0
		elif state==3:
			if VERTEX.match(currentChar) or currentChar==CORNER:
				partialEdges.append([currentEdgeStartRow, currentEdgeStartCol, currentEdgeStart, row, col, currentChar])
				currentEdgeStart = currentChar
				currentEdgeStartRow = row
				currentEdgeStartCol = col
				state = 1
			elif currentChar==EMPTY:
				state = 0
			elif currentChar!=EDGEH:
				state = 2

for col in range(noColumns):
	state = 0
	previousCharacter = ""
	currentEdgeStart = ""
	for row in range(noLines):
		currentChar = lines[row][col]
		if state==0:
			if VERTEX.match(currentChar) or currentChar==CORNER:
				currentEdgeStart = currentChar
				currentEdgeStartRow = row
				currentEdgeStartCol = col
				state = 1
		elif state==1:
			if currentChar==EDGEV:
				state = 3
			elif VERTEX.match(currentChar) or currentChar==CORNER:
				currentEdgeStart = currentChar
				currentEdgeStartRow = row
				currentEdgeStartCol = col
				state = 1
			else:
				state = 0
		elif state==2:
			if currentChar==EDGEV:
				state = 3
			elif currentChar==EMPTY:
				state = 0
		elif state==3:
			if VERTEX.match(currentChar) or currentChar==CORNER:
				partialEdges.append([currentEdgeStartRow, currentEdgeStartCol, currentEdgeStart, row, col, currentChar])
				currentEdgeStart = currentChar
				currentEdgeStartRow = row
				currentEdgeStartCol = col
				state = 1
			elif currentChar==EMPTY:
				state = 0
			elif currentChar!=EDGEV:
				state = 2

orow = 0
ocol = 0
while(True):
	currentChar = lines[orow][ocol]
	if VERTEX.match(currentChar) or currentChar==CORNER:
		state = 1
		currentEdgeStart    = currentChar
		currentEdgeStartRow = orow
		currentEdgeStartCol = ocol
		row = orow
		col = ocol
		while(True):
			row += 1
			col += 1
			if row >= noLines or col >= noColumns:
				break
			currentChar = lines[row][col]
			if state==1:
				if currentChar==EDGEDI:
					state = 3
				else:
					break
			elif state==2:
				if currentChar==EDGEDI:
					state = 3
				elif currentChar==EMPTY:
					break
			elif state==3:
				if VERTEX.match(currentChar) or currentChar==CORNER:
					partialEdges.append([currentEdgeStartRow, currentEdgeStartCol, currentEdgeStart, row, col, currentChar])
					currentEdgeStart = currentChar
					currentEdgeStartRow = row
					currentEdgeStartCol = col
					state = 1
					break
				elif currentChar==EMPTY:
					break
				elif currentChar!=EDGEDI:
					state = 2
	ocol+=1
	if ocol>=noColumns:
		ocol=0
		orow+=1
	if orow>=noLines:
		break

orow = 0
ocol = 0
while(True):
	currentChar = lines[orow][ocol]
	if VERTEX.match(currentChar) or currentChar==CORNER:
		state = 1
		currentEdgeStart    = currentChar
		currentEdgeStartRow = orow
		currentEdgeStartCol = ocol
		row = orow
		col = ocol
		while(True):
			row -= 1
			col += 1
			if row<0 or col>=noColumns:
				break
			currentChar = lines[row][col]
			if state==1:
				if currentChar==EDGEID:
					state = 3
				else:
					break
			elif state==2:
				if currentChar==EDGEID:
					state = 3
				elif currentChar==EMPTY:
					break
			elif state==3:
				if VERTEX.match(currentChar) or currentChar==CORNER:
					partialEdges.append([currentEdgeStartRow, currentEdgeStartCol, currentEdgeStart, row, col, currentChar])
					currentEdgeStart = currentChar
					currentEdgeStartRow = row
					currentEdgeStartCol = col
					state = 1
				elif currentChar==EMPTY:
					break
				elif currentChar!=EDGEID:
					state = 2
	ocol+=1
	if ocol>=noColumns:
		ocol=0
		orow+=1
	if orow>=noLines:
		break

print("Partial Edges found:")
if len(partialEdges) > 0:
	for i in range(len(partialEdges)):
		print( partialEdges[i][2] + "@" + str(partialEdges[i][0]) + "," + 
		    str(partialEdges[i][1]) + " <-> " + partialEdges[i][5] + "@" + 
			str(partialEdges[i][3]) + "," + str(partialEdges[i][4]) )

fullEdges = []
	
while(True):
	for i in range(len(partialEdges)):
		if partialEdges[i] == None:
			continue
		else:
			if VERTEX.match(partialEdges[i][2]) and VERTEX.match(partialEdges[i][5]):
				fullEdges.append(partialEdges[i])
				partialEdges[i] = None
			elif VERTEX.match(partialEdges[i][2]) and partialEdges[i][5]==CORNER:
				found = False
				for j in range(len(partialEdges)):
					if i!=j and partialEdges[j]!=None and partialEdges[j][0]==partialEdges[i][3] and partialEdges[j][1]==partialEdges[i][4] and partialEdges[j][2]==CORNER:
						partialEdges[i][3]=partialEdges[j][3]
						partialEdges[i][4]=partialEdges[j][4]
						partialEdges[i][5]=partialEdges[j][5]
						partialEdges[j] = None
						found = True
				if found:
					continue
				for j in range(len(partialEdges)):
					if i!=j and partialEdges[j]!=None and partialEdges[j][3]==partialEdges[i][3] and partialEdges[j][4]==partialEdges[i][4] and partialEdges[j][5]==CORNER:
						partialEdges[i][3]=partialEdges[j][0]
						partialEdges[i][4]=partialEdges[j][1]
						partialEdges[i][5]=partialEdges[j][2]
						partialEdges[j] = None
	allValid = True
	for t in range(len(partialEdges)):
		allValid = allValid and (partialEdges[t]==None)
	if allValid:
		break

print("Edges found:")
if len(fullEdges) > 0:
	for i in range(len(fullEdges)):
		print( fullEdges[i][2] + "@" + str(fullEdges[i][0]) + "," + 
		    str(fullEdges[i][1]) + " <-> " + fullEdges[i][5] + "@" + 
			str(fullEdges[i][3]) + "," + str(fullEdges[i][4]) )
			
vertices = []
for i in range(len(fullEdges)):
	if not fullEdges[i][2] in vertices:
		vertices.append(fullEdges[i][2])
	if not fullEdges[i][5] in vertices:
		vertices.append(fullEdges[i][5])
vertices = sorted(vertices)
print("Vertices Involved:")
print(vertices)

adjmatrix = []
for i in range(len(vertices)):
	tmparray = []
	for j in range(len(vertices)):
		tmparray.append(0)
	adjmatrix.append(tmparray)
	
for i in range(len(fullEdges)):
	currentFrom = fullEdges[i][2]
	currentTo   = fullEdges[i][5]
	for j in range(len(vertices)):
		if currentFrom==vertices[j]:
			for k in range(len(vertices)):
				if currentTo==vertices[k]:
					adjmatrix[j][k] += 1
					adjmatrix[k][j] += 1
	
print("Adjacency Matrix:")
for i in range(len(adjmatrix)):
	adjrow = ""
	for j in range(len(adjmatrix[i])):
		adjrow += str(adjmatrix[i][j])
	print(adjrow)
		