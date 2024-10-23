class TreeFinder:
    global map
    def __init__(self, map):    
        self.map = map

    def traverseTrees(self):
        nr_of_trees = 0
        index = 3
        for road in self.map[1:]:
            if index >= len(road):
                index = index - len(road)
            nr_of_trees += self.isTree(road, index)
            index += 3
            
        return nr_of_trees
    
    def isTree(self, road, index):
        if road[index] == ".":
            return 0
        if road[index] == "#":
            return 1
        
if __name__ == "__main__":
    with open('day3.txt', 'r') as file:
        lines = [list(line.strip()) for line in file]
        
    tree_finder = TreeFinder(lines)
    count = tree_finder.traverseTrees()
    
    print(f"The number of traversed trees is: {count}")