package ru.geracimov.sbercodject.poker.analyzer.impl;

import ru.geracimov.sbercodject.poker.analyzer.AbstractCombinationAnalyzer;
import ru.geracimov.sbercodject.poker.card.Card;

import java.util.Collection;
import java.util.logging.Logger;

public final class OnePairAnalyzer extends AbstractCombinationAnalyzer {
    private static final Logger LOGGER = Logger.getLogger(OnePairAnalyzer.class.getName());
    public static final int RESULT_SUCCESS = 1;

    @Override
    public int analyze(Collection<Card> cards) {
        int pairCount = 0;
        for (int rankCounter : rankCounters(cards)) {
            if (rankCounter >= 2) pairCount++;
        }
        final int finalResult = pairCount >= 1
                ? RESULT_SUCCESS
                : RESULT_FAIL;
        LOGGER.info(() -> String.format(LOGGER_FORMAT_MESSAGE, cards, finalResult));
        return finalResult;
    }

}
