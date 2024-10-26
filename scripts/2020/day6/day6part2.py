class Group:
    def __init__(self, group):
        self.persons = self.initPersons(group)
        print(self.persons)

    def initPersons(self, group):
        for person_answer in group:
            self.persons.append(Person(person_answer))

    def printPersons(self):
        print(self.persons)


class Person:
    def __init__(self, answers):
        self.answers = answers

if __name__ == "__main__":
    with open('tst.txt', 'r') as file:
        content = file.read()

    list = list(map(lambda x: x.replace('\n', ''), content.strip().split('\n\n')))

    groups = []
    for group in list:
        groups.append(Group(group))