from typing import List

class Group:
    def __init__(self, group):
        self.persons = []
        self.initPersons(group)
        #self.printGroup()

    def initPersons(self, group):
        for person_answers in group:
            self.persons.append(Person(person_answers))

    def printGroup(self):
        print("Group:", hash(self))
        for person in self.persons:
            person.printAnswers()

    def calculateAnswers(self):
        all_answers = []

        for person in self.persons:
            all_answers.append(person.getAnswers())
        
        common_answers = set(all_answers[0]).intersection(*all_answers[1:])
        return len(common_answers)
    


class Person:
    def __init__(self, answers):
        self.answers = list(answers)

    def printAnswers(self):
        print(hash(self), self.answers)
    
    def getAnswers(self):
        return self.answers

if __name__ == "__main__":
    with open('day6.txt', 'r') as file:
        content = file.read()

    strings = list(content.strip().split('\n\n'))
    list_of_lists = [s.split('\n') for s in strings]

    groups:List[Group] = []
    for group in list_of_lists:
        groups.append(Group(group))
    
    count = 0

    for group in groups:
        count += group.calculateAnswers()

    print(f"Sum of counts is: {count}")