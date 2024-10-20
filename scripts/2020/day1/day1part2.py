def find_two_entries(expenses, target_sum, exclude_index):
    seen = set()
    for j in range(len(expenses)):
        if j == exclude_index:
            continue
        number = expenses[j]
        complement = target_sum - number
        if complement in seen:
            return number, complement
        seen.add(number)
    return None

def find_three_entries(expenses, target_sum=2020):
    for i in range(len(expenses)):
        first = expenses[i]
        result = find_two_entries(expenses, target_sum - first, i)
        if result:
            second, third = result
            return first * second * third
    return None

if __name__ == "__main__":  
    with open('day1.txt', 'r') as file:
        expenses = [int(line.strip()) for line in file] 
    
    result = find_three_entries(expenses)
    print(f"The product of the three entries is: {result}")
