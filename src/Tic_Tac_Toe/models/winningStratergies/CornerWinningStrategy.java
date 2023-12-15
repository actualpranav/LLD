package Tic_Tac_Toe.models.winningStratergies;

import Tic_Tac_Toe.models.Board;
import Tic_Tac_Toe.models.Move;

public class CornerWinningStrategy implements WinningStratergy{
    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        return false;
    }

    @Override
    public void updateCount(Board board, Move lastMove) {

    }
}
