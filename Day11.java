import java.io.BufferedReader;
import java.io.FileReader;

public class Day11 {
    public static int[][] octopuses = new int[12][12];

    public static void main(String[] args) {
        String thisLine;
        for(int a = 0; a < 12; a ++){
            for(int b = 0; b < 12; b ++){
                octopuses[a][b] = 0;
            }
        }
        int lineno = 1;
        int sz = 11;

        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/AoC21Day11input.txt"));
            while((thisLine = br.readLine()) != null){
               for(int a = 0; a < thisLine.length(); a ++){
                   octopuses[lineno][a + 1] = Integer.parseInt(thisLine.substring(a, a + 1));
               }
               lineno ++;
            }
            int flashcount = 0;
            int winstep = 0;
            int step = 0;
            while(winstep == 0){
                int numzeros = 0;
                for (int a = 1; a < sz; a++) {
                    for (int b = 1; b < sz; b++) {
                        if(octopuses[a][b] == 0) {
                            flashcount ++;
                            numzeros ++;
                        }
                        octopuses[a][b]++;
                    }
                }
                if(numzeros == (sz - 1) * (sz - 1)) {
                    winstep = step;
                }
                for (int a = 1; a < sz; a++) {
                    for (int b = 1; b < sz; b++) {
                        if (octopuses[a][b] == 10) {
                            octopuses[a][b] = 0;
                            update(a, b, sz);
                         }
                    }
                }
                for (int a = 1; a < sz; a++) {
                    for (int b = 1; b < sz; b++) {
                        if (octopuses[a][b] >= 10) {
                            octopuses[a][b] = 0;
                        }
                    }
                }

                for (int a = 1; a < sz; a++) {
                    for (int b = 1; b < sz; b++) {
                        System.out.print(octopuses[a][b] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
                System.out.println(flashcount);
                System.out.println(winstep);
                System.out.println();
                step ++;

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void update(int a, int b, int sz){
        if(a < 1) a = 1;
        if(a >= sz) a = sz - 1;
        if(b < 1) b = 1;
        if(b >= sz) b = sz - 1;
        for (int c = a - 1; c <= a + 1; c++) {
            for (int d = b - 1; d <= b + 1; d++) {
                if (octopuses[c][d] > 0 && octopuses[c][d] < 10) {
                    octopuses[c][d] ++;
                    if(c != a || d != b ){
                       if(octopuses[c][d] == 10){
                           octopuses[c][d] = 0;
                           update(c, d, sz);
                       }
                    }
                }
            }
        }
    }

}
