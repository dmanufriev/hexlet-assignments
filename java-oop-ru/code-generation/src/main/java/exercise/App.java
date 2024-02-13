package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {

    public static void save (Path filePath, Car car) throws IOException {
        Files.writeString(filePath, car.serialize(), StandardOpenOption.WRITE);
    }

    public static Car extract (Path filePath) throws IOException {
        String carJson = Files.readString(filePath);
        return Car.unserialize(carJson);
    }

}

// END
