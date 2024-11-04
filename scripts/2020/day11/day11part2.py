def getPossibleDirections(i, j, i_length, j_length, step=1):
    horizontal = {"left": (i, j - step), "right": (i, j + step)}
    vertical = {"up": (i - step, j), "down": (i + step, j)}
    diagonal = {}
    directions = {}
    
    if i - step < 0:
        vertical.pop("up", None)
    if i + step > i_length:
        vertical.pop("down", None)
    if j - step < 0:
        horizontal.pop("left", None)
    if j + step > j_length:
        horizontal.pop("right", None)

    if 'left' in horizontal:
        if 'up' in vertical:
            diagonal['up-left'] = (i - step, j - step)
        if 'down' in vertical:
            diagonal['down-left'] = (i + step, j - step)

    if 'right' in horizontal:
        if 'up' in vertical:
            diagonal['up-right'] = (i - step, j + step)
        if 'down' in vertical:
            diagonal['down-right'] = (i + step, j + step)
    
    directions.update(horizontal)
    directions.update(vertical)
    directions.update(diagonal)
    
    return directions

def getVisibleSeats(map, i, j, i_length, j_length): 
    directions = [
        (-1, 0), (1, 0),  # up, down
        (0, -1), (0, 1),  # left, right
        (-1, -1), (-1, 1),  # up-left, up-right
        (1, -1), (1, 1)   # down-left, down-right
    ]
    
    visible_seats = []
    
    for direction in directions:
        step = 1
        while True:
            x = i + step * direction[0]
            y = j + step * direction[1]
            
            # Check if the position is out of bounds
            if x < 0 or x > i_length or y < 0 or y > j_length:
                break
            
            # Check the seat status
            if map[x][y] == "#":
                visible_seats.append("#")
                break
            elif map[x][y] == "L":
                visible_seats.append("L")
                break
            
            # Increment the step to look further in this direction
            step += 1

    return visible_seats

def getNrOfOccupiedSeats(visible_seats):
    nr_of_seats = 0
    
    for seat in visible_seats:
        if seat == "#":
            nr_of_seats+=1

    return nr_of_seats

def toggleSeats(map):

    tmp = [row[:] for row in map]
    i_length = len(map) - 1

    number_of_toggles = 0

    for i in range(len(map)):
        for j in range (len(map[i])):
            j_length = len(map[i]) - 1
            
            visible_seats = getVisibleSeats(map, i, j, i_length, j_length)
            nr_of_occupied = getNrOfOccupiedSeats(visible_seats)

            if map[i][j] == "L":
                if nr_of_occupied == 0:
                    tmp[i][j] = "#"
                    number_of_toggles +=1
            if map[i][j] == "#":
                if nr_of_occupied >= 5:
                    tmp[i][j] = "L"
                    number_of_toggles +=1

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