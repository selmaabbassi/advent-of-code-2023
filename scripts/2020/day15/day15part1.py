def number_is_spoken(number):
    if number in memory_game.values():
        return True


def get_previously_spoken_turn(number):
    max_key = 0

    for key, value in memory_game.items():
        if value == number & key > max_key:
            max_key = key


def get_next_turn(last_turn, last_spoken_number):
    next_turn = last_turn + 1
    if number_is_spoken(last_spoken_number):
        next_number = last_turn - get_previously_spoken_turn(last_spoken_number)
        return next_turn, next_number
    else:
        return next_turn, 0


def get_last_turn():
    return max(memory_game.keys())


def get_last_turn_and_value():
    last_turn = get_last_turn()
    return (last_turn, memory_game[last_turn])


if __name__ == "__main__":
    memory_game = {1: 0, 2: 3, 3: 6}

    while get_last_turn <= 2020:
        last_turn, last_spoken_number = get_last_turn_and_value()
        turn, number = get_next_turn(last_turn, last_spoken_number)
        memory_game.update({turn: number})
