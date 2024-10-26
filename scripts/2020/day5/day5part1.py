import math

class SeatFinder:    
    def __init__(self, line):
        chars = list(line)
        self.rows = chars[:7]
        self.cols = chars[7:]

    def findSeatId(self):
        seat_row = self.getSeatRow(0, 127, 0)
        seat_col = self.getSeatCol(0, 7, 0)
        seat_id = (seat_row * 8) + seat_col
        return seat_id
            
    def getSeatRow(self, min, max, index):
        if(index == len(self.rows)):
            return min

        if self.rows[index] == 'F':
            mid = int(math.floor((min + max) / 2))
            return self.getSeatRow(min, mid, index+1)
        if self.rows[index] == 'B':
            mid = int(math.ceil((min + max) / 2))
            return self.getSeatRow(mid, max, index+1)

    def getSeatCol(self, min, max, index):
        if(index == len(self.cols)):
            return min

        if self.cols[index] == 'L':
            mid = int(math.floor((min + max) / 2))
            return self.getSeatCol(min, mid, index+1)
        if self.cols[index] == 'R':
            mid = int(math.ceil((min + max) / 2))
            return self.getSeatCol(mid, max, index+1)

if __name__ == "__main__":
    arr = [];
    with open('day5.txt', 'r') as file:
        for line in file:
            arr.append(line.strip());

    
    seatIds = []
    for a in arr:
        finder = SeatFinder(a)
        seatIds.append(finder.findSeatId())

    seatIds.sort()
    print(seatIds)
    print("Max seatID: " + str(max(seatIds)))