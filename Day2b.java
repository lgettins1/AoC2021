import java.io.BufferedReader;
import java.io.FileReader;

public class Day2b {
    public static void main(String [] args)  {

    String thisLine;
    int depth = 0;
    int distance = 0;
    int aim = 0;

    try
    {
        BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/AoC21Day2input.txt"));

        while ((thisLine = br.readLine()) != null) {
            String[] aa = thisLine.split(" ");
            switch(aa[0]) {
                case "forward" -> {
                    distance += Integer.parseInt(aa[1]);
                    depth += (aim * Integer.parseInt(aa[1]));
                }
                case "up" -> {
                    aim -= Integer.parseInt(aa[1]);
                }
                case "down" -> {
                    aim += Integer.parseInt(aa[1]);
                }
            }
        }
        System.out.println("Final distance " + distance + " Final depth " + depth);
        System.out.println("Answer is " + (distance * depth));

    }catch (Exception e) {
        e.printStackTrace();
    }
}
}
