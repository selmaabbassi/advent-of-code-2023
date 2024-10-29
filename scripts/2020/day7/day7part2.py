import re

def numberOfBags(parent, counter, previousCount):
    
    rule = parsed_rules.get(parent, [])
    for count, child in rule:
        current = previousCount * count
        counter += current
        counter = numberOfBags(child, counter, current)
    
    return counter
    
def parseRules():
    parsed_rules = {}
    
    for rule in rules:
        parent = extractParentBag(rule)

        parsed_rules[parent] = []

        if "no other bags" in rule:
            continue

        children = extractChildrenBag(rule)

        for count, color in children:
            parsed_rules[parent].append((int(count), color.strip()))

    return parsed_rules
            

def extractParentBag(rule):
    parent = rule.split("bags contain")[0]
    return parent.strip()

def extractChildrenBag(rule):
    children = rule.split("bags contain")[1]
    return re.findall(r"(\d+) ([a-z ]+?) bag", children)

if __name__ == "__main__":
    rules = []
    with open('day7.txt', 'r') as file:
        for line in file:
            rules.append(line.strip())
    
    parsed_rules = parseRules()
    
    numberOfBags = numberOfBags("shiny gold", 0, 1)

    print(f"Number of bags that shiny gold bag contains is {numberOfBags}")
