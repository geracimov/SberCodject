package ru.geracimov.sbercodject.poker.analyzer.impl;

import ru.geracimov.sbercodject.poker.analyzer.AbstractCombinationAnalyzer;
import ru.geracimov.sbercodject.poker.card.Card;

import java.util.Collection;
import java.util.logging.Logger;

public final class FourAnalyzer extends AbstractCombinationAnalyzer {
    private static final Logger LOGGER = Logger.getLogger(FourAnalyzer.class.getName());
    public static final int RESULT_SUCCESS = 7;

    @Override
    public int analyze(Collection<Card> cards) {
        int fourCount = 0;
        for (int counter : rankCounters(cards)) {
            if (counter >= 4) fourCount++;
        }
        final int finalResult = fourCount >= 1
                ? RESULT_SUCCESS
                : RESULT_FAIL;
        LOGGER.info(() -> String.format(LOGGER_FORMAT_MESSAGE, cards, finalResult));
        return finalResult;
    }

}
