package ru.geracimov.sbercodject.poker.analyzer.impl;

import ru.geracimov.sbercodject.poker.analyzer.AbstractCombinationAnalyzer;
import ru.geracimov.sbercodject.poker.card.Card;

import java.util.Collection;
import java.util.logging.Logger;

public final class TwoPairAnalyzer extends AbstractCombinationAnalyzer {
    private static final Logger LOGGER = Logger.getLogger(TwoPairAnalyzer.class.getName());
    public static final int RESULT_SUCCESS = 2;

    @Override
    public int analyze(Collection<Card> cards) {
        int pairCount = 0;
        for (int counter : rankCounters(cards)) {
            if (counter >= 2) pairCount++;
        }
        final int finalResult = pairCount >= 2
                ? RESULT_SUCCESS
                : RESULT_FAIL;
        LOGGER.info(() -> String.format(LOGGER_FORMAT_MESSAGE, cards, finalResult));
        return finalResult;
    }

}
