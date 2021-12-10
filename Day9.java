import java.io.BufferedReader;
import java.io.FileReader;

public class Day9 {
    public static void main(String[] args) {
        String thisLine;
        int[][] floormap = new int[100][100];
        int currow = 0;
        int risksum = 0;
        int al = 0;
        int bl;
        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/AoC21Day9input.txt"));
            while((thisLine = br.readLine()) != null){
                for(int a = 0; a < thisLine.length(); a ++){
                    int b = Character.getNumericValue(thisLine.charAt(a));
                    floormap[a][currow] = b;
                }
                currow ++;
                al = thisLine.length() - 1;
            }
            bl = currow - 1;

            for(int a = 0; a <= al; a ++){
                for(int b = 0; b <= bl; b ++){
                    int ch = floormap[a][b];
                    int winner = 1;
                    if(a > 0 && floormap[a - 1][b] <= ch) winner = 0;
                    if(a < al  && floormap[a + 1][b] <= ch) winner = 0;
                    if(b > 0 && floormap[a][b - 1] <= ch) winner = 0;
                    if(b < bl  && floormap[a][b + 1] <= ch)  winner = 0;

                    if(winner == 1)  {
                        risksum += (1 + ch);
                        System.out.println(a + " " + b + " " + ch + " " + risksum);
                    }
                }
            }
            System.out.println(risksum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
