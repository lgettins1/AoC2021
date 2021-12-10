import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Day9b {
    public static int[][] floormap = new int [100][100];
    public static int al = 0;
    public static int bl;

    public static void main(String[] args) {
        String thisLine;
        int currow = 0;
        int[] basinsizes = new int[1000];
        int basincount= 0;
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
                    if(floormap[a][b] < 9){
                        int bs = sizebasin(a, b);
                        basinsizes[basincount] = bs;
                        basincount ++;
                    }
                }
            }
            Arrays.sort(basinsizes);
            System.out.print(basinsizes[basinsizes.length - 1] + " x " + basinsizes[basinsizes.length - 2]
                    + " x " + basinsizes[basinsizes.length - 3] + " = ");
            System.out.print(basinsizes[basinsizes.length - 1] * basinsizes[basinsizes.length - 2]
                    * basinsizes[basinsizes.length - 3]);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int sizebasin(int a, int b){
        int bs = 1;
        floormap[a][b] = 9;
        if(a > 0 && floormap[a - 1][b] < 9) bs += sizebasin(a - 1,b);
        if(a < al && floormap[a + 1][b] < 9) bs += sizebasin(a + 1,b);
        if(b > 0 && floormap[a][b - 1] < 9) bs += sizebasin(a,b - 1);
        if(b < bl && floormap[a][b + 1] < 9) bs += sizebasin(a ,b + 1);
        return bs;
    }
}
