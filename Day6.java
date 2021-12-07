import java.io.BufferedReader;
import java.io.FileReader;

public class Day6 {
    public static void main(String [] args)  {
        String thisLine;
        int[] single = new int[6000];
        int[] scount = new int[90];
        for(int x = 0; x < 89; x ++){
            scount[x] = 0;
        }
        scount[0] = 1;
        single[0] = 6;
        for(int days = 0; days < 89; days ++){
            scount[days + 1] = scount[days];
            for(int scan = 0; scan < scount[days]; scan ++){
                if(single[scan] > 0){
                    single[scan] = single[scan] - 1;
                } else {
                    single[scan] = 6;
                    single[scount[days + 1]] = 8;
                    scount[days + 1] ++;
                }
           }
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/AoC21Day6input.txt"));
            long lanternfish = 0;
            thisLine = br.readLine();
            String[] startlist = thisLine.split(",");
            for (String s : startlist) {
                lanternfish += scount[86 - Integer.parseInt(s)];
            }
            System.out.println(lanternfish + " lanternfish");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
