import re
from typing import List


class InstructionBlock:
    def __init__(self, mask):
        self.mask = mask
        self.instructions = []

    def add_instruction(self, address, value):
        self.instructions.append({"address": address, "value": value})

    def get_mask(self):
        return self.mask

    def get_instructions(self):
        return self.instructions

    def print(self):
        print(f"Mask: {self.mask}, Instructions: {self.instructions}")


class Interpreter:
    def __init__(self, blocks: List[InstructionBlock]):
        self.memory = {}
        self.blocks = blocks

    def interpret(self):
        for block in self.blocks:
            for instruction in block.get_instructions():
                self.__update_memory(block.get_mask(), instruction)

        return self.memory

    def __update_memory(self, mask, instruction):
        address = instruction["address"]
        binary_value = self.__get_binary(instruction["value"])
        masked_value = self.__get_masked_value(mask, binary_value)
        self.memory.update({address: masked_value})

    def __get_binary(self, value):
        return format(value, "036b")

    def __get_masked_value(self, mask, binary_value):
        mask_chars = list(mask)
        binary_value_chars = list(binary_value)

        for i in range(len(binary_value_chars)):
            if mask_chars[i] == "X":
                continue
            else:
                binary_value_chars[i] = mask_chars[i]

        masked_value = "".join(binary_value_chars)

        return int(masked_value, 2)


if __name__ == "__main__":
    with open("day14.txt") as f:
        lines = f.read().splitlines()

blocks = []
current_block = None

for line in lines:
    if line.startswith("mask"):
        mask = line.split(" = ")[1]
        current_block = InstructionBlock(mask)
        blocks.append(current_block)
    elif line.startswith("mem"):
        match = re.match(r"mem\[(\d+)\] = (\d+)", line)
        if match:
            address, value = match.groups()
            current_block.add_instruction(int(address), int(value))

# for block in blocks:
# block.print()

interpreter = Interpreter(blocks)
memory = interpreter.interpret()

result = sum(value for value in memory.values())

print(f"Memory: {memory}")
print(f"Answer: {result}")
