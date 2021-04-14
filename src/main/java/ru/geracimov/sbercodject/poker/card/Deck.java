package ru.geracimov.sbercodject.poker.card;

import java.util.Collection;

/**
 * Колода
 */
public interface Deck {

    Card getCard(String cardString);

    Collection<Card> getCards(String[] cardStrings);

    String toString();

}
