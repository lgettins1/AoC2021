import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Day12b {

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
            findend("start", "", lc, 0, 1);
            System.out.println(pathcount);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void findend(String f, String path, String[] lc, int lcd, int unique){
        path += f;
        path += ",";
        ArrayList<String> nextcave = new ArrayList<>();
        ArrayList<String> uppercase = new ArrayList<>();
        ArrayList<String> end = new ArrayList<>();
        ArrayList<String> lowercase = new ArrayList<>();
        ArrayList<String> previouscave = new ArrayList<>();


        for(int a = 0; a < entry; a ++) {
            if (pairs[a][0].trim().equals(f.trim())) nextcave.add(pairs[a][1]);
            if (pairs[a][1].trim().equals(f.trim())) nextcave.add(pairs[a][0]);
        }
        for (String value : nextcave) {
            if (value.charAt(0) > 96) {
                switch (value) {
                    case "start":
                        break;
                    case "end":
                        end.add(value);
                        break;
                    default:
                        lowercase.add(value);
                }
            } else {
                uppercase.add(value);
            }
        }

        for (String s : uppercase) {
            findend(s, path, lc, lcd, unique);
        }
        for (String value : lowercase) {
            for (int b = 0; b < lcd; b ++) {
                if (value.trim().equals(lc[b])) {
                    previouscave.add(value);
                }
            }
        }
        if(unique == 1) {
            for (String s : previouscave) {
                findend(s, path, lc, lcd, 0);
            }
        }
        for (String s : lowercase) {
            int newlcd = lcd;
            int cavegood = 1;
            for (int b = 0; b < newlcd; b++) {
                if (s.trim().equals(lc[b])) {
                    cavegood = 0;
                    break;
                }
            }
            if (cavegood == 1) {
                lc[newlcd] = s;
                newlcd++;
                findend(s, path, lc, newlcd, unique);
            }
        }
        if(end.size() > 0){
            System.out.println((pathcount + 1) + " - " + path + "end  " + unique);
            pathcount++;
        }
    }
}





