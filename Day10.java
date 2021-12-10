import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Day10 {
    public static void main(String[] args) {
        String thisLine;
        int[] ec = new int[1000];
        int score = 0;
        double newscore;
        ArrayList<Double> linescores = new ArrayList<>() ;
        int lines = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/AoC21Day10input.txt"));
            while((thisLine = br.readLine()) != null){
               int depth = 0;
               int broken = 0;
               newscore = 0;
               for(int a = 0; a < thisLine.length(); a ++){
                   if(broken == 0){
                   switch(thisLine.charAt(a)) {
                       case '<':
                           ec[depth] = 62;
                           depth ++;
                           break;
                       case '(':
                           ec[depth] = 41;
                           depth ++;
                           break;
                       case '{':
                           ec[depth] = 125;
                           depth ++;
                           break;
                       case '[':
                           ec[depth] = 93;
                           depth ++;
                           break;
                       default:
                           if ((int) thisLine.charAt(a) == ec[depth - 1]) {
                               depth --;
                           } else {
                               broken = 1;
                               switch (thisLine.charAt(a)) {
                                   case '>' -> score += 25137;
                                   case ')' -> score += 3;
                                   case '}' -> score += 1197;
                                   case ']' -> score += 57;
                               }
                           }
                       }
                   }
               }
               if(broken == 0){
                   for( int c = depth - 1; c >= 0; c --){
                       newscore = newscore * 5;
                       switch (ec[c]) {
                           case 62 -> newscore += 4;
                           case 41 -> newscore += 1;
                           case 125 -> newscore += 3;
                           case 93 -> newscore += 2;
                       }
                   }
                   linescores.add(newscore);
                   lines ++;
               }
            }
            Collections.sort(linescores);
            Double v = linescores.get((lines - 1) / 2);
            System.out.println("Part 1 -> " + score);
            System.out.println("Part 2 -> " + String.format("%.0f",v));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
