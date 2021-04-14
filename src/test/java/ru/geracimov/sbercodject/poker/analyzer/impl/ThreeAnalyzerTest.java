package ru.geracimov.sbercodject.poker.analyzer.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geracimov.sbercodject.poker.AbstractTest;
import ru.geracimov.sbercodject.poker.card.Card;
import ru.geracimov.sbercodject.poker.card.DeckType;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

class ThreeAnalyzerTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        deck = deckFactory.createDeck(DeckType.DECK_SHORT);
        combinationAnalyzer = new ThreeAnalyzer();
    }


    @Test
    void analyzeOnOthers() {
        Collection<Card> cards = deck.getCards(new String[]{"08h", "07s", "06c", "10d", "11c"});
        assertThat(combinationAnalyzer.analyze(cards)).isZero();
    }

    @Test
    void analyzeOnStraightFlash() {
        Collection<Card> cards = deck.getCards(new String[]{"14c", "13c", "12c", "11c", "10c"});
        assertThat(combinationAnalyzer.analyze(cards)).isZero();
    }

    @Test
    void analyzeStraightStartWith9() {
        Collection<Card> cards = deck.getCards(new String[]{"10h", "09s", "13c", "12d", "11c"});
        assertThat(combinationAnalyzer.analyze(cards)).isZero();
    }

    @Test
    void analyzeLowThree() {
        Collection<Card> cards = deck.getCards(new String[]{"06s", "07s", "06h", "09s", "06d"});
        assertThat(combinationAnalyzer.analyze(cards)).isEqualTo(ThreeAnalyzer.RESULT_SUCCESS);
    }

    @Test
    void analyzeHighThree() {
        Collection<Card> cards = deck.getCards(new String[]{"14h", "12s", "14c", "14d", "11c"});
        assertThat(combinationAnalyzer.analyze(cards)).isEqualTo(ThreeAnalyzer.RESULT_SUCCESS);
    }

}