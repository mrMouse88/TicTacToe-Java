package com.company;

import java.util.Scanner;

public class Main {
    //declare board
    static String[][] board = new String[3][3];
    //who is moving
    static boolean isCross = true;
    //count moves to 9
    static int counter = 1;

    public static void main(String[] args) {

        //Create and clear board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = " ";
            }
        }

        while(counter <=9) {
            System.out.println(counter);
            if(isCross){
                System.out.println("Gra krzyżyk");
            }else{
                System.out.println("Gra kółko");
            }
            makeMove();
            System.out.println();
            printBoard();
            if(checkScore()){
                System.out.println("\n\n\n");
                break;
            }
            counter++;
            System.out.println("\n\n\n");
        }
        System.out.println("Koniec");
        if(counter >= 9){
            System.out.println("Partia nierozstrzygnięta");
        }else if (isCross){
            System.out.println("Wygrywa kółko");
        }else{
            System.out.println("Wygrywa krzyżyk");
        }



    }

    //check score
    static boolean checkScore(){
        boolean status = false;

        for (int i = 0; i < 3; i++) {
            if(board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]) && !board[i][0].equals(" ")){
                status = true;
                break;
            }
        }

        for (int i = 0; i < 3; i++) {
            if(board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]) && !board[0][i].equals(" ")){
                status = true;
                break;
            }
        }

//        if(board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && !board[0][0].equals(" ")){
//            status = true;
//        }else if(board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && !board[0][2].equals(" ")){
//            status = true;
//        }
        int h = 0;
        for (int i = 0; i < 2; i++) {


                if(board[i][i].equals(board[i+1][i+1]) && !board[i][i].equals(" ")){
                    h++;
                }

            if (h==2){
                status = true;
                break;
            }
        }
        h = 0;
        for (int i = 0; i < 2; i++) {
        	for (int j = 2; j > 0; j--)

                if(board[i][j].equals(board[i+1][j-1]) && !board[i][j].equals(" ")){
                    h++;
                   
                }

            if (h==2){
                status = true;
                break;
            }
        }

        return status;
    }

    //check if space is empty and who is playing
    static void makeMove(){
        boolean status = false;
        int[] move = new int[2];

        do{
            System.out.println("Podaj poziom");
            move[0] = getInput();
            System.out.println("Podaj pion");
            move[1] = getInput();
            if(board[move[0]][move[1]].equals(" ")){
                if(isCross){
                    board[move[0]][move[1]] = "X";
                    status = true;
                    isCross = false;
                }else{
                    board[move[0]][move[1]] = "O";
                    status = true;
                    isCross = true;
                }
            }else{
                System.out.println("Pole zajęte! jeszcze raz!");
            }


        }while(!status);

    }

    //get singel value from user and check it
    static int getInput(){
        Scanner input = new Scanner(System.in);
        boolean status = false;
        int move;

        do{
            System.out.println("wprowadź wartość od 0 do 2 ");
            move = input.nextInt();
            if(move >= 0 && move < 3){
                status = true;
            }
        }while (!status);
        input.nextLine();
        return move;
    }

    //print board on screen
    static void printBoard(){
        System.out.println("  | 0 | 1 | 2 |");
        for (int i = 0; i < 3; i++) {
            System.out.print(i);
            System.out.print(" | ");

            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                System.out.print(" | ");
            }
            System.out.println();

        }
    }
}