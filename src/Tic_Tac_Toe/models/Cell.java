package Tic_Tac_Toe.models;

import Tic_Tac_Toe.enums.CellState;

public class Cell {
    private int row;
    private int coloumn;
    private CellState cellState;
    private Player player;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColoumn() {
        return coloumn;
    }

    public void setColoumn(int coloumn) {
        this.coloumn = coloumn;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


}
