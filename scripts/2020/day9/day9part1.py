def isValid(target, queue):
    for i in range(len(queue)):
        for j in range(i+1, len(queue)):
            if queue[i] + queue[j] == target:
                return True
    return False
    

if __name__ == "__main__":
    all = []
    with open('day9.txt', 'r') as file:
        for line in file:
            all.append(int(line.strip()))

    queue = all[:25]
    numbers = all[25:]
    
    for n in numbers:
        if isValid(n, queue) == False:
            print(f"First invalid number is: {n}")
            break
        else:
            queue.pop(0)
            queue.append(n)

    
