import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BikeTest {

    @Test
    public void readsHeader() throws IOException {

        Pattern pattern = Pattern.compile(",");
        Map<String, Long> bikes = Files.lines(Paths.get("src/main/resources/data.csv"))
                .skip(1)
                .map(s -> {
                    String[] fields = pattern.split(s);
                    return new Bike(Integer.parseInt(fields[0]), fields[1], fields[2], Integer.parseInt(fields[3]), Integer.parseInt(fields[4]), fields[5]);
                })
                .collect(Collectors.groupingBy(Bike::getModel , Collectors.counting()));
        bikes
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= 2)
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);

        Map<String, Integer> expected = new HashMap<String, Integer>();
        expected.put("ec 5",4);
        expected.put("beryll",3);
        expected.put("et 9 evo",2);

        Assert.assertEquals(expected,bikes);


    }
}
