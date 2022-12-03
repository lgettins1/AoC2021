import java.io.BufferedReader;
import java.io.FileReader;

public class Day14b {
    public static int[] letters = new int[26];
    public static void main(String[] args) {
    String thisLine;
    String[][] rules = new String[100][2];

    try {
        BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/AoC21Day14inputb.txt"));
        String template = br.readLine();
        String a = br.readLine();
        int rulecount = 0;
        while((thisLine = br.readLine()) != null) {
            String[] b = thisLine.split(" ");
            rules[rulecount][0] = b[0];
            rules[rulecount][1] = b[2];
            rulecount ++;
        }
        String t = template.trim();


        for(int ql = 0; ql < 26; ql ++){
            letters[ql] = 0;
        }
        int curdepth = 0;
        for(int b = 0; b < t.length() - 1; b ++){
            System.out.println(t.substring(b, b + 2));
            extrapolate(40, curdepth, t.substring(b, b + 2), rules, rulecount);
        }

        letters[(int) template.charAt(t.length() - 1) - 65] ++;


        long min = 999999999;
        int minindex = 0;
        long max = 0;
        int maxindex = 0;
        for(int ql = 0; ql < 15; ql ++){
            System.out.print(letters[ql] + " ");
            if (letters[ql] < min & letters[ql] > 0){
                min = letters[ql];
                minindex = ql;

            }
            if (letters[ql] > max){
                max = letters[ql];
                maxindex = ql;
            }
        }
        System.out.println();
        System.out.println("Max char is " + Character.toString((char) maxindex + 65) + " count " + max);
        System.out.println("Min char is " + Character.toString((char) minindex + 65) + " count " + min);
        System.out.println("Answer is " + max + " - " + min + " = " + (max - min));


    } catch (Exception e) {
        e.printStackTrace();
    }
}

    private static void extrapolate(int targetdepth, int curdepth, String template, String[][]rules, int rulecount) {
    if(curdepth < targetdepth){
        for(int r = 0 ; r < rulecount; r ++){
            if(template.trim().equals(rules[r][0].trim())){
                String s1 = template.substring(0, 1) + rules[r][1];
                String s2 = rules[r][1] + template.substring(1, 2);
                extrapolate(targetdepth, curdepth + 1,  s1, rules, rulecount);
                extrapolate(targetdepth, curdepth + 1,  s2, rules, rulecount);
                break;
            }
        }

    } else {
            letters[(int)template.charAt(0) - 65] ++;
    }

    }
}
