package ru.geracimov.sbercodject.poker.analyzer.impl;

import ru.geracimov.sbercodject.poker.analyzer.AbstractCombinationAnalyzer;
import ru.geracimov.sbercodject.poker.card.Card;

import java.util.Collection;
import java.util.logging.Logger;

public final class StraightFlushAnalyzer extends AbstractCombinationAnalyzer {
    private static final Logger LOGGER = Logger.getLogger(StraightFlushAnalyzer.class.getName());
    public static final int RESULT_SUCCESS = 8;

    @Override
    public int analyze(Collection<Card> cards) {
        int result = RESULT_FAIL;
        for (int[] rankCounters : allCounters(cards)) {
            int suitCounter = 0;
            int maxStraightCount = 0;
            for (int rankCounter : rankCounters) {
                if (rankCounter > 0) {
                    suitCounter++;
                } else {
                    maxStraightCount = Math.max(suitCounter, maxStraightCount);
                    suitCounter = 0;
                }
            }
            if (maxStraightCount >= 5) {
                result = RESULT_SUCCESS;
                break;
            }
        }
        final int finalResult = result;
        LOGGER.info(() -> String.format(LOGGER_FORMAT_MESSAGE, cards, finalResult));
        return finalResult;
    }

}
