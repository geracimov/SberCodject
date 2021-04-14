package ru.geracimov.sbercodject.poker.analyzer;

import ru.geracimov.sbercodject.poker.card.Card;
import ru.geracimov.sbercodject.poker.card.Rank;
import ru.geracimov.sbercodject.poker.card.Suit;

import java.util.Collection;

public abstract class AbstractCombinationAnalyzer implements CombinationAnalyzer {
    protected static final int RESULT_FAIL = 0;
    protected static final String LOGGER_FORMAT_MESSAGE = "Analyzed %s with result: %s";

    protected int[] suitCounters(Collection<Card> cards) {
        int[] counters = new int[Suit.values().length];
        for (
                Card card : cards) {
            counters[card.getSuit().ordinal()]++;
        }
        return counters;
    }

    protected int[] rankCounters(Collection<Card> cards) {
        int[] counters = new int[Rank.values().length];
        for (Card card : cards) {
            counters[card.getRank().ordinal()]++;
        }
        return counters;
    }

    protected int[][] allCounters(Collection<Card> cards) {
        int[][] counters = new int[Suit.values().length][Rank.values().length];
        for (Card card : cards) {
            counters[card.getSuit().ordinal()][card.getRank().ordinal()]++;
        }
        return counters;
    }

}
