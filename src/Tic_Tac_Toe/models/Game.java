package Tic_Tac_Toe.models;

import Tic_Tac_Toe.enums.CellState;
import Tic_Tac_Toe.enums.GameState;
import Tic_Tac_Toe.enums.PlayerType;
import Tic_Tac_Toe.models.exceptions.BotCountException;
import Tic_Tac_Toe.models.exceptions.DimensionException;
import Tic_Tac_Toe.models.exceptions.DuplicateSymbolException;
import Tic_Tac_Toe.models.exceptions.PlayerCountException;
import Tic_Tac_Toe.models.winningStratergies.WinningStratergy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

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

    public void makeMove(){
        int currentPlayerIndex = this.getCurrentPlayerIndex();
        Player currentPlayer = this.getPlayers().get(currentPlayerIndex);


        // Update list of moves
        Move move = currentPlayer.makeMove(this.getBoard());
        this.moves.add(move);

        //update the hashmap for the board
        for(WinningStratergy winningStratergy : this.winningStrategies){
            winningStratergy.updateCount(this.getBoard(), move);

        }

        // check for winner
        for(WinningStratergy winningStratergy : this.winningStrategies){
            if(winningStratergy.checkWinner(board,move)){
                this.setWinner(currentPlayer);
                this.setGameState(GameState.COMPLETED);
                return;
            }
        }
        if(this.moves.size() == board.getSize() * board.getSize()){
            this.setGameState(GameState.DRAW);
            return;
        }


        int nextPlayerIndex = currentPlayerIndex + 1;
        nextPlayerIndex %= this.getBoard().getSize() - 1;
        // this.getPlayers().size()
        this.setCurrentPlayerIndex(nextPlayerIndex);
    }

    public boolean checkForUndo(){
        // if last move performed by bot
        int moveSize = this.moves.size();
        Move lastMove = this.moves.get(moveSize - 1);

        if(lastMove.getPlayer().getPlayerType() == PlayerType.BOT){
            return false;
        }
        System.out.println("Do you want to Undo");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        if(input.equals("Y")){
            performUndo();
            return true;
        }
        return false;


    }

    public void performUndo(){
        // Update moves list
        int moveSize = this.moves.size();
        Move lastMove = this.moves.get(moveSize - 1);
        this.moves.remove(moveSize - 1);

        // Reset player index
        int currentIndex = this.currentPlayerIndex;
        int nextIndex = currentIndex - 1;
        if(nextIndex < 0) nextIndex = players.size() - 1;
        this.setCurrentPlayerIndex(nextIndex);

        // Reset cell

        lastMove.getCell().setPlayer(null);
        lastMove.getCell().setCellState(CellState.EMPTY);

        // Decrease countMap
        for(WinningStratergy winningStratergy : getWinningStrategies()){
            winningStratergy.handleUndo(board, lastMove);
        }
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

        private void validateBotCount() throws BotCountException{
            // only 1 bot
            int botCount = 0;
            for(Player p: players){
                if(p.getPlayerType() == PlayerType.BOT){
                    botCount++;
                }
            }
            if(botCount > 1){
                throw new BotCountException("Bot count is more than 1, Invalid game");
            }
        }

        private void  validateBoardSize() throws DimensionException{
            // size of board is at least 3
            if(dimension < 3){
                throw new DimensionException("Invalid board, Board size should be atleast 3");
            }
        }

        private void validatePlayerCount() throws PlayerCountException{
            // no. of players is n - 1
            if(players.size() != dimension-1){
                throw new PlayerCountException("Invalid player count, should be 1 less than the dimension");
            }
        }

        private void validateDuplicateSymbols() throws DuplicateSymbolException{
            // no duplicate symbols
            HashSet<Character> symbols = new HashSet<>();
            for(Player p : players){
                if(symbols.contains(p.getSymbol().getaChar())){
                    throw new DuplicateSymbolException("Invalid symbol, Duplicate Symbol");
                }
                symbols.add(p.getSymbol().getaChar());
            }
        }
        private void validate() throws BotCountException, DimensionException, PlayerCountException, DuplicateSymbolException{
            validateBotCount();
            validateBoardSize();
            validatePlayerCount();
            validateDuplicateSymbols();
        }
        public Game build() throws BotCountException, DimensionException, PlayerCountException, DuplicateSymbolException{
            //validations
            validate();
            return new Game(this);

        }
    }
}
