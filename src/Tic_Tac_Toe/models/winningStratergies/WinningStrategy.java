package Tic_Tac_Toe.models.winningStratergies;

import Tic_Tac_Toe.models.Board;
import Tic_Tac_Toe.models.Move;

public interface WinningStrategy {
    public boolean checkWinner(Board board, Move lastMove);
    public void updateCount(Board board, Move lastMove);

    public void handleUndo(Board board, Move lastMove);
}
