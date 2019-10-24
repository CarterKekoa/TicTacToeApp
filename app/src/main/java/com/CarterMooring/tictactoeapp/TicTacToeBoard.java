package com.CarterMooring.tictactoeapp;
/**
 * File for class TicTacToeBoard
 */

public class TicTacToeBoard{

    private int N;
    private Cell[][] grid;

    public TicTacToeBoard(){
        N = 3;
    }

    /**
     * Constructor that creates a TicTacTioBoard object with the parameters n and Cell[][] grid
     * @param n
     * @param grid
     */
    public TicTacToeBoard(int n, Cell[][] grid) {
        N = n;
        this.grid = grid;
    }

    /**
     * @return converts data of a TicTacToeBoard object to a string
     */
    @Override
    public String toString(){
        String holder = "  ";

        for(int k = 0; k < N; k++){
            holder += k + " ";
        }

        holder += "\n";

        for(int i = 0; i < N; i++)
        {
            holder += i + " ";
            for(int j = 0; j < N; j++)
            {
                holder += grid[i][j] + " ";
            }
            holder += "\n";
        }

        return holder;
    }

    /**
     * checks to see if the cell chosen already has been used for this game
     * @param coordinates
     * @return true if the cell is not already taken, false if otherwise
     */
    public boolean isValidMove(Coordinates coordinates){

        if (grid[coordinates.getRow()][coordinates.getColumn()].getSymbol() == '-')
            return true;
        else {
            System.out.println("Not a valid move, try again");
            return false;
        }

    }

    /**
     * if isValidMove is true, sets the value of the cell chosen with the coordinates to the value of playerSymbol
     * @param coordinates
     * @param playerSymbol
     */
    public void makeMove(Coordinates coordinates, char playerSymbol){

        if (isValidMove(coordinates)) {
            grid[coordinates.getRow()][coordinates.getColumn()].setSymbol(playerSymbol);
        }

    }

    /**
     * runs through the grid to check in either player has won
     * @param playerSymbol
     * @return true if there are N in a row of the same playerSymbol, false otherwise
     */
    public boolean isWinner(char playerSymbol){

        int count = 0;

        for (int i = 0; i < N; i++){

            for (int j = 0; j < N; j++){
                if (grid[i][j].getSymbol() == playerSymbol){
                    count++;
                    if (count == N) {
                        System.out.println("Character " + playerSymbol + " wins");
                        return true;
                    }
                }
            }

            count = 0;

            for(int k = 0; k < N; k++){
                if(grid[k][i].getSymbol() == playerSymbol){
                    count++;
                    if (count == N) {
                        System.out.println("Character " + playerSymbol + " wins");
                        return true;
                    }
                }
            }

            count = 0;

            for(int l = 0; l < N; l++){
                if(grid[l][l].getSymbol() == playerSymbol){
                    count++;
                    if (count == N) {
                        System.out.println("Character " + playerSymbol + " wins");
                        return true;
                    }
                }
            }

            count = 0;
            int num =  N - 1;

            for(int p = 0; p < N; p++){
                if(grid[p][num].getSymbol() == playerSymbol) {
                    count++;
                    if (count ==  N) {
                        System.out.println("Character " + playerSymbol + " wins");
                        return true;
                    }
                }
                num--;
            }
            count = 0;
        }

    return false;

    }

    /**
     * checks to see if the game was a scratch
     * @return true if all the spaces in the grid are filled
     */
    public boolean gameOver(){
        int count = 0;
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                if (grid[i][j].getSymbol() == '-')
                    count++;
            }
        }

        if (count != 0)
            return false;
        else {
            System.out.println("Scratch game, too bad");
            return true;
        }
    }
}
