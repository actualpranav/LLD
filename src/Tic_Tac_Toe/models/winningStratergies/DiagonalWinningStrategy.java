package Tic_Tac_Toe.models.winningStratergies;

import Tic_Tac_Toe.models.Board;
import Tic_Tac_Toe.models.Cell;
import Tic_Tac_Toe.models.Move;
import Tic_Tac_Toe.models.Player;

import java.util.List;

public class DiagonalWinningStrategy extends MapWinningStrategies{


    public DiagonalWinningStrategy(List<Player> playerList) {
        super(2, playerList);
    }

    @Override
    public void updateCount(Board board, Move lastMove){
        Cell cell = lastMove.getCell();
        Player player = lastMove.getPlayer();
        int row = cell.getRow();
        int column = cell.getColumn();

        // left diagonal is type0
        if(row == column) {
            updateCountMap(0, player);
        }
        // left diagonal is type1
        if(row + column == board.getSize() - 1) {
            updateCountMap(1, player);
        }
    }
    @Override
    public boolean checkWinner(Board board, Move lastMove){
        Cell cell = lastMove.getCell();
        Player player = lastMove.getPlayer();
        int row = cell.getRow();
        int column = cell.getColumn();

        if(row == column){
            if (checkCountMapForWinner(0, player, board.getSize())) {
                return true;
            }
        }

        if(row + column == board.getSize() - 1){
            return checkCountMapForWinner(1, player, board.getSize());
        }

        return false;
    }

    @Override
    public void handleUndo(Board board, Move lastMove) {
        Player player = lastMove.getPlayer();
        Cell cell = lastMove.getCell();
        int row = cell.getRow();
        int column = cell.getColumn();

        if(row == column){
            handleMapUndo(0, player);
        }
        if(row + column == board.getSize() - 1){
            handleMapUndo(1, player);
        }

    }


}
