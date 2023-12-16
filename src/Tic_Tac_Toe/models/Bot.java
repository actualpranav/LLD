package Tic_Tac_Toe.models;

import Tic_Tac_Toe.enums.BotDifficultyLevel;
import Tic_Tac_Toe.enums.PlayerType;
import Tic_Tac_Toe.factories.BotPlayingStrategyFactory;
import Tic_Tac_Toe.models.BotPlayingStrategy.BotPlayingStrategy;

public class Bot extends Player{
    public Bot(int id, String name, Symbol symbol, BotDifficultyLevel difficultyLevel) {
        super(id, name, symbol);
        this.difficultyLevel = difficultyLevel;
    }

    private BotDifficultyLevel difficultyLevel;

    public BotDifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(BotDifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public Bot(int id, String name, Symbol symbol) {
        super(id, name, symbol);
        this.setPlayerType(PlayerType.BOT);
    }

    @Override
    public Move makeMove(Board board){
        BotPlayingStrategy playingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyFactory(this);
        return playingStrategy.makeBotMove(board);
    }
}
