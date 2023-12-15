package Tic_Tac_Toe.models;

import Tic_Tac_Toe.enums.GameState;
import Tic_Tac_Toe.models.winningStratergies.WinningStratergy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;

//    private int dimension;

    private List<Player> players;
    private GameState gameState;
    private Player winner;
    private List<Move> moves;
    private int currentPlayerIndex;
    private List<WinningStratergy> winningStrategies;

    private Game(Builder builder){
        this.players = builder.players;
        this.winningStrategies = builder.winningStrategies;
        this.board = new Board(builder.dimension);

        this.gameState = GameState.IN_PROGRESS;
        this.winner = null;
        this.moves = new ArrayList<>();
        this.currentPlayerIndex = 0;
    }

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

    public List<WinningStratergy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStratergy> winningStrategies) {
        this.winningStrategies = winningStrategies;
//        return this;
    }

    public static Builder getBuilder(){
        return new Builder();
    }
    public static class Builder{
        private int dimension;
        private List<Player> players;
        private List<WinningStratergy> winningStrategies;

        public Builder setDimension(int dimension){
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players){
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStratergy> winningStrategies){
            this.winningStrategies = winningStrategies;
            return this;
        }

        private void validate(){
            //

        }
        public Game build(){
            //validations
            validate();
            return new Game(this);

        }
    }
}
