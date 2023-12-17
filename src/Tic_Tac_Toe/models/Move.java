package Tic_Tac_Toe.models;

public class Move {
    private Cell cell;
    private Player player;

    public Move(Cell cell, Player player) {
//        this.cell = cell;
        setCell(cell);
//        this.player = player;
        setPlayer(player);
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


}
