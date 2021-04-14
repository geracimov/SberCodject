package ru.geracimov.sbercodject.poker.analyzer.impl;

import ru.geracimov.sbercodject.poker.analyzer.AbstractCombinationAnalyzer;
import ru.geracimov.sbercodject.poker.card.Card;

import java.util.Collection;
import java.util.logging.Logger;

public final class FullHouseAnalyzer extends AbstractCombinationAnalyzer {
    private static final Logger LOGGER = Logger.getLogger(FullHouseAnalyzer.class.getName());
    public static final int RESULT_SUCCESS = 6;

    @Override
    public int analyze(Collection<Card> cards) {
        int pairCounter = 0;
        int threeCounter = 0;
        for (int rankCounter : rankCounters(cards)) {
            if (rankCounter >= 3) {
                threeCounter++;
            } else if (rankCounter >= 2) {
                pairCounter++;
            }
        }

        final int finalResult = pairCounter > 0 && threeCounter > 0
                ? RESULT_SUCCESS
                : RESULT_FAIL;
        LOGGER.info(() -> String.format(LOGGER_FORMAT_MESSAGE, cards, finalResult));
        return finalResult;
    }

}
