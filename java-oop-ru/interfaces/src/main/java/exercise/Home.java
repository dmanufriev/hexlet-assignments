package exercise;

// BEGIN
public interface Home extends Comparable<Home> {
    double getArea();
    default int compareTo(Home another) {
        return Double.compare(getArea(), another.getArea());
    }
}

// END
