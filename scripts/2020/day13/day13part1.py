def is_exact_division(time, bus):
    return time % bus == 0

def findBus(my_time, buses):
    bus_found = False
    earliest_bus = None
    wait_time = None
    counter = my_time
    
    while bus_found is False:
        counter += 1
        print(f"Counter: {counter}")
        for bus in buses:
            if is_exact_division(counter, bus):
                print(f"Earliest bus is: {bus}")
                earliest_bus = int(bus)
                wait_time = int(counter - my_time)
                print(f"Wait time: {wait_time}")
                bus_found = True
    
    return earliest_bus * wait_time
                


if __name__ == "__main__":
    #my_time = 939
    #buses = [7,13,59,31,19]

    my_time = 1001798
    buses = [19,41,859,23,13,17,29,373,37]
    result = findBus(my_time, buses)
    print(f"The answer is: {result}")
    
