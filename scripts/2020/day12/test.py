class Navigator:
    def __init__(self):
        self.direction = "East"
        self.position = {"North": 0, "East": 0, "South": 0, "West": 0}
        self.compass = ["North", "East", "South", "West"]

    def goForward(self, step):
        if self.direction == "North":
            self.position["North"] += step
        if self.direction == "East":
            self.position["East"] += step
            print(f"New Position: {self.position}")
        if self.direction == "South":
            self.position["South"] += step
        if self.direction == "West":
            self.position["West"] += step
    
    def goRight(self, step):
        number_of_turns = step / 90

        if self.direction == "North":
            self.direction = self.getNextRight("North", number_of_turns)
        if self.direction == "West":
            self.direction = self.getNextRight("West", number_of_turns)
        if self.direction == "South":
            self.direction = self.getNextRight("South", number_of_turns)
        if self.direction == "East":
            self.direction = self.getNextRight("East", number_of_turns)
    
    def goLeft(self, step):
        number_of_turns = step / 90

        if self.direction == "North":
            self.direction = self.getNextLeft("North", number_of_turns)
        if self.direction == "East":
            self.direction = self.getNextLeft("East", number_of_turns)
        if self.direction == "South":
            self.direction = self.getNextLeft("South", number_of_turns)
        if self.direction == "West":
            self.direction = self.getNextLeft("West", number_of_turns)

    def getNextRight(self, current, turns):
        current_index = self.compass.index(current)
        
        length = len(self.compass)

        if ((current_index + turns) > length - 1):
            next_index = length - (current_index + turns)
        else:
            next_index = current_index + turns
        
        return self.compass[next_index] 
    
    
    def getNextLeft(self, current, turns):
        current_index = self.compass.index(current)
        
        length = len(self.compass)

        if ((current_index - turns) <= 0):
            next_index = length + (current_index - turns)
        else:
            next_index = current_index - turns
        
        return self.compass[next_index] 
        

if __name__ == "__main__":
    instructions = []
    with open('tst.txt', 'r') as file:
        for line in file:
            instructions.append(line.strip())

    navigator = Navigator()
    navigator.goForward(4)
    print(instructions)