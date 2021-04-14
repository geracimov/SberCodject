package ru.geracimov.sbercodject.poker.analyzer.impl;

import ru.geracimov.sbercodject.poker.analyzer.AbstractCombinationAnalyzer;
import ru.geracimov.sbercodject.poker.card.Card;

import java.util.Collection;
import java.util.logging.Logger;

public final class FlushAnalyzer extends AbstractCombinationAnalyzer {
    private static final Logger LOGGER = Logger.getLogger(FlushAnalyzer.class.getName());
    public static final int RESULT_SUCCESS = 5;

    @Override
    public int analyze(Collection<Card> cards) {
        int result = RESULT_FAIL;
        for (int suitCounter : suitCounters(cards)) {
            if (suitCounter >= 5) {
                result = RESULT_SUCCESS;
                break;
            }
        }
        final int finalResult = result;
        LOGGER.info(() -> String.format(LOGGER_FORMAT_MESSAGE, cards, finalResult));
        return finalResult;
    }

}
