import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> mapVotes = new HashMap<>();

        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {

                // PROCESSAR A LINHA

                String[] fields = line.split(", ");

                String name = fields[0];
                Integer votes = Integer.parseInt(fields[1]);

                if(mapVotes.get(name) == null){
                    mapVotes.put(name, votes);

                } else{
                    mapVotes.put(name, votes + mapVotes.get(name));

                }

                line = br.readLine();
            }

            for (String key : mapVotes.keySet()) {
                System.out.println(key + ": " + mapVotes.get(key));
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}