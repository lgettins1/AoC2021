import java.io.BufferedReader;
import java.io.FileReader;

public class Day15 {

    public static void main(String[] args) {
        int rowcount = 0;
        String[] risklevels = new String[100];
        String thisLine;

        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/AoC21Day15inputb.txt"));
            while((thisLine = br.readLine()) != null) {
                risklevels[rowcount] = thisLine.trim();
                rowcount ++;
            }
            String[] path = new String[rowcount];
            String line = "";
            for(int a = 0; a < rowcount; a ++){
                line += ".";
            }
            for(int a = 0; a < rowcount; a ++){
                path[a] = line;
            }
            int curx = 0;
            int cury = 0;
            int endx = rowcount - 1;
            int endy = rowcount - 1;
            Boolean finish = false;
            while(finish == false){

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
