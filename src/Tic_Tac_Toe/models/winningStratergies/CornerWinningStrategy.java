package Tic_Tac_Toe.models.winningStratergies;

import Tic_Tac_Toe.enums.CellState;
import Tic_Tac_Toe.models.Board;
import Tic_Tac_Toe.models.Cell;
import Tic_Tac_Toe.models.Move;
import Tic_Tac_Toe.models.Player;

import java.util.List;

public class CornerWinningStrategy implements WinningStrategy {

    @Override
    public void updateCount(Board board, Move lastMove) {

    }

    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        int size = board.getSize();
        Player player = lastMove.getPlayer();
        char playerSymbol = player.getSymbol().getaChar();
        Cell cell = lastMove.getCell();
        int row = cell.getRow();
        int column = cell.getColumn();

        if (!(row == 0 && column == 0) &&
                !(row == size - 1 && column == 0) &&
                !(row == 0 && column == size - 1) &&
                !(row == size - 1 && column == size - 1)) {
            return false;
        }

        List<List<Cell>> actualBoard = board.getBoard();
        Cell topLeftCell = actualBoard.get(0).get(0);
        Cell topRightCell = actualBoard.get(0).get(size - 1);
        Cell bottomLeftCell = actualBoard.get(size - 1).get(0);
        Cell bottomRightCell = actualBoard.get(size - 1).get(size - 1);

        if (topLeftCell.getCellState() == CellState.EMPTY ||
                topRightCell.getCellState() == CellState.EMPTY ||
                bottomLeftCell.getCellState() == CellState.EMPTY ||
                bottomRightCell.getCellState() == CellState.EMPTY) {
            return false;
        }

        char symbolAtTopLeft = topLeftCell.getPlayer().getSymbol().getaChar();
        char symbolAtTopRight = topRightCell.getPlayer().getSymbol().getaChar();
        char symbolAtBottomLeft = bottomLeftCell.getPlayer().getSymbol().getaChar();
        char symbolAtBottomRight = bottomRightCell.getPlayer().getSymbol().getaChar();

        return playerSymbol == symbolAtTopLeft &&
                symbolAtTopLeft == symbolAtTopRight &&
                symbolAtTopRight == symbolAtBottomLeft &&
                symbolAtBottomLeft == symbolAtBottomRight;
    }

    @Override
    public void handleUndo(Board board, Move lastMove) {

    }
}