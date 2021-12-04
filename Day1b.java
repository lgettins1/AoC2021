import java.io.BufferedReader;
import java.io.FileReader;

public class Day1b {
    public static void main(String [] args)  {

        String thisLine;
        int firstVal;
        int secondVal;
        int thirdVal;
        int window = 1000;
        int depthIncreaseCount = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/AoC21Day1input.txt"));
            firstVal = Integer.parseInt(br.readLine());
            secondVal = Integer.parseInt(br.readLine());

            while ((thisLine = br.readLine()) != null) {
                thirdVal = Integer.parseInt(thisLine);
                if ((firstVal + secondVal + thirdVal) > window){
                    depthIncreaseCount ++;
                }
                window = firstVal + secondVal + thirdVal;
                firstVal = secondVal;
                secondVal = thirdVal;

            }
            System.out.println(depthIncreaseCount + " measurements are larger than the previous measurement");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


