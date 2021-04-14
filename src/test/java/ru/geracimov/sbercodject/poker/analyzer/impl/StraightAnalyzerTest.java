package ru.geracimov.sbercodject.poker.analyzer.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geracimov.sbercodject.poker.AbstractTest;
import ru.geracimov.sbercodject.poker.card.Card;
import ru.geracimov.sbercodject.poker.card.DeckType;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

class StraightAnalyzerTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        deck = deckFactory.createDeck(DeckType.DECK_SHORT);
        combinationAnalyzer = new StraightAnalyzer();
    }

    @Test
    void analyzeOn4StraightCards() {
        Collection<Card> cards = deck.getCards(new String[]{"12h", "13s", "14c", "09d", "11c"});
        assertThat(combinationAnalyzer.analyze(cards)).isZero();
    }

    @Test
    void analyzeOnOthers() {
        Collection<Card> cards = deck.getCards(new String[]{"08h", "07s", "06c", "10d", "11c"});
        assertThat(combinationAnalyzer.analyze(cards)).isZero();
    }

    @Test
    void analyzeOnQueenAnd4Kings() {
        Collection<Card> cards = deck.getCards(new String[]{"12h", "12s", "12c", "12d", "11c"});
        assertThat(combinationAnalyzer.analyze(cards)).isZero();
    }

    @Test
    void analyzeStraightStartWith9() {
        Collection<Card> cards = deck.getCards(new String[]{"10h", "09s", "13c", "12d", "11c"});
        assertThat(combinationAnalyzer.analyze(cards)).isEqualTo(StraightAnalyzer.RESULT_SUCCESS);
    }

    @Test
    void analyzeStraightStartWith6() {
        Collection<Card> cards = deck.getCards(new String[]{"06s", "07s", "08s", "09s", "10s"});
        assertThat(combinationAnalyzer.analyze(cards)).isEqualTo(StraightAnalyzer.RESULT_SUCCESS);
    }

    @Test
    void analyzeStraightStartWith7() {
        Collection<Card> cards = deck.getCards(new String[]{"07h", "09s", "08c", "11d", "10c"});
        assertThat(combinationAnalyzer.analyze(cards)).isEqualTo(StraightAnalyzer.RESULT_SUCCESS);
    }

}