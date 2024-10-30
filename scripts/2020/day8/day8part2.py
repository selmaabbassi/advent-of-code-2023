def calculate(tmp):
    counter = 0
    handledIndexes = []
    i = 0

    while i <= len(tmp):
        if i in handledIndexes:
            return counter, i
        
        if i == len(tmp):
            return counter, i

        instruction = tmp[i]
        handledIndexes.append(i)
        
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

def toggleInstruction(index, tmp):
    if "nop" in tmp[index]:
        tmp[index] = tmp[index].replace("nop", "jmp")
    elif "jmp" in tmp[index]:
        tmp[index] = tmp[index].replace("jmp", "nop")

def testExecute():
    i = 0
    
    while i < len(instructions):
        tmp = instructions.copy()
        if "jmp" in instructions[i] or "nop" in instructions[i]:
            toggleInstruction(i, tmp)
            counter, endIndex = calculate(tmp)

            if(endIndex == len(instructions)):
                return counter
        i+=1



if __name__ == "__main__":
    instructions = []
    with open('day8.txt', 'r') as file:
        for line in file:
            instructions.append(line.strip())

    count = testExecute()
    print(f"Accumulated number is {count}")