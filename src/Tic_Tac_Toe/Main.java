package Tic_Tac_Toe;

import Tic_Tac_Toe.controllers.GameController;
import Tic_Tac_Toe.enums.GameState;
import Tic_Tac_Toe.models.Game;
import Tic_Tac_Toe.models.Player;
import Tic_Tac_Toe.models.Symbol;
import Tic_Tac_Toe.models.winningStratergies.ColoumnWinningStratergy;
import Tic_Tac_Toe.models.winningStratergies.RowWinningStratergy;
import Tic_Tac_Toe.models.winningStratergies.WinningStratergy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int dimension = 3;

        GameController gameController = new GameController();
        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "Pranav", new Symbol('x')));
        players.add(new Player(2, "yoko", new Symbol('O')));

        List<WinningStratergy> winningStratergies = new ArrayList<>();

        winningStratergies.add(new RowWinningStratergy());
        winningStratergies.add(new ColoumnWinningStratergy());

        Game game = Game.getBuilder().setDimension(3).setPlayers(players).setWinningStrategies(winningStratergies).build();
//        Game game = gameController.startGame(3, players, winningStratergies);


        while(game.getGameState() == GameState.IN_PROGRESS){
            gameController.displayBoard(game);
            gameController.makeMove(game);

            if(game.getGameState() == GameState.COMPLETED){
                System.out.println("Game is completed. Winner is " + game.getWinner().getName());
                break;
            }
            if(game.getGameState() == GameState.DRAW){
                System.out.println("Game is a Draw");
                break;
            }

        }


    }
}
