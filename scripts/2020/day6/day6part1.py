if __name__ == "__main__":
    with open('day6.txt', 'r') as file:
        content = file.read()

    groups = list(map(lambda x: x.replace('\n', ''), content.strip().split('\n\n')))

    count = 0
    for group in groups:
        test = list(set(group))
        count += len(test)

    print(count)
    