package com.CarterMooring.tictactoeapp;
/**
 * File for Class Cell
 */

public class Cell {

    private Coordinates coordinates;
    private char symbol;

    /**
     * converts data of a Cell object to a string
     * @return
     */
    @Override
    public String toString(){
        String string = String.valueOf(symbol);
        return string;
    }

    /**
     * default constructor for Cell
     */
    public Cell() {
    }

    /**
     * @return symbol of a Cell type
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * sets symbol value to the value passed through as a parameter
     * @param symbol
     */
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }


}
