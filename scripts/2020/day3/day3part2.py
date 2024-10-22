class TreeFinder:
    global map
    def __init__(self, map):    
        self.map = map

    def traverseTrees(self, right, down):
        nr_of_trees = 0
        index = right
        i = down
        
        while i < len(self.map):
            index = index % len(self.map[i])
            nr_of_trees += self.isTree(self.map[i], index)
            
            index += right
            i += down
            
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
    count1 = tree_finder.traverseTrees(1,1)
    count2 = tree_finder.traverseTrees(3,1)
    count3 = tree_finder.traverseTrees(5,1)
    count4 = tree_finder.traverseTrees(7,1)
    count5 = tree_finder.traverseTrees(1,2)

    print(count1)
    print(count2)
    print(count3)
    print(count4)
    print(count5)

    result = count1 * count2 * count3 * count4 * count5
    
    print(f"The product of number of traversed trees is: {result}")