import java.io.BufferedReader;
import java.io.FileReader;

public class Day5 {
    public static void main(String [] args)  {
        String thisLine;
        int[][] grid = new int [1000][1000];
        for(int a = 0; a < 1000; a ++)
            for (int b = 0; b < 1000; b++) {
                grid[a][b] = 0;
            }

        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/AoC21Day5input.txt"));

            while ((thisLine = br.readLine()) != null) {
                String[] line = thisLine.split(" ");
                String[] c1 = line[0].split(",");
                String[] c2 = line[2].split(",");
                int x1 = Integer.parseInt(c1[0]);
                int y1 = Integer.parseInt(c1[1]);
                int x2 = Integer.parseInt(c2[0]);
                int y2 = Integer.parseInt(c2[1]);
                if(x1 == x2 || y1 == y2){
                    for(int a = ((x1 + x2)  - Math.abs( x1 - x2)) / 2; a <= ((x1 + x2) + Math.abs(x1 - x2)) / 2; a ++){
                        for(int b = ((y1 + y2) - Math.abs( y1 - y2)) / 2; b <= ((y1 + y2) + Math.abs(y1 - y2)) / 2; b ++) {
                            grid[a][b] ++;
                        }
                    }
                } else {
                    for (int a = 0; a <= Math.abs(x1 - x2); a ++){
                        int x = x1 + a * ((x2 - x1) / Math.abs(x2 - x1));
                        int y = y1 + a * ((y2 - y1) / Math.abs(y2 - y1));
                        grid[x][y] ++;
                    }
                }
            }
            int count = 0;
            for(int a= 0; a < 1000; a ++){
                for(int b = 0; b < 1000; b ++){
                    if(grid[a][b] > 1){
                        count ++;
                    }
                }
            }
            System.out.println(count + " overlapped locations");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
