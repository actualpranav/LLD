package Tic_Tac_Toe.factories;

import Tic_Tac_Toe.enums.BotDifficultyLevel;
import Tic_Tac_Toe.models.Bot;
import Tic_Tac_Toe.models.BotPlayingStrategy.BotPlayingStrategy;
import Tic_Tac_Toe.models.BotPlayingStrategy.EasyBotPlayingStrategy;
import Tic_Tac_Toe.models.BotPlayingStrategy.HardBotPlayingStrategy;
import Tic_Tac_Toe.models.BotPlayingStrategy.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyFactory(Bot bot){
        BotDifficultyLevel difficultyLevel = bot.getDifficultyLevel();
        if(difficultyLevel == BotDifficultyLevel.EASY){
            return new EasyBotPlayingStrategy(bot);
        }
        else if(difficultyLevel == BotDifficultyLevel.MEDIUM){
            return new MediumBotPlayingStrategy(bot);
        }
        else if(difficultyLevel == BotDifficultyLevel.HARD){
            return new HardBotPlayingStrategy(bot);
        }
        return null;

    }
}
