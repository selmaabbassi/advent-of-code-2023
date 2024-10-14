def find_two_entries(expenses, target_sum=2020):
    seen = set()
    for number in expenses:
        complement = target_sum - number
        if complement in seen:
            return number * complement
        seen.add(number)
    return None

if __name__ == "__main__":
    with open('day1.txt', 'r') as file:
        expenses = [int(line.strip()) for line in file] 
    
    result = find_two_entries(expenses)
    print(f"The product of the two entries is: {result}")
