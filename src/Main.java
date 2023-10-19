import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int boardRow = 0, boardCol = 0;
        System.out.println("Oyun satır sayısını giriniz.");
        boardRow = sc.nextInt();
        System.out.println("Oyun sütun sayısını giriniz.");
        boardCol = sc.nextInt();
        MineSweeper mine = new MineSweeper(boardRow,boardCol);
        mine.Run();

    }
}