package Tic_Tac_Toe.controllers;

import Tic_Tac_Toe.models.Game;
import Tic_Tac_Toe.models.Player;
import Tic_Tac_Toe.models.winningStratergies.WinningStratergy;

import java.util.List;

public class GameController {
    // class without any atribute is called stateless class
    public Game startGame(int dimension, List<Player> players, List<WinningStratergy> winningStratergies) {
    return null;
    }

    public void displayBoard(Game game){
        game.getBoard().displayBoard();
    }

    public void makeMove(Game game){

    }

    public void checkWinner(Game game){

    }

    public void undo(Game game){

    }


}
