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
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws BotCountException, DimensionException, PlayerCountException, DuplicateSymbolException {
        int dimension = 0;
        GameController gameController = new GameController();
        List<Player> players = new ArrayList<>();
//        userInput(players, dimension);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of tic tac toe board between (3 - 27): ");
        dimension = sc.nextInt();
        if(dimension > 27){
            System.out.println("board size greater than 27, game over");
            return;
        }

        players = userInput(players, dimension);


        List<WinningStratergy> winningStratergies = new ArrayList<>();

        winningStratergies.add(new RowWinningStratergy(dimension, players));
        winningStratergies.add(new ColumnWinningStrategy(dimension, players));
        winningStratergies.add(new DiagonalWinningStrategy(players));
        winningStratergies.add(new CornerWinningStrategy());

        Game game = gameController.startGame(dimension, players, winningStratergies);
        System.out.println("game started");

        while(game.getGameState() == GameState.IN_PROGRESS){
            gameController.makeMove(game);
            gameController.displayBoard(game);
            boolean undoDone = gameController.checkForUndo(game);
            if(undoDone) gameController.displayBoard(game);
        }
        gameController.displayBoard(game);

        if(game.getGameState() == GameState.COMPLETED){
            System.out.println("Game is completed. Winner is " + game.getWinner().getName());
        }
        if(game.getGameState() == GameState.DRAW){
            System.out.println("Game is a Draw");
        }
    }

    public static List<Player> userInput(List<Player> players, int dimension){
        Scanner sc = new Scanner(System.in);
        System.out.println("This game needs " + (dimension - 1) + " players");
        System.out.println("How many bots would you like : ");
        int numberOfBots = sc.nextInt();
        if(numberOfBots > dimension - 1){
            System.out.println("resetting bot count to " + (dimension -1));
            numberOfBots = dimension - 1;
            System.out.println("Press 1 if you wish to coninue");
            int continueInput = sc.nextInt();
            if(continueInput != 1) return null;
        }
        int realPlayers = dimension - numberOfBots;
        char startingSymbol = 'A';
        for(int i = 0; i < numberOfBots && i < dimension - 1; i++){
            String botNameGenerator = "Bot" + i;
            char BotSymbolGenerator = startingSymbol;
            startingSymbol++;
            players.add(new Bot(i + 1, botNameGenerator, new Symbol(BotSymbolGenerator), BotDifficultyLevel.MEDIUM));
        }
        for(int i = 0; i < realPlayers && i < dimension - 1 - numberOfBots; i++){
            System.out.println("Enter player" + (i +1) + "'s Name");
            String realPlayerName = sc.next();
            char realPlayerCharacter = startingSymbol;
            startingSymbol++;
            players.add(new Player(i + numberOfBots + 1, realPlayerName, new Symbol(realPlayerCharacter)));
        }
        return players;
    }
}
