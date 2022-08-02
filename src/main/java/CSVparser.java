import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CSVparser {
    public static void main(String[] args) throws IOException {

        Pattern pattern = Pattern.compile(",");

        // Parsing the csv data into map data structure
        Map<String, Long> bikes = Files.lines(Paths.get("src/main/resources/data.csv"))
                .skip(1)
                .map(s -> {
                    String[] fields = pattern.split(s);
                    return new Bike(Integer.parseInt(fields[0]), fields[1], fields[2], Integer.parseInt(fields[3]), Integer.parseInt(fields[4]), fields[5]);
                })
                .collect(Collectors.groupingBy(Bike::getModel , Collectors.counting()));


        // Counting every model in the data
        System.out.println("The count of all models");
        bikes
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);

        // Count of the top 5 most sold bike
        System.out.println("The count of all the top 3 models");
        bikes
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= 2)
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);

    }

}

