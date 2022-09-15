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

    public void displayVisible()
    {
        System.out.print("\t ");
        for(int i=0; i<10; i++)
        {
            System.out.print(" " + i + "  ");
        }
        System.out.print("\n");
        for(int i=0; i<10; i++)
        {
            System.out.print(i + "\t| ");
            for(int j=0; j<10; j++)
            {
                if(visible[i][j]==0)
                {
                    System.out.print("?");
                }
                else if(visible[i][j]==50)
                {
                    System.out.print(" ");
                }
                else
                {
                    System.out.print(visible[i][j]);
                }
                System.out.print(" | ");
            }
            System.out.print("\n");
        }
    }

    public boolean playMove(){
        Scanner scnr = new Scanner(System.in);
        System.out.print("\nEnter Row Number: ");
        int i = scnr.nextInt();
        System.out.print("Enter Column Number: ");
        int j = scnr.nextInt();

        if (i < 0 || i > 9 || j < 0 || j > 9){
            System.out.print("\nIncorrect Input!!");
            return true;
        }

        if (hidden[i][j] == 100){
            displayHidden();
            System.out.print("Oops! You stepped on a mine!\n============GAME OVER============");
            return false;
        }

        else if (hidden[i][j] == 0){
            fixVisible(i, j);
        }

        else{
            fixNeighbors(i, j);
        }

        return true;
    }
    public static void main(String[] args){
        MineSweeper M = new MineSweeper();
        M.startGame();
    }
}
