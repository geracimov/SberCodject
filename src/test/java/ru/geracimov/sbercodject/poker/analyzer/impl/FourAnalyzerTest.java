package ru.geracimov.sbercodject.poker.analyzer.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geracimov.sbercodject.poker.AbstractTest;
import ru.geracimov.sbercodject.poker.card.Card;
import ru.geracimov.sbercodject.poker.card.DeckType;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

class FourAnalyzerTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        deck = deckFactory.createDeck(DeckType.DECK_SHORT);
        combinationAnalyzer = new FourAnalyzer();
    }

    @Test
    void analyzeFourOn06() {
        Collection<Card> cards = deck.getCards(new String[]{"06h", "06s", "07s", "06d", "06c"});
        assertThat(combinationAnalyzer.analyze(cards)).isEqualTo(FourAnalyzer.RESULT_SUCCESS);
    }

    @Test
    void analyzeSomething() {
        Collection<Card> cards = deck.getCards(new String[]{"10c", "06h", "06s", "06c", "10c"});
        assertThat(combinationAnalyzer.analyze(cards)).isZero();
    }

}