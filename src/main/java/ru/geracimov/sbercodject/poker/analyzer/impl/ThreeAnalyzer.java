package ru.geracimov.sbercodject.poker.analyzer.impl;

import ru.geracimov.sbercodject.poker.analyzer.AbstractCombinationAnalyzer;
import ru.geracimov.sbercodject.poker.card.Card;

import java.util.Collection;
import java.util.logging.Logger;

public final class ThreeAnalyzer extends AbstractCombinationAnalyzer {
    private static final Logger LOGGER = Logger.getLogger(ThreeAnalyzer.class.getName());
    public static final int RESULT_SUCCESS = 3;

    @Override
    public int analyze(Collection<Card> cards) {
        int threeCount = 0;
        for (int counter : rankCounters(cards)) {
            if (counter >= 3) threeCount++;
        }
        final int finalResult = threeCount >= 1
                ? RESULT_SUCCESS
                : RESULT_FAIL;
        LOGGER.info(() -> String.format(LOGGER_FORMAT_MESSAGE, cards, finalResult));
        return finalResult;
    }

}
