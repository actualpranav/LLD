package Tic_Tac_Toe.models.winningStratergies;

import Tic_Tac_Toe.models.Board;
import Tic_Tac_Toe.models.Cell;
import Tic_Tac_Toe.models.Move;
import Tic_Tac_Toe.models.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RowWinningStratergy extends MapWinningStrategies{


    public RowWinningStratergy(int dimension, List<Player> playerList) {
        super(dimension, playerList);
    }

    @Override
    public void updateCount(Board board, Move lastMove){
        Cell cell = lastMove.getCell();
        Player player = lastMove.getPlayer();
        int row = cell.getRow();
        updateCountMap(row, player);
    }
    @Override
    public boolean checkWinner(Board board, Move lastMove){
        Cell cell = lastMove.getCell();
        Player player = lastMove.getPlayer();
        int row = cell.getRow();

        return checkCountMapForWinner(row, player, board.getSize());
    }

    @Override
    public void handleUndo(Board board, Move lastMove) {
        Player player = lastMove.getPlayer();
        Cell cell = lastMove.getCell();
        int row = cell.getRow();

        handleMapUndo(row, player);

    }
}
