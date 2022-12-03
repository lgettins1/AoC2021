import java.io.BufferedReader;
import java.io.FileReader;

public class Day14 {
    public static void main(String[] args) {
        String thisLine;
        String[][] rules = new String[100][2];

        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/AoC21Day14input.txt"));
            String template = br.readLine();
            String a = br.readLine();
            int rulecount = 0;
            while((thisLine = br.readLine()) != null) {
                String[] b = thisLine.split(" ");
                rules[rulecount][0] = b[0];
                rules[rulecount][1] = b[2];
                rulecount ++;
            }

            StringBuilder newt = new StringBuilder();
            String t = template.trim();
            for(int step = 0; step < 10; step ++) {
                for (int c = 0; c < t.length() - 1; c++) {
                    String sub = t.substring(c, c + 2);
                    for (int d = 0; d < rulecount; d++) {
                        if (sub.equals(rules[d][0])) {
                            newt.append(sub.charAt(0)).append(rules[d][1]);
                            break;
                        }
                    }
                }
                newt.append(t.substring(t.length() - 1));
                t = newt.toString();
                newt = new StringBuilder();

            }
            int[] letters = new int[26];
            for(int ql = 0; ql < 26; ql ++){
                letters[ql] = 0;
            }

            for(int q = 0; q < t.length(); q ++){
                letters[(int)t.charAt(q) - 65] ++;
            }
            int min = t.length();
            int minindex = 0;
            int max = 0;
            int maxindex = 0;
            for(int ql = 0; ql < 26; ql ++){
                if (letters[ql] < min && letters[ql] > 0){
                    min = letters[ql];
                    minindex = ql;
                }
                if (letters[ql] > max){
                    max = letters[ql];
                    maxindex = ql;
                }
            }
            System.out.println("Max char is " + Character.toString((char) maxindex + 65) + " count " + max);
            System.out.println("Min char is " + Character.toString((char) minindex + 65) + " count " + min);
            System.out.println("Answer is " + max + " - " + min + " = " + (max - min));





        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
