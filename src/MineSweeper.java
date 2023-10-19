import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int rowNummber;
    int colNumber;
    String[][] mineSweeper;
    String[][] mineSweeperUser;


    public MineSweeper(int rowNummber, int colNumber){
        this.rowNummber = rowNummber;
        this.colNumber = colNumber;
        this.mineSweeper = new String[rowNummber][colNumber];
        this.mineSweeperUser = new String[rowNummber][colNumber];
    }

    public void Run() {
        System.out.println("===== MAYIN TARLASI - ARKAPLAN =====");
        CreateArrSweeper();
        MineSweeperUser();
        PrintArr(mineSweeper);
        System.out.println("===== MAYIN TARLASINA HOŞ GELDİNİZ =====");
        PrintArr(mineSweeperUser);

        boolean isGameOver = false;
        while (!isGameOver){
            System.out.println("==========");
            Scanner sc = new Scanner(System.in);
            int row, col;
            System.out.print("Satır giriniz : ");
            row = sc.nextInt()-1;
            System.out.print("Sütun giriniz : ");
            col = sc.nextInt()-1;

            if(this.mineSweeper[row][col] != "*"){
                Count(this.mineSweeper, row, col);
                PrintArr(this.mineSweeperUser);
            }else {
                System.out.println("Mayına bastın! Oyunu kaybettiniz. ");
                isGameOver = true;
            }

        }

    }


    public void Count(String[][] arr, int row, int col){
        int counter = 0;

        int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

        for (int i = 0; i < 8; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if (newRow >= 0 && newRow < arr.length && newCol >= 0 && newCol < arr[0].length) {
                if (arr[newRow][newCol].equals("*")) {
                    counter++;
                }
            }
        }
        this.mineSweeperUser[row][col] = String.valueOf(counter);

    }
    public void CreateArrSweeper(){
        Random rd = new Random();
        int sweeper = ((this.rowNummber*this.colNumber)/4);
        int counter = 0;
        int k , l;
        for (int i = 0; i < this.rowNummber; i++) {
            for (int j = 0; j < this.colNumber; j++) {
                this.mineSweeper[i][j] = "-";
            }
        }
        while (counter < sweeper){
            k = rd.nextInt(this.rowNummber-1);
            l = rd.nextInt(this.colNumber-1);
            if(mineSweeper[k][l] != "*"){
                this.mineSweeper[k][l] = "*";
                counter++;
            }
        }
    }
    public void MineSweeperUser() {
        for (int i = 0; i < this.rowNummber; i++) {
            for (int j = 0; j < this.colNumber; j++) {
                this.mineSweeperUser[i][j] = "-";
            }
        }
    }
    public void PrintArr(String[][] arr){
        for (int i = 0; i < arr.length;i++){
            for(int j = 0; j < arr[0].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
