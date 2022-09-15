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

    public void buildHidden()
    {
        for(int i=0; i<10; i++)
        {
            for(int j=0; j<10; j++)
            {
                int cnt=0;
                if(hidden[i][j]!=100)
                {

                    if(i!=0)
                    {
                        if(hidden[i-1][j]==100) cnt++;
                        if(j!=0)
                        {
                            if(hidden[i-1][j-1]==100) cnt++;
                        }

                    }
                    if(i!=9)
                    {
                        if(hidden[i+1][j]==100) cnt++;
                        if(j!=9)
                        {
                            if(hidden[i+1][j+1]==100) cnt++;
                        }
                    }
                    if(j!=0)
                    {
                        if(hidden[i][j-1]==100) cnt++;
                        if(i!=9)
                        {
                            if(hidden[i+1][j-1]==100) cnt++;
                        }
                    }
                    if(j!=9)
                    {
                        if(hidden[i][j+1]==100) cnt++;
                        if(i!=0)
                        {
                            if(hidden[i-1][j+1]==100) cnt++;
                        }
                    }

                    hidden[i][j] = cnt;
                }
            }
        }

    }
    public static void main(String[] args){
        MineSweeper M = new MineSweeper();
        M.startGame();
    }
}
