package Tic_Tac_Toe.models.winningStratergies;

import Tic_Tac_Toe.models.Board;
import Tic_Tac_Toe.models.Move;
import Tic_Tac_Toe.models.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class MapWinningStrategies implements WinningStratergy{

    private int dimension;
    private Map<Integer, Map<Player, Integer>> countMap;

    public MapWinningStrategies(int dimension, List<Player> playerList){
        this.dimension = dimension;
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

    public void updateCountMap(int key, Player player){
        int existingCount = countMap.get(key).get(player);
        int newCount = existingCount + 1;
        countMap.get(key).put(player, newCount);
    }

    public boolean checkCountMapForWinner(int key, Player player, int boardSize){
        if(countMap.get(key).get(player) == boardSize) return  true;
        return false;
    }

    public void handleMapUndo(int key, Player player){
        int existingCount = countMap.get(key).get(player);
        int newCount = existingCount - 1;
        countMap.get(key).put(player, newCount);
    }

    // no need to override interface methods, abstract class implementing a interface.
//    @Override
//    public boolean checkWinner(Board board, Move lastMove) {
//        return false;
//    }
//
//    @Override
//    public void updateCount(Board board, Move lastMove) {
//
//    }
}
