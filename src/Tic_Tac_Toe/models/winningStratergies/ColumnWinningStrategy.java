package Tic_Tac_Toe.models.winningStratergies;

import Tic_Tac_Toe.models.Board;
import Tic_Tac_Toe.models.Cell;
import Tic_Tac_Toe.models.Move;
import Tic_Tac_Toe.models.Player;

import java.util.List;

public class ColumnWinningStrategy extends MapWinningStrategies{


    public ColumnWinningStrategy(int dimension, List<Player> playerList) {
        super(dimension, playerList);
    }

    @Override
    public void updateCount(Board board, Move lastMove){
        Cell cell = lastMove.getCell();
        Player player = lastMove.getPlayer();
        int column = cell.getColumn();
        updateCountMap(column, player);
    }

    @Override
    public void handleUndo(Board board, Move lastMove) {
        Player player = lastMove.getPlayer();
        Cell cell = lastMove.getCell();
        int column = cell.getColumn();

        handleMapUndo(column, player);

    }

    @Override
    public boolean checkWinner(Board board, Move lastMove){
        Cell cell = lastMove.getCell();
        Player player = lastMove.getPlayer();
        int column = cell.getColumn();

        return checkCountMapForWinner(column, player, board.getSize());
    }
}
