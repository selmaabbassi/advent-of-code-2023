package year2015.day3;

public class House {

    private final int x;
    private final int y;

    public House(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        House other = (House) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public String toString() {
        return "House (" + x + "," + y + ")";
    }
}
