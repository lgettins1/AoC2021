import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Day4b {
    public static void main(String [] args)  {

        String thisLine;
        String[] pull;
        String[][][] boards = new String[101][5][5];


        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/AoC21Day4input.txt"));
            thisLine = br.readLine();
            pull = thisLine.split(",");

            int curboard = 0;
            while (br.readLine() != null) {
                for(int a = 0; a < 5; a ++){
                    thisLine = br.readLine();
                    for(int b = 0; b < 5; b++) {
                        boards[curboard][a][b] = thisLine.substring(3 * b, 3 * b + 2);
                    }
                }
                curboard ++;
            }
            int bingo = 0;
            int pullno = 0;
            int winpull = 0;
            int wincard = 0;
            ArrayList<Integer> goodcards = new ArrayList<>();

            while(bingo < 100){
                for(int card = 0; card < curboard; card ++){
                    for( int a = 0; a < 5; a ++){
                        for(int b = 0; b < 5; b ++){
                            if(boards[card][a][b].trim().equals(pull[pullno].trim())){
                                boards[card][a][b] = "  ";
                            }
                        }
                    }
                }
                int horcount;
                int vercount;

                for(int card = 0; card < curboard; card ++) {
                    int newwin = 1;
                    for (Integer goodcard : goodcards) {
                        if (card == goodcard) {
                            newwin = 0;
                            break;
                        }
                    }
                    if(newwin == 1){
                        for (int a = 0; a < 5; a++) {
                            horcount = 0;
                            vercount = 0;
                                for(int b = 0; b < 5; b ++){
                                if(boards[card][a][b].trim().equals("")){
                                    horcount ++;
                                }
                                if(boards[card][b][a].trim().equals("")){
                                    vercount ++;
                                }
                            }
                            if(horcount == 5 || vercount == 5) newwin = 2;
                        }
                        if(newwin == 2){
                            bingo ++;
                            wincard = card;
                            winpull = pullno;
                            goodcards.add(card);
                        }
                    }
                }
                pullno ++;
            }
            for (int a = 0; a < 5; a++) {
                for (int b = 0; b < 5; b++) {
                    System.out.print(boards[wincard][a][b] + "|");
                }
                System.out.println();
            }
            int pullval = Integer.parseInt(pull[winpull]);
            System.out.println("Winning number is " + pullval + " on card " + wincard);
            int cardsum = 0;
            for (int a = 0; a < 5; a++) {
                for (int b = 0; b < 5; b++) {
                    if(boards[wincard][a][b].trim().length() > 0){
                        cardsum += Integer.parseInt(boards[wincard][a][b].trim());
                    }
                }
            }
            System.out.println(cardsum + " x " + pullval + " = " + (cardsum * pullval));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
