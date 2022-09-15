import java.util.*;
public class MineSweeper {
    private int[][] visible = new int[10][10];
    private int[][] hidden = new int[10][10];

    public void startGame(){
        System.out.println("\n\n================Welcome to Minesweeper ! ================\n");
        setupField(1);
        boolean flag = true;

        while(flag){
            displayVisible();
            flag = playMove();
            if (checkWin()){
                displayHidden();
                System.out.println("\n================You WON!!!================");
                break;
            }
        }
    }

    public void setUpField(int diff){
        int var = 0;
        while (var != 10){
            Random rand = new Random();
            int i = rand.nextInt(10);
            int j = rand.nextInt(10);
            hidden[i][j] = 100;
            var ++;
        }
        buildHidden();
    }
    
    public static void main(String[] args){
        MineSweeper M = new MineSweeper();
        M.startGame();
    }
}
