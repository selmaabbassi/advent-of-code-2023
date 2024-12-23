def calculate():
    counter = 0
    handledIndexes = []
    i = 0

    while i < len(instructions):
        if i in handledIndexes:
            return counter
        
        handledIndexes.append(i)
        instruction = instructions[i]
        
        if "acc" in instruction:
            acc = instruction.split(" ")
            if "+" in acc[1]:
                counter += int(acc[1].split("+")[1])
            elif "-" in acc[1]:
                counter -= int(acc[1].split("-")[1])
            i += 1

        elif "jmp" in instruction:
            jmp = instruction.split(" ")
            if "+" in jmp[1]:
                i += int(jmp[1].split("+")[1])
            elif "-" in jmp[1]:
                i -= int(jmp[1].split("-")[1])
        
        else:
            i+=1


if __name__ == "__main__":
    instructions = []
    with open('tst.txt', 'r') as file:
        for line in file:
            instructions.append(line.strip())

    count = calculate()
    print(f"Accumulated number is {count}")