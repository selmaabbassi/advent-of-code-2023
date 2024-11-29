import re


def get_binary(value):
    return format(value, "036b")


def calculate(mask, instructions):
    for instruction in instructions:
        val = instruction["value"]
        binary = get_binary(val)
        print(f"Binary value of {val} is {binary}")


if __name__ == "__main__":
    instructions = []
    mask = ""
    with open("tst.txt", "r") as file:
        for line in file:
            if line.__contains__("mask"):
                mask = line.split("=")[1].strip()
            else:
                groups = re.match(r"\D+(\d)\D+(\d+)", line).groups()
                instructions.append(
                    {"position": int(groups[0]), "value": int(groups[1])}
                )

    print(f"mask: {mask}, instructions: {instructions}")
    calculate(mask, instructions)

    ##Idea.. create a class Instructions that can take each block of mem instructions to it's specific mask
    ## OBS you will need a global list of positions for the values
