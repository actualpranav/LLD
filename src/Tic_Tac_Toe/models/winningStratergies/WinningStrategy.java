package Tic_Tac_Toe.models.winningStratergies;

import Tic_Tac_Toe.models.Board;
import Tic_Tac_Toe.models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move lastMove);
    void updateCount(Board board, Move lastMove);

    void handleUndo(Board board, Move lastMove);
}
