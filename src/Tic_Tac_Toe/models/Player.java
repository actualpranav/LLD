package Tic_Tac_Toe.models;

import Tic_Tac_Toe.enums.CellState;
import Tic_Tac_Toe.enums.PlayerType;

import java.util.Scanner;

public class Player {
    private int id;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;

    public Player(int id, String name, Symbol symbol) {
//        this.id = id;
        setId(id);
//        this.name = name;
        setName(name);
//        this.symbol = symbol;
        setSymbol(symbol);
//        this.playerType = PlayerType.HUMAN;
        setPlayerType(PlayerType.HUMAN);
    }

//    public int getId() {
//        return id;
//    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(Board board){
        Cell chosenCell = getValidChosenCell(board);
        // update list of moves in game
        // check for the winner
        chosenCell.setPlayer(this);
        chosenCell.setCellState(CellState.OCCUPIED);

        Move move = new Move(chosenCell, this);
        // added arguments for bot "?"
        move.setPlayer(this);
        move.setCell(chosenCell);
        return move;

    }

    public Cell getValidChosenCell(Board board){
        while (true) {
            System.out.println("Player " + this.getName() + ", make your move");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Row Between (1 - "+board.getSize()+")");
            int row = sc.nextInt();
            row--;

            System.out.println("Enter Column Between(1 - "+board.getSize()+")");
            int column = sc.nextInt();
            column--;
            // move validator
            if (!isValidInput(row, column, board.getSize())) continue;

            Cell chosenCell = board.getBoard().get(row).get(column);
            if (isValidCellChosen(chosenCell)) return chosenCell;
        }
    }

    private boolean isValidInput(int row, int column, int size){
        if(row >= 0 && row < size && column >= 0 && column <size){
            return true;
        }
        System.out.println("\nPlease provide value within the range! try again... \n");
        return false;
    }
    private boolean isValidCellChosen(Cell chosenCell){
        if(chosenCell.getCellState()  != CellState.EMPTY){
            System.out.println("\n Cell already Occupied! try again...\n");
            return false;
        }
        return true;
    }
}
