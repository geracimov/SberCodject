package ru.geracimov.sbercodject.poker;

import org.junit.jupiter.api.BeforeAll;
import ru.geracimov.sbercodject.poker.analyzer.CombinationAnalyzer;
import ru.geracimov.sbercodject.poker.card.Deck;
import ru.geracimov.sbercodject.poker.card.DeckFactory;

public abstract class AbstractTest {
    protected static DeckFactory deckFactory;
    protected CombinationAnalyzer combinationAnalyzer;
    protected Deck deck;

    @BeforeAll
    static void beforeAll() {
        deckFactory = new DeckFactory();
    }
}
