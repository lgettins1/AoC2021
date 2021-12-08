import java.io.BufferedReader;
import java.io.FileReader;

public class Day7 {
    public static void main(String [] args)  {

        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/AoC21Day7input.txt"));
            String[] thisLine = br.readLine().split(",");
            int minb = 500;
            int maxb = 500;
            int best = 0;

            for (String s : thisLine) {
                int b = Integer.parseInt(s);
                best += b;
                if(b < minb) minb = b;
                if(b > maxb) maxb = b;
            }
            for(int a = minb; a <= maxb; a ++){
                int newbest = 0;
                for (String s : thisLine) {
                    int b = Integer.parseInt(s);
                    newbest += Math.abs(b - a);
                }
                if(newbest < best) best = newbest;
            }
            System.out.println("Part 1: " + best + " units of fuel");
//part 2
            best = 999999999;
            for(int a = minb; a <= maxb; a ++){
                int newbest = 0;
                for (String s : thisLine) {
                    int b = Integer.parseInt(s);
                    for(int c = 1; c <= Math.abs(b - a); c ++) {
                        newbest += c;
                    }
                }
                if(newbest < best)best = newbest;
            }
            System.out.println("Part 2: " + best + " units of fuel");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
