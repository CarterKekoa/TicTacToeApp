package com.CarterMooring.tictactoeapp;

/**
 * File for class Coordinates
 */

public class Coordinates {

    private int row;
    private int column;

    /**
     * converts data of a Coordinates object to a string
     * @return
     */
    @Override
    public String toString(){
        return "Coordinates (" + row + ", " + column + ")";
    }

    /**
     * default constructor for Coordinates
     */
    public Coordinates() {
    }

    public Coordinates(int row, int column){
        row = this.row;
        column = this.column;
    }




    /**
     * @return row of a Coordinates object
     */
    public int getRow() {
        return row;
    }

    /**
     * @return column of a Coordinates object
     */
    public int getColumn() {
        return column;
    }

    /**
     * sets row value to the value passed through as a parameter
     * @param row
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * sets column value to the value passed through as a parameter
     * @param column
     */
    public void setColumn(int column) {
        this.column = column;
    }

}
