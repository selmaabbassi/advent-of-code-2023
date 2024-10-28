import re

def containsBag(parent):
    rule = parsed_rules.get(parent, [])

    for count, child in rule:
        if child == "shiny gold":
            return 1
        if containsBag(child):
            return 1
    return 0

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
    
    count = 0
    parsed_rules = parseRules()
    
    for parent_bag, children in parsed_rules.items():
        count += containsBag(parent_bag)

    print(f"Number of bags that can contain shiny gold bag is {count}")
