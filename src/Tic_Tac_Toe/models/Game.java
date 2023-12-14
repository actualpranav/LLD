package Tic_Tac_Toe.models;

import Tic_Tac_Toe.enums.GameState;
import Tic_Tac_Toe.models.winningStratergies.WinningStratergy;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private GameState gameState;
    private Player winner;
    private List<Move> moves;
    private int currentPlayerIndex;
    private List<WinningStratergy> winningStatergies;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public List<WinningStratergy> getWinningStatergies() {
        return winningStatergies;
    }

    public void setWinningStatergies(List<WinningStratergy> winningStatergies) {
        this.winningStatergies = winningStatergies;
    }




}
