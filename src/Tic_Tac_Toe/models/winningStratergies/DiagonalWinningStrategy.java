package Tic_Tac_Toe.models.winningStratergies;

import Tic_Tac_Toe.models.Board;
import Tic_Tac_Toe.models.Cell;
import Tic_Tac_Toe.models.Move;
import Tic_Tac_Toe.models.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStratergy{
    private int dimension;
    private Map<Integer, Map<Player, Integer>> countMap;

    public DiagonalWinningStrategy(List<Player> playerList){
        this.dimension = 2;
        this.countMap = new HashMap<>();
        initialiseCountMap(playerList);
    }

    private void initialiseCountMap(List<Player> playerList){
        for(int i = 0; i < dimension; i++){
            countMap.put(i, new HashMap<>());
            for (Player p: playerList){
                // we store reference of player
                countMap.get(i).put(p, 0);
            }
        }

    }

    @Override
    public void updateCount(Board board, Move lastMove){
        Cell cell = lastMove.getCell();
        Player player = lastMove.getPlayer();
        int row = cell.getRow();
        int column = cell.getColumn();

        // left diagonal is type0
        if(row == column) {
            int existingCount = countMap.get(0).get(player);
            int newCount = existingCount + 1;
            countMap.get(0).put(player, newCount);
        }
        // left diagonal is type1
        if(row + column == board.getSize() - 1) {
            int existingCount = countMap.get(1).get(player);
            int newCount = existingCount + 1;
            countMap.get(1).put(player, newCount);
        }
    }
    @Override
    public boolean checkWinner(Board board, Move lastMove){
        Cell cell = lastMove.getCell();
        Player player = lastMove.getPlayer();
        int row = cell.getRow();
        int column = cell.getColumn();

        boolean leftDiagonalAnswer = false;
        if(row == column){
            if(countMap.get(0).get(player) == board.getSize()){
                leftDiagonalAnswer = true;
            }
        }

        boolean rightDiagolanAnswer = false;
        if(row + column == board.getSize()){
            if(countMap.get(1).get(player) == board.getSize()){
                rightDiagolanAnswer = true;
            }
//            rightDiagolanAnswer = true;
        }

        if(leftDiagonalAnswer || rightDiagolanAnswer) return  true;
        return false;
    }
}
