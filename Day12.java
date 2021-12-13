import java.io.BufferedReader;
import java.io.FileReader;

public class Day12 {
    public static String[][] pairs = new String[100][2];
    public static int entry = 0;
    public static int pathcount = 0;

    public static void main(String[] args) {
        String thisLine;
        String[]lc = new String[18];
        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/AoC21Day12input.txt"));
            while ((thisLine = br.readLine()) != null) {
                pairs[entry] = thisLine.split("-");
                entry ++;
            }
            findend("start", "", lc, 0);
            System.out.println(pathcount + " unique paths.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void findend(String f, String path, String[] littlecave, int lcd){
        path += f + ",";
        for(int a = 0; a < entry; a ++){
            String nextcave = "";
            int newlcd = lcd;
            if(pairs[a][0].trim().equals(f.trim()))nextcave = pairs[a][1];
            if(pairs[a][1].trim().equals(f.trim()))nextcave = pairs[a][0];
            switch (nextcave){
                case "":
                case "start":
                    break;
                case "end":
                    System.out.println((pathcount + 1) + " - " + path + "end ");
                    pathcount ++;
                    break;
                default:
                    int cavegood = 1;
                    if(nextcave.charAt(0) > 96) {
                        for (int b = 0; b < newlcd; b++){
                            if (nextcave.trim().equals(littlecave[b])) {
                                cavegood = 0;
                                break;
                            }
                        }
                        if(cavegood == 1){
                            littlecave[newlcd] = nextcave;
                            newlcd++;
                        }
                    }
                    if (cavegood == 1) {
                        findend(nextcave, path, littlecave, newlcd);
                    }
            }
        }
    }
}


