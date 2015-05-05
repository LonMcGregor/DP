# /r/DailyProgrammer Intermediate Challenge 210

import sys;
import png;


#Make a blank image
def makeImage(dx, dy):
    image = []
    for i in range(0, dx):
        image.append([])
        for j in range(0, dy):
            image[i].append([])
    return image


#Fill a column with colour
def fillColumn(column, colour, image):
    for j in range (0, len(image[0])):
        image[column][j] = colour
    return image    


#compare a colour value and see what needs to change
#return an array, length of the image, containing
#component values across the gradient
def compareColourComponent(compa, compb, length):
    #print("Comparing: "+str(compa)+" "+str(compb)+" ,L="+str(length))
    component = []
    if(compa > compb):
        for i in range(0, length):
            shift = compa - compb
            unit = float(shift / length)
            component.append(compa - int(unit * i))
            #print(">   shift:"+str(shift)+" unit:"+str(unit))
    if(compa == compb):
        for i in range(0, length):
            component.append(compa)
            #print("=   shift:"+str(shift)+" unit:"+str(unit))
    if(compa < compb):
        for i in range(0, length):
            shift = compb - compa
            unit = float(shift / length)
            component.append(compa + int(unit * i))
            #print("<   shift:"+str(shift)+" unit:"+str(unit))
    return component


#compare a full colour
#return an array of the colour components, separated
def compareColour(cola, colb, length):
    reds = compareColourComponent(cola[0], colb[0], length)
    greens = compareColourComponent(cola[1], colb[1], length)
    blues = compareColourComponent(cola[2], colb[2], length)
    return [reds, greens, blues]


#recombine gradient components into colours
#return an array of colour pixels
def recombineColours(separated):
    recombined = []
    reds   = separated[0]
    greens = separated[1]
    blues  = separated[2]
    for i in range(0, len(reds)):
        recombined.append((reds[i],greens[i],blues[i]))
    return recombined


#write all the columns as pixels
def writeColumns(colourLine, image):
    for i in range(0, len(colourLine)):
        image = fillColumn(i, colourLine[i], image)
    return image


#cast a list of something into ints
def listToInts(list):
    for i in range(0, len(list)):
        list[i] = int(list[i])
    return list

#take the currently used format 
def formatPixelArray(image):
    newimage = []
    for i in range(0, len(image[0])):
        newlist = []
        for j in range(0, len(image)):
            current = image[j][i] 
            newlist.append(current[0])
            newlist.append(current[1])
            newlist.append(current[2])
        newimage.append(newlist)
    return newimage
            
#take in arguments
linea = sys.argv[1]+" "+sys.argv[2]#"500 100"
lineb = sys.argv[3]+" "+sys.argv[4]+" "+sys.argv[5]#"255 255 0"
linec = sys.argv[6]+" "+sys.argv[7]+" "+sys.argv[8]#"0 0 255"
output = sys.argv[9]#"test.png"

#split arguments to arrays
dims = listToInts(linea.split(' ', maxsplit=1))
cola = listToInts(lineb.split(' ', maxsplit=2))
colb = listToInts(linec.split(' ', maxsplit=2))

#split dimensions to variables
dx = dims[0]
dy = dims[1]

#init an array for the image canvas
image = makeImage(dx, dy)

#populate the list with white pixels
for i in range(0, dx):
    image = fillColumn(i, [255,255,255], image)

separated = compareColour(cola, colb, dx)
recombined = recombineColours(separated)
finalimage = writeColumns(recombined, image)
readytoconvert = formatPixelArray(finalimage)

png.from_array(readytoconvert, 'RGB').save(output)