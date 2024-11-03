def bubbleSort(arr):
    for n in range(len(arr) - 1, 0, -1):
        # Inner loop to compare adjacent elements
        for i in range(n):
            if arr[i] > arr[i + 1]:
                # Swap elements if they are in the wrong order
                arr[i], arr[i + 1] = arr[i + 1], arr[i]
    return arr

def findDifferences(adapters):
    diff_one = 0
    diff_three = 0
    adapters.insert(0,0)
    adapters.append(max(adapters) + 3)
    
    for i in range(len(adapters)):
        if i == len(adapters)-1:
            print(f"diff_one: {diff_one}, diff_three: {diff_three}")
            print(f"Answer: {diff_one*diff_three}")
            return
        if adapters[i+1] - adapters[i] == 1:
            diff_one+=1
        if adapters[i+1] - adapters[i] == 2:
            continue
        if adapters[i+1] - adapters[i] == 3:
            diff_three+=1


if __name__ == "__main__":
    all = []
    with open('day10.txt', 'r') as file:
        for line in file:
            all.append(int(line.strip()))

    sorted = bubbleSort(all)
    print(sorted)

    findDifferences(sorted)