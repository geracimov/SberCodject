package ru.geracimov.sbercodject.poker.analyzer.impl;

import ru.geracimov.sbercodject.poker.analyzer.AbstractCombinationAnalyzer;
import ru.geracimov.sbercodject.poker.card.Card;

import java.util.Collection;
import java.util.logging.Logger;

public final class StraightAnalyzer extends AbstractCombinationAnalyzer {
    private static final Logger LOGGER = Logger.getLogger(StraightAnalyzer.class.getName());
    public static final int RESULT_SUCCESS = 4;

    @Override
    public int analyze(Collection<Card> cards) {
        int straightCount = 0;
        int maxStraightCount = 0;
        for (int counter : rankCounters(cards)) {
            if (counter > 0) {
                straightCount++;
            } else {
                maxStraightCount = Math.max(straightCount, maxStraightCount);
                straightCount = 0;
            }
        }
        final int finalResult = maxStraightCount >= 5
                ? RESULT_SUCCESS
                : RESULT_FAIL;
        LOGGER.info(() -> String.format(LOGGER_FORMAT_MESSAGE, cards, finalResult));
        return finalResult;
    }

}
