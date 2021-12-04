import java.io.BufferedReader;
import java.io.FileReader;

public class Day1 {
    public static void main(String [] args) {

        String thisLine;
        int firstVal;
        int secondVal;
        int depthIncreaseCount = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/AoC21Day1input.txt"));
            firstVal = Integer.parseInt(br.readLine());
            while ((thisLine = br.readLine()) != null) {
                secondVal = Integer.parseInt(thisLine);
                if (secondVal > firstVal){
                    depthIncreaseCount ++;
                }
                firstVal = secondVal;

            }
            System.out.println(depthIncreaseCount + " measurements are larger than the previous measurement");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
