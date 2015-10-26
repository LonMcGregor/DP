#/r/dailyprogrammer Hard #237
#Takuzu solver

def printBoard(board):
	for row in board:
		rowString = ""
		for cell in row:
			if cell==None:
				rowString += "."
			elif cell:
				rowString += "1"
			else:
				rowString += "0"
		print(rowString)

def countItemsInArray(array, item):
	total = 0
	for cell in array:
		if cell==item:
			total += 1
	return total

def fillFreeSpaceInRow(row, filler):
	for i in range(0, len(row)):
		if row[i]==None:
			row[i] = filler
	return row

def solveArraySingleSpace(row):
	itemsOfEachNeeded = len(row)/2
	falseCount = countItemsInArray(row, False)
	trueCount = countItemsInArray(row, True)
	if falseCount > trueCount:
		return fillFreeSpaceInRow(row, True)
	else:
		return fillFreeSpaceInRow(row, False)

def solveArrayMultiSpace(row):
	for cell in range(0, len(row)):
		if row[cell]==None:
			None
			#not sure about this one
	return row

def readColumnFromBoard(board, columnNo):
	column = []
	for row in board:
		column.append(row[columnNo])
	return column

def writeColumnToBoard(board, columnNo, columnArray):
	for row in range(0, len(board)):
		board[row][columnNo] = columnArray[row]
	return board

def solveBoard(board):
	itemsNeeded = len(board)/2
	changesMade = True
	while changesMade:
		changesMade = False
		for r in range(0, len(board)):
			row = board[r]
			noneCount = countItemsInArray(row, None)
			if noneCount==1:
				board[r] = solveArraySingleSpace(row)
				changesMade = True
			elif noneCount>1:
				newRow = solveArrayMultiSpace(row)
				if newRow!=row:
					changesMade = True
				board[r] = newRow
		for c in range(0, len(board)):
			column = readColumnFromBoard(board, c)
			noneCount = countItemsInArray(column, None)
			if noneCount==1:
				board = writeColumnToBoard(board, c, solveArraySingleSpace(column))
				changesMade = True
			elif noneCount>1:
				newColumn = solveArrayMultiSpace(column)
				if newColumn!=column:
					changesMade = True
				board = writeColumnToBoard(board, c, newColumn)
	return board


def readBoardFromInput():
	print("Enter Puzzle, followed by a blank line:")
	puzzleBoard = []
	rowCount = -1;
	while True:
		rowCount += 1
		cellCount = 0
		rowString = input();
		if rowString=="":
			break
		else:
			rowArray = []
			for cellCount in range(0, len(rowString)):
				cell = rowString[cellCount]
				if cell==".":
					rowArray.append(None)
				elif cell=="0":
					rowArray.append(False)
				elif cell=="1":
					rowArray.append(True)
				else:
					print("error in input")
					break
		puzzleBoard.append(rowArray)
	return puzzleBoard

printBoard(solveBoard(readBoardFromInput()))
