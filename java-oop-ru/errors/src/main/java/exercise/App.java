package exercise;

// BEGIN
public class App {

    public static void printSquare(Circle circle) {

        try {
            System.out.println((int) Math.round(circle.getSquare()));
        } catch (NegativeRadiusException e) {
            System.out.println("Не удалось посчитать площадь");
        }
        System.out.println("Вычисление окончено");
    }
}

// END