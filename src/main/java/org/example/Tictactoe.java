package org.example;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
class Player extends Board{
    static String name;
    static char key;
    static PrintStream l=new PrintStream((new FileOutputStream(FileDescriptor.out)));
    static int count=0;
    Player() {

    }
    static void placeKey(int row, int col){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                if(i==row && j==col) {
                    board[i][j] = key;
                    count++;
                    displayBoard();
                }
            }
        }
    }
    static void displayBoard(){
        String bar="_|___|___|___|_";
        String bar1=" | ";
        String msg=" Won the match!";
        for (int i = 0; i < 3; i++) {
            l.println(bar);
            l.print(bar1);
            for (int j = 0; j < 3; j++) {
                l.print(board[i][j] +" | ");
            }
            l.println();
        }
        l.println(bar);
        for(int i=0;i<3;i++) {
            if (board[i][0]!=' ' && board[i][0] == board[i][1] &&  board[i][0]== board[i][2]) {
                l.println(name + msg);
                System.exit(0);
            }
            if (board[0][i]!=' ' && board[0][i] == board[1][i] &&  board[0][i]== board[2][i]) {
                l.println(name + msg);
                System.exit(0);
            }
        }
        if(board[0][0]!=' ' && board[0][0] == board[1][1] &&  board[0][0]== board[2][2]) {
            l.println(name + msg);
            System.exit(0);
        }
        if(board[0][2]!=' ' && board[0][2] == board[1][1] &&  board[0][2]== board[2][0]) {
            l.println(name + msg);
            System.exit(0);
        }
        if(count==9){
            l.println("Draw the match!");
            System.exit(0);
        }
    }
}
class Board {
    static Scanner s = new Scanner(System.in);
    static PrintStream l = new PrintStream((new FileOutputStream(FileDescriptor.out)));
    static char[][] board = new char[3][3];

    Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }
    void position(String name,char key){
        Player.name =name;
        Player.key =key;
        int row;
        int col;
        do {
            l.println("Enter the row:");
            row = s.nextInt();
            l.println("Enter the column:");
            col = s.nextInt();
        }while(board[row][col]!=' ');
            Player.placeKey(row, col);

        }
    }

public class Tictactoe{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        Scanner s1=new Scanner(System.in);
        PrintStream l=new PrintStream((new FileOutputStream(FileDescriptor.out)));
        Board b=new Board();
        l.println("Enter the player1 name:");
        String name1=s.nextLine();
        l.println("Enter the player1 key:");
        char key1=s1.next().charAt(0);
        l.println("Enter the player2 name:");
        String name2=s.nextLine();
        l.println("Enter the player2 key:");
        char key2=s1.next().charAt(0);
        l.println("1.Player1\n2.Player2");
        l.println("Enter the choice that which player you want to play first:");
        int ch= s1.nextInt();
        int count1=0;
        if(ch==1) {
            while(count1<9) {
                    b.position(name1,key1);
                    b.position(name2,key2);
                count1++;
            }
        }
        else {
            while(count1<9) {
                b.position(name2,key2);
                b.position(name1,key1);
                count1=count1+2;
            }
        }
    }
}