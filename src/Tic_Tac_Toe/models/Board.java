package Tic_Tac_Toe.models;

import Tic_Tac_Toe.enums.CellState;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> board;

    Board(int dimension){
        this.size = dimension;
        initialiseBoard();
    }

    public void initialiseBoard(){
        this.board = new ArrayList<>();
        for(int i = 0; i < size; i++){
            List<Cell> rowOfCells = new ArrayList<>();
            for(int j = 0; j < size; j++){
                rowOfCells.add(new Cell(i, j));
            }
            board.add(rowOfCells);
        }
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }



    public void displayBoard(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                Cell cell = board.get(i).get(j);
                if(cell.getCellState() == CellState.EMPTY){
                    System.out.print("   ");
                }else {
                    System.out.print(" " + cell.getPlayer().getSymbol().getaChar() + " ");
                }

                if(j < size - 1){
                    System.out.print("|");
                }
            }
            System.out.println();
            for(int j = 0; i < size - 1 && j < size; j++){
                System.out.print("----");
            }
            System.out.println();
        }
    }

}
