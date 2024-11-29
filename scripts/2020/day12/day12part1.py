import re

class Navigator:
    def __init__(self):
        self.x = 0
        self.y = 0 
        self.degree = 0

    def goNorth(self, step):
        self.y += step
    def goSouth(self, step):
        self.y -= step
    def goEast(self, step):
        self.x += step
    def goWest(self, step):
        self.x -= step
    
    def goLeft(self, turn):
        self.degree = (self.degree - turn + 360) % 360
    def goRight(self, turn):
        self.degree = (self.degree + turn) % 360
    
    def goForward(self, step):
        if self.degree == 0:
            self.goEast(step)
        if self.degree == 90:
            self.goSouth(step)
        if self.degree == 180:
            self.goWest(step)
        if self.degree == 270:
            self.goNorth(step)

    def getPosition(self):
        return (self.x, self.y)

    def getManhattanDistance(self):
        return abs(self.x) + abs(self.y)


if __name__ == "__main__":
    instructions = []
    with open('day12.txt', 'r') as file:
        for line in file:
            groups = re.match(r"([A-Z])([0-9]*)", line).groups()
            instructions.append((groups[0], int(groups[1])))

    print(instructions)

    navigator = Navigator()

    for (key,value) in instructions:
        if key == "N":
            navigator.goNorth(value)
        if key == "E":
            navigator.goEast(value)
        if key == "S":
            navigator.goSouth(value)
        if key == "W":
            navigator.goWest(value)
        if key == "L":
            navigator.goLeft(value)
        if key == "R":
            navigator.goRight(value)
        if key == "F":
            navigator.goForward(value)

    position = navigator.getPosition()
    manhattan_distance = navigator.getManhattanDistance()
    
    print(f"Final position {position}")
    print(f"Manhattan distance {manhattan_distance}")