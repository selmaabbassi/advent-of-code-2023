def findRange(target, queue):
    for i in range(len(queue)):
        counter = 0
        found = []
        for j in range(i+1, len(queue)):
            if counter > target:
                break
            elif counter == target:
                print(f"Range found! {found}")
                weakness = findWeakness(found)
                print(f"Encryption weakness is {weakness} ")
                return True
            else:
                found.append(queue[j])
                counter += queue[j]
    return False

def findWeakness(arr):
    for n in range(len(arr) - 1, 0, -1):
        # Inner loop to compare adjacent elements
        for i in range(n):
            if arr[i] > arr[i + 1]:
                # Swap elements if they are in the wrong order
                arr[i], arr[i + 1] = arr[i + 1], arr[i]

    return arr[0] + arr[len(arr)-1]

    

if __name__ == "__main__":
    all = []
    with open('day9.txt', 'r') as file:
        for line in file:
            all.append(int(line.strip()))

    numbers = all.copy()
    target = 1492208709

    findRange(target, numbers)

    
