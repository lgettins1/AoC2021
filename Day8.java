import java.io.BufferedReader;
import java.io.FileReader;

public class Day8 {
    public static void main(String [] args)  {
        String thisLine;

        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/AoC21Day8input.txt"));
            int easydigits = 0;
            while ((thisLine = br.readLine()) != null) {
                String[] line = thisLine.split("\\|");
                String[] c1 = line[0].trim().split(" ");
                String[] c2 = line[1].trim().split(" ");
                for(int a = 0; a < 4; a ++){
                    int b = c2[a].length();
                    if( b == 2 || b == 4 || b == 3 || b ==7) easydigits ++;
                }
            }
            System.out.println("There were " + easydigits + " easy digits");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
