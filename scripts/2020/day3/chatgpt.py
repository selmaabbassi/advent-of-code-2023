def count_trees(map, right, down):
    nr_of_trees = 0
    index = right  # Starting index based on 'right'
    
    # Start from the first row for movement
    for i in range(down, len(map), down):
        # Wrap around index to avoid going out of bounds
        index = index % len(map[i])
        
        # Count trees
        if map[i][index] == '#':
            nr_of_trees += 1
        
        # Move to the next right position
        index += right

    return nr_of_trees

def main():
    with open('day3.txt', 'r') as file:
        # Read the map, stripping newline characters
        map = [line.strip() for line in file]
        
    slopes = [(1, 1), (3, 1), (5, 1), (7, 1), (1, 2)]
    product_of_trees = 1
    
    for right, down in slopes:
        trees = count_trees(map, right, down)
        print(f"Slope right {right}, down {down}: {trees} trees")
        product_of_trees *= trees

    print(f"Product of all trees encountered: {product_of_trees}")

if __name__ == "__main__":
    main()