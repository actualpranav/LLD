package Tic_Tac_Toe;

import Tic_Tac_Toe.controllers.GameController;
import Tic_Tac_Toe.enums.BotDifficultyLevel;
import Tic_Tac_Toe.enums.GameState;
import Tic_Tac_Toe.models.Bot;
import Tic_Tac_Toe.models.Game;
import Tic_Tac_Toe.models.Player;
import Tic_Tac_Toe.models.Symbol;
import Tic_Tac_Toe.models.exceptions.BotCountException;
import Tic_Tac_Toe.models.exceptions.DimensionException;
import Tic_Tac_Toe.models.exceptions.DuplicateSymbolException;
import Tic_Tac_Toe.models.exceptions.PlayerCountException;
import Tic_Tac_Toe.models.winningStratergies.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws BotCountException, DimensionException, PlayerCountException, DuplicateSymbolException {
        int dimension = 3;

        GameController gameController = new GameController();
        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "Pranav", new Symbol('X')));
//        players.add(new Player(2, "yoko", new Symbol('O')));
        players.add(new Bot(2, "Bot", new Symbol('O'), BotDifficultyLevel.HARD));

        List<WinningStratergy> winningStratergies = new ArrayList<>();

        winningStratergies.add(new RowWinningStratergy(dimension, players));
        winningStratergies.add(new ColumnWinningStrategy(dimension, players));
        winningStratergies.add(new DiagonalWinningStrategy(players));
        winningStratergies.add(new CornerWinningStrategy());

        Game game = gameController.
                startGame(dimension, players, winningStratergies);
//        Game game = gameController.startGame(3, players, winningStratergies);
        System.out.println("game started");

        while(game.getGameState() == GameState.IN_PROGRESS){
            gameController.displayBoard(game);
            gameController.makeMove(game);
        }
        gameController.displayBoard(game);

        if(game.getGameState() == GameState.COMPLETED){
            System.out.println("Game is completed. Winner is " + game.getWinner().getName());
        }
        if(game.getGameState() == GameState.DRAW){
            System.out.println("Game is a Draw");
        }
    }
}
