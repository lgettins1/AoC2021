import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Day3 {
    public static void main(String [] args)  {

        String thisLine;
        int[]diagReport = new int[12];
        for(int a = 0; a < 12; a ++){
            diagReport[a] = 0;
        }
        String[] fullReport = new String[1000];
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon =new StringBuilder();
        int gval;
        int eval;
        int reportCount = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/AoC21Day3input.txt"));
            while ((thisLine = br.readLine()) != null) {
                fullReport[reportCount] = thisLine;
                for(int a = 0; a < 12; a ++){
                    if(thisLine.charAt(a) == '1'){
                        diagReport[a] ++;
                    }
                }
                reportCount ++;
            }
            for(int a = 0; a < 12; a ++) {
                if (diagReport[a] > (reportCount / 2)) {
                    gamma.append("1");
                    epsilon.append("0");
                }else{
                    gamma.append("0");
                    epsilon.append("1");
                }
            }
            System.out.println(gamma + " " + epsilon);
            gval = Integer.parseInt(String.valueOf(gamma),2);
            eval = Integer.parseInt(String.valueOf(epsilon),2);
            System.out.println(gval + " x " + eval + " = " + (gval * eval));
            ArrayList<String> olist = new ArrayList<>();
            ArrayList<String> clist = new ArrayList<>();

            int pos = 0;
            for(int a = 0; a < reportCount; a ++){
                if(fullReport[a].charAt(pos) == String.valueOf(gamma).charAt(pos)){
                    olist.add(fullReport[a]);
                } else {
                    clist.add(fullReport[a]);
                }
            }
            char rv;
            while(olist.size() > 1) {
                pos ++;
                int onecount = 0;
                for (String s : olist) {
                    if (s.charAt(pos) == '1') onecount++;
                }
                if(2 * onecount >= (olist.size())){
                    rv = '1';
                } else {
                    rv = '0';
                }
                int cpos = 0;
                while(cpos < olist.size()){
                    if(olist.get(cpos).charAt(pos) == rv){
                        cpos ++;
                    }else {
                        olist.remove(cpos);
                    }
               }
            }
            pos = 0;
            while(clist.size() > 1) {
                pos ++;
                int zerocount = 0;
                for (String s : clist) {
                    if (s.charAt(pos) == '0') zerocount++;
                }
                if(2 * zerocount <= (clist.size())){
                    rv = '0';
                } else {
                    rv = '1';
                }
                int cpos = 0;
                while(cpos < clist.size()){
                    if(clist.get(cpos).charAt(pos) == rv){
                        cpos ++;
                    }else {
                        clist.remove(cpos);
                    }
                }
            }
            System.out.println(olist.get(0) + " " + clist.get(0));
            int oval = Integer.parseInt(olist.get(0),2);
            int cval = Integer.parseInt(clist.get(0),2);
            System.out.println(oval + " x " + cval + " = " + (oval * cval));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
