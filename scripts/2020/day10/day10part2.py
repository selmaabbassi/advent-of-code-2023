def numberOfConnections(adapters):
    adapters = [0] + sorted(adapters) + [max(adapters) + 3]

    ways = {}
    ways[0] = 1

    for adapter in adapters[1:]:
    # Sum the ways to reach the last three adapters
        ways[adapter] = (
            ways.get(adapter - 1, 0) + 
            ways.get(adapter - 2, 0) + 
            ways.get(adapter - 3, 0)
        )
    
    total_ways = ways[max(adapters)]
    return total_ways

if __name__ == "__main__":
    all = []
    with open('day10.txt', 'r') as file:
        for line in file:
            all.append(int(line.strip()))

    total_ways = numberOfConnections(all)
    print(total_ways)