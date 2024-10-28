
def extractColor(rule):
    color = rule.split("bags contain")[0]
    return color

def isChild(searchWord, rule):
    child = rule.split("bags contain")[1]
    return searchWord in child

def isParent(searchWord, relevantLines):
    for t in relevantLines:
        if isChild(searchWord, t):
            return False

def findParentBags(searchWord, parents):
    for l in arr:
        if isParent(searchWord, parents):
            return parents
        if searchWord in l and isChild(searchWord, l):
            parents.append(l)
    
def test(searchWord):
    print("Searching ", searchWord)
    if(isParent(searchWord, relevantLines)):
        print("searchword is parent:", searchWord)
        return

    parents = findParentBags(searchWord)
    


if __name__ == "__main__":
    arr = []
    with open('tst.txt', 'r') as file:
        for line in file:
            arr.append(line.strip())
    
    relevantLines = []
    findParentBags("shiny gold")
    print(relevantLines)
