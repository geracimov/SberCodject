package ru.geracimov.sbercodject.poker.analyzer.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geracimov.sbercodject.poker.AbstractTest;
import ru.geracimov.sbercodject.poker.card.Card;
import ru.geracimov.sbercodject.poker.card.DeckType;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

class TwoPairAnalyzerTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        deck = deckFactory.createDeck(DeckType.DECK_SHORT);
        combinationAnalyzer = new TwoPairAnalyzer();
    }

    @Test
    void analyzeTwoPairsOn6And7() {
        Collection<Card> cards = deck.getCards(new String[]{"06h", "06s", "07s", "07d", "08s"});
        assertThat(combinationAnalyzer.analyze(cards)).isEqualTo(TwoPairAnalyzer.RESULT_SUCCESS);
    }

    @Test
    void analyzeTwoPairsOnQueenAndAce() {
        Collection<Card> cards = deck.getCards(new String[]{"14h", "12s", "14s", "07d", "12c"});
        assertThat(combinationAnalyzer.analyze(cards)).isEqualTo(TwoPairAnalyzer.RESULT_SUCCESS);
    }

    @Test
    void analyzeOn4QueenAndKing() {
        Collection<Card> cards = deck.getCards(new String[]{"12h", "12s", "12c", "12d", "11c"});
        assertThat(combinationAnalyzer.analyze(cards)).isZero();
    }

    @Test
    void analyzeOn2QueenAndOthers() {
        Collection<Card> cards = deck.getCards(new String[]{"12h", "12s", "14c", "10d", "11c"});
        assertThat(combinationAnalyzer.analyze(cards)).isZero();
    }

    @Test
    void analyzeOn2QueenAnd3Ace() {
        Collection<Card> cards = deck.getCards(new String[]{"12h", "12s", "14c", "14d", "14c"});
        assertThat(combinationAnalyzer.analyze(cards)).isEqualTo(TwoPairAnalyzer.RESULT_SUCCESS);
    }

    @Test
    void analyzeOnOthers() {
        Collection<Card> cards = deck.getCards(new String[]{"08h", "07s", "06c", "10d", "11c"});
        assertThat(combinationAnalyzer.analyze(cards)).isZero();
    }

}