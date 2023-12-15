package Tic_Tac_Toe.models;

import Tic_Tac_Toe.enums.BotDifficultyLevel;
import Tic_Tac_Toe.enums.PlayerType;

public class Bot extends Player{
    private BotDifficultyLevel difficultyLevel;

    public Bot(int id, String name, Symbol symbol) {
        super(id, name, symbol);
        this.setPlayerType(PlayerType.BOT);
    }
}
