package ru.geracimov.sbercodject.poker.analyzer.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geracimov.sbercodject.poker.AbstractTest;
import ru.geracimov.sbercodject.poker.card.Card;
import ru.geracimov.sbercodject.poker.card.DeckType;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

class OnePairAnalyzerTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        deck = deckFactory.createDeck(DeckType.DECK_SHORT);
        combinationAnalyzer = new OnePairAnalyzer();
    }

    @Test
    void analyzeOn2QueenAndOthers() {
        Collection<Card> cards = deck.getCards(new String[]{"12h", "13s", "14c", "10d", "11c"});
        assertThat(combinationAnalyzer.analyze(cards)).isZero();
    }

    @Test
    void analyzeOnOthers() {
        Collection<Card> cards = deck.getCards(new String[]{"08h", "07s", "06c", "10d", "11c"});
        assertThat(combinationAnalyzer.analyze(cards)).isZero();
    }

    @Test
    void analyzeOnePairOnQueenAnd4Kings() {
        Collection<Card> cards = deck.getCards(new String[]{"12h", "12s", "12c", "12d", "11c"});
        assertThat(combinationAnalyzer.analyze(cards)).isEqualTo(OnePairAnalyzer.RESULT_SUCCESS);
    }

    @Test
    void analyzeOnePairOn2QueensAnd3Aces() {
        Collection<Card> cards = deck.getCards(new String[]{"12h", "12s", "14c", "14d", "14c"});
        assertThat(combinationAnalyzer.analyze(cards)).isEqualTo(OnePairAnalyzer.RESULT_SUCCESS);
    }

    @Test
    void analyzeOnePairOn6And7() {
        Collection<Card> cards = deck.getCards(new String[]{"06h", "06s", "08s", "09s", "07s"});
        assertThat(combinationAnalyzer.analyze(cards)).isEqualTo(OnePairAnalyzer.RESULT_SUCCESS);
    }

    @Test
    void analyzeOnePairOn3QueensAnd2Aces() {
        Collection<Card> cards = deck.getCards(new String[]{"14h", "12s", "14s", "14d", "12c"});
        assertThat(combinationAnalyzer.analyze(cards)).isEqualTo(OnePairAnalyzer.RESULT_SUCCESS);
    }

}