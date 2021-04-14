package ru.geracimov.sbercodject.poker.analyzer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geracimov.sbercodject.poker.AbstractTest;
import ru.geracimov.sbercodject.poker.analyzer.impl.FlushAnalyzer;
import ru.geracimov.sbercodject.poker.analyzer.impl.FullHouseAnalyzer;
import ru.geracimov.sbercodject.poker.analyzer.impl.StraightFlushAnalyzer;
import ru.geracimov.sbercodject.poker.card.Card;
import ru.geracimov.sbercodject.poker.card.DeckType;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

class CombinationAnalyzerFacadeTest extends AbstractTest {
    final CombinationAnalyzerFacade facade = new CombinationAnalyzerFacade();

    @BeforeEach
    void setUp() {
        deck = deckFactory.createDeck(DeckType.DECK_SHORT);
        combinationAnalyzer = new FlushAnalyzer();
    }

    @Test
    void opponentHasDuplicateCards() {
        Collection<Card> cards = deck.getCards(new String[]{"06h", "13s", "07s", "07d", "13s"});
        assertThat(facade.result(cards)).isEqualTo(-1);
    }

    @Test
    void opponentHasFullHouseOnQueensAndAces() {
        Collection<Card> cards = deck.getCards(new String[]{"14h", "12s", "14s", "12d", "12c"});
        assertThat(facade.result(cards)).isEqualTo(FullHouseAnalyzer.RESULT_SUCCESS);
    }

    @Test
    void opponentHasStraightFlushOnQueensAndAces() {
        Collection<Card> cards = deck.getCards(new String[]{"14c", "13c", "12c", "11c", "10c"});
        assertThat(facade.result(cards)).isEqualTo(StraightFlushAnalyzer.RESULT_SUCCESS);
    }

}