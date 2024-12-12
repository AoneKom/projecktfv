import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class BspDatei {

    public static List<String> getNames(String filename) throws IOException {
        Path filePath = Paths.get(filename);
        return Files.readAllLines(filePath);
    }

    public static String getRandomName( List<String> firstNames, List<String> lastNames){
        Random r = new Random();
        int a = r.nextInt(firstNames.size());
        int b = r.nextInt(lastNames.size());
        return firstNames.get(a) + " " + lastNames.get(b);
    }

    public static void main(String[] args) throws IOException {

        List<String> firstNames = getNames("04_vornamen.txt");
        List<String> lastNames = getNames("04_nachnamen.txt");
        String result = "";
        for (int i = 0; i< 100; i++) {
            String r = getRandomName(firstNames, lastNames);
            System.out.println(r);
            result += r;
            result += "\n";


        }
        Files.writeString(Paths.get("100names.txt"), result);

    }
}
