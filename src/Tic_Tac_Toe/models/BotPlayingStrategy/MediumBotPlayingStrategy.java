package Tic_Tac_Toe.models.BotPlayingStrategy;

import Tic_Tac_Toe.enums.CellState;
import Tic_Tac_Toe.models.Board;
import Tic_Tac_Toe.models.Bot;
import Tic_Tac_Toe.models.Cell;
import Tic_Tac_Toe.models.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MediumBotPlayingStrategy implements BotPlayingStrategy{
    Bot bot;
    public MediumBotPlayingStrategy(Bot bot){
        this.bot = bot;
    }
    @Override
    public Move makeBotMove(Board board) {
        System.out.println(bot.getName() + "'s move \n");
        List<Cell> emptyCellList = getEmptyCells(board);

        Random random = new Random();
        int randomIndex = random.nextInt(emptyCellList.size());
        Cell randomChosenCell = emptyCellList.get(randomIndex);

        randomChosenCell.setPlayer(bot);
        randomChosenCell.setCellState(CellState.OCCUPIED);
        return new Move(randomChosenCell, bot);
    }

    private List<Cell> getEmptyCells(Board board){
        int sizeOfBoard = board.getSize();
        List<Cell> emptyCells = new ArrayList<>();
        for(int i = 0; i < sizeOfBoard; i++){
            for(int j = 0; j < sizeOfBoard; j++){
                Cell currentCell = board.getBoard().get(i).get(j);
                if(currentCell.getCellState() == CellState.EMPTY){
                    emptyCells.add(currentCell);
                }
            }
        }
        return emptyCells;
    }
}
