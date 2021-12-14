import java.io.BufferedReader;
import java.io.FileReader;

public class Day13 {
    public static void main(String[] args) {
    String thisLine;
    int section = 1;
    int[][] points = new int [850][2];
    int[][] folds = new int [15][2];
    int row = 0;
    int foldcount = 0;

    try {
        BufferedReader br = new BufferedReader(new FileReader("c:/users/lance/documents/AoC21Day13input.txt"));
        while((thisLine = br.readLine()) != null) {
            if(thisLine.length() == 0){
                section = 2;
            } else {
                if (section == 1) {
                    String[] a = thisLine.split(",");
                    points[row][0] = Integer.parseInt(a[0]);
                    points[row][1] = Integer.parseInt(a[1]);
                    row++;
                } else {
                    String[] b = thisLine.split(" ");
                    String[] c = b[2].split("=");
                    int axis = 1;
                    if(c[0].charAt(0) == 120) axis = 0;
                    int dist = Integer.parseInt(c[1]);
                    folds[foldcount][0] = axis;
                    folds[foldcount][1] = dist;
                    foldcount ++;
                }
            }
        }

        int ys = (2 * folds[1 - folds[0][0]][1]) + 1;
        int xs = (2 * folds[folds[0][0]][1]) + 1;

        char[][] grid = new char[xs][ys];
        for(int y = 0; y < ys; y ++){
            for(int x = 0; x < xs; x ++){
                grid[x][y] = '.';
            }
        }
        for(int rp = 0; rp < row; rp ++){
            grid[points[rp][0]][points[rp][1]] = '#';
        }

        printgraph(xs, ys, grid);

        for(int next = 0; next < foldcount; next ++) {
            for (int y = folds[next][0] * folds[next][1]; y < ys; y++) {
                for (int x = (1 - folds[next][0]) * folds[next][1]; x < xs; x++) {
                    if (grid[x][y] == '#') {
                        grid[folds[next][0] * x + (1 - folds[next][0]) * (xs - x - 1)][folds[next][0] * (ys - y - 1) + (1 - folds[next][0]) * y] = '#';
                    }
                }
            }
            ys = folds[next][0] * folds[next][1] + (1 - folds[next][0]) * ys;
            xs = folds[next][0] * xs + (1 - folds[next][0]) * folds[next][1];

            printgraph(xs, ys, grid);
        }
        int dotcount = 0;
        for(int y = 0; y < ys; y ++){
            for(int x = 0; x < xs; x ++){
                if(grid[x][y] == '#') dotcount ++;
            }
        }
        System.out.println("There are " + dotcount + " visible dots.");


    } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void printgraph(int xs, int ys, char[][] grid){
        for(int y = 0; y < ys; y ++){
            for(int x = 0; x < xs; x ++){
                System.out.print(grid[x][y]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

    }
}
