class PasswordValidator:
    global min
    global max
    global char
    global string

    def __init__(self, line):    
        s0 = line.split(":")
        self.string = s0[1].strip()

        s1 = s0[0].split("-")
        self.min = int(s1[0])

        s2 = s1[1].split(" ")
        self.max = int(s2[0])
        self.char = s2[1]
    
    def password_is_valid(self):
        charAtMin = self.string[self.min - 1]
        charAtMax = self.string[self.max - 1]
        if(self.char == charAtMin and self.char == charAtMax):
            return 0
        if(self.char != charAtMin and self.char != charAtMax):
            return 0
        if(self.char == charAtMin or self.char == charAtMax):
            return 1


if __name__ == "__main__":
    count = 0
    with open('day2.txt', 'r') as file:
        for line in file:
            validator = PasswordValidator(line.strip())
            count += validator.password_is_valid()
    
    print(f"The number of valid passwords is: {count}")