import java.io.BufferedReader;
import java.io.FileReader;

public class Day8b {
    public static void main(String [] args)  {
        String thisLine;
        int TotalPoints = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/AoC21Day8input.txt"));
            while ((thisLine = br.readLine()) != null) {
                int [] order = new int [10];
                String[] line = thisLine.split("\\|");
                String[] c1 = line[0].trim().split(" ");
                String[] c2 = line[1].trim().split(" ");
                for(int a = 0; a < 10; a ++){
                    if(c1[a].trim().length() == 2) order[1] = a;
                    if(c1[a].trim().length() == 3) order[7] = a;
                    if(c1[a].trim().length() == 4) order[4] = a;
                    if(c1[a].trim().length() == 7) order[8] = a;
                }
                for(int a = 0; a < 10; a ++){
                    if(c1[a].trim().length() == 6){
                        String one = c1[order[1]].trim();
                        String four = c1[order[4]].trim();
                        if(isAinB(four, c1[a])){
                            order[9] = a;
                        } else {
                            if(isAinB(one, c1[a])){
                                order[0] = a;
                            } else {
                                order[6] = a;
                            }
                        }
                    }
                }
                for(int a = 0; a < 10; a ++) {
                    if (c1[a].trim().length() == 5) {
                        String one = c1[order[1]].trim();
                        String six = c1[order[6]].trim();
                        if(isAinB(one, c1[a])){
                            order[3] = a;
                        } else {
                            if(isAinB(c1[a], six)){
                                order[5] = a;
                            } else {
                                order[2] = a;
                            }
                        }
                    }
                }
                StringBuilder val = new StringBuilder();
                for(int b = 0; b < 4; b++){
                    for (int a = 0; a < 10; a ++){
                        if(c2[b].trim().length() == c1[order[a]].trim().length()) {
                            if (isAinB(c2[b], c1[order[a]])) val.append(String.valueOf(a).trim());
                        }
                    }
                }
                TotalPoints += Integer.parseInt(val.toString());
             }
            System.out.println("Total Points = " + TotalPoints);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static boolean isAinB (String stringA, String stringB){
        int foundA = 0;
        boolean found;
        for(int b = 0; b < stringA.trim().length(); b ++){
            if(stringB.contains(stringA.substring(b, b + 1))) foundA ++;
        }
        found = (foundA == stringA.trim().length());
            return found;
    }
}
