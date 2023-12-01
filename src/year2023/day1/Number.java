package year2023.day1;

public enum Number {

        ONE("one", 1),
        TWO("two", 2),
        THREE("three", 3),
        FOUR("four", 4),
        FIVE("five", 5),
        SIX("six", 6),
        SEVEN("seven", 7),
        EIGHT("eight", 8),
        NINE("nine", 9);


        Number(String value, int number) {

        }

        public int getNumber(String value) {
                Number number = Number.valueOf(value);
                return number.getNumber(value);
        }

//        public String getValues(String line) {
//
//                line.contentEquals()
//        }
}
