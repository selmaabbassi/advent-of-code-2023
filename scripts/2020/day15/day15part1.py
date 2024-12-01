def number_is_spoken(number):
    if number in memory_game.values():
        return True


def get_next_number(last_number):
    if number_is_spoken(last_number):
        
    else:
        return 0

def get_last_turn():
    return max(memory_game.keys())

def get_last_spoken_number():
    last_turn = max(memory_game.keys())
    return memory_game.get(last_turn)

if __name__ == "__main__":
    memory_game = {1: 0, 2: 3, 3: 6}

    while get_last_turn() <= 2020:
        last_number = get_last_spoken_number()
        get_next_number(last_number)
