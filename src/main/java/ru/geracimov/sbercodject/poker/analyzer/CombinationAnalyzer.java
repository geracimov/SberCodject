package ru.geracimov.sbercodject.poker.analyzer;

import ru.geracimov.sbercodject.poker.card.Card;

import java.util.Collection;

/**
 * Анализатор учитываемых комбинаций
 */
@FunctionalInterface
public interface CombinationAnalyzer {

    int analyze(Collection<Card> cards);

}
