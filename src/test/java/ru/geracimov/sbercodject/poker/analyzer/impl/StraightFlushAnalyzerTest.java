package ru.geracimov.sbercodject.poker.analyzer.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geracimov.sbercodject.poker.AbstractTest;
import ru.geracimov.sbercodject.poker.card.Card;
import ru.geracimov.sbercodject.poker.card.DeckType;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

class StraightFlushAnalyzerTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        deck = deckFactory.createDeck(DeckType.DECK_SHORT);
        combinationAnalyzer = new StraightFlushAnalyzer();
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
        assertThat(combinationAnalyzer.analyze(cards)).isZero();
    }

    @Test
    void analyzeLowStraight() {
        Collection<Card> cards = deck.getCards(new String[]{"06s", "07s", "08s", "09s", "10s"});
        assertThat(combinationAnalyzer.analyze(cards)).isEqualTo(StraightFlushAnalyzer.RESULT_SUCCESS);
    }

    @Test
    void analyzeHighStraight() {
        Collection<Card> cards = deck.getCards(new String[]{"14c", "13c", "12c", "11c", "10c"});
        assertThat(combinationAnalyzer.analyze(cards)).isEqualTo(StraightFlushAnalyzer.RESULT_SUCCESS);
    }

}