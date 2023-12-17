package Tic_Tac_Toe.controllers;

import Tic_Tac_Toe.models.Game;
import Tic_Tac_Toe.models.Player;
import Tic_Tac_Toe.models.exceptions.BotCountException;
import Tic_Tac_Toe.models.exceptions.DimensionException;
import Tic_Tac_Toe.models.exceptions.DuplicateSymbolException;
import Tic_Tac_Toe.models.exceptions.PlayerCountException;
import Tic_Tac_Toe.models.winningStratergies.WinningStrategy;

import java.util.List;

// Forwards request to respective model or service
public class GameController {
    // class without any attribute is called stateless class
    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) throws PlayerCountException, DuplicateSymbolException, BotCountException, DimensionException {
        return Game.getBuilder().
                setDimension(dimension).
                setPlayers(players).
                setWinningStrategies(winningStrategies).
                build();
    }

    public void displayBoard(Game game){
        game.getBoard().displayBoard();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public boolean checkForUndo(Game game){
        return  game.checkForUndo();
    }

//    public void checkWinner(Game game){
//
//    }
//
//    public void undo(Game game){
//
//    }


}
