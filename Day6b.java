import java.io.BufferedReader;
import java.io.FileReader;

public class Day6b {
    public static void main(String [] args)  {

        long[] fish = new long[9];
        for(int a = 0; a < 9; a ++){
            fish[a] = 0;
        }
        long lanternfish = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/AoC21Day6input.txt"));
            String[] thisLine = br.readLine().split(",");
            for (String s : thisLine) {
                int b = Integer.parseInt(s);
                fish[b]++;
            }
            for(int day = 0; day < 256; day ++){
                long newfish = fish[0];
                fish[0] = fish[1];
                fish[1] = fish[2];
                fish[2] = fish[3];
                fish[3] = fish[4];
                fish[4] = fish[5];
                fish[5] = fish[6];
                fish[6] = fish[7] + newfish;
                fish[7] = fish[8];
                fish[8] = newfish;
            }
            for(int a = 0; a < 9; a ++){
                lanternfish += fish[a];
            }


            System.out.println(lanternfish + " lanternfish");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
