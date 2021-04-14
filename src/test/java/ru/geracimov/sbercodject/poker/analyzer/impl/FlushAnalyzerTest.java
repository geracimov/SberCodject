package ru.geracimov.sbercodject.poker.analyzer.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geracimov.sbercodject.poker.AbstractTest;
import ru.geracimov.sbercodject.poker.card.Card;
import ru.geracimov.sbercodject.poker.card.DeckType;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

class FlushAnalyzerTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        deck = deckFactory.createDeck(DeckType.DECK_SHORT);
        combinationAnalyzer = new FlushAnalyzer();
    }

    @Test
    void analyzeSomething() {
        Collection<Card> cards = deck.getCards(new String[]{"06h", "06s", "07s", "07d", "08s"});
        assertThat(combinationAnalyzer.analyze(cards)).isZero();
    }

    @Test
    void analyzeFlush06To10() {
        Collection<Card> cards = deck.getCards(new String[]{"10h", "06h", "09h", "07h", "08h"});
        assertThat(combinationAnalyzer.analyze(cards)).isEqualTo(FlushAnalyzer.RESULT_SUCCESS);
    }

}