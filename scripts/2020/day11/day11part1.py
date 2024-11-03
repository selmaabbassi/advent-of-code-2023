def getPossibleDirections(i, j, i_length, j_length):
    horizontal = {"left": (i, j-1), "right": (i,j+1)}
    vertical = {"up": (i-1,j), "down": (i+1,j)}
    diagonal = {}
    directions = {}
    
    if i == 0:
        del vertical["up"]
    if i >= i_length:
        del vertical["down"]
    if j == 0:
        del horizontal["left"]
    if j >= j_length:
        del horizontal["right"]

    if 'left' in horizontal:
        if 'up' in vertical:
            diagonal['up-left'] = (i - 1, j - 1)
        if 'down' in vertical:
            diagonal['down-left'] = (i + 1, j - 1)

    if 'right' in horizontal:
        if 'up' in vertical:
            diagonal['up-right'] = (i - 1, j + 1)
        if 'down' in vertical:
            diagonal['down-right'] = (i + 1, j + 1)
    
    directions.update(horizontal)
    directions.update(vertical)
    directions.update(diagonal)
    
    return directions

def emptySeatHasAdjacentOccupied(directions, map): 
    for direction, (x,y) in directions.items():
        if map[x][y] == "#":
            return True
        else:
            continue

    return False

def occupiedSeatHasAdjacentOccupied(directions, map):
    numberOfOccupiedSeats = 0
    
    for direction, (x,y) in directions.items():
        if map[x][y] == "#":
            numberOfOccupiedSeats+=1

    if numberOfOccupiedSeats >= 4:
        return True
    else:
        return False

def toggleSeats(map):

    tmp = [row[:] for row in map]
    i_length = len(map) - 1

    number_of_toggles = 0

    for i in range(len(map)):
        for j in range (len(map[i])):
            j_length = len(map[i]) - 1
            directions = getPossibleDirections(i, j, i_length, j_length)
            
            if map[i][j] == "L":
                if emptySeatHasAdjacentOccupied(directions, map) == False:
                    tmp[i][j] = "#"
                    number_of_toggles +=1
            if map[i][j] == "#":
                if occupiedSeatHasAdjacentOccupied(directions, map):
                    tmp[i][j] = "L"
                    number_of_toggles +=1

    print(number_of_toggles)

    if number_of_toggles == 0:
        return tmp
    else:
        return toggleSeats(tmp)


if __name__ == "__main__":
    initialMap = []
    with open('day11.txt', 'r') as file:
        for line in file:
            initialMap.append(list(line.strip()))

    final = toggleSeats(initialMap)
    print(final)

    counter = 0

    for i in range(len(final)):
        for j in range (len(final[i])):
            if final[i][j] == "#":
                counter+=1


    print(f"Number of occupied seats is: {counter}")