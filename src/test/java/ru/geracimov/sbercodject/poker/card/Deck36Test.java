package ru.geracimov.sbercodject.poker.card;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class Deck36Test {
    protected static DeckFactory deckFactory;
    protected Deck deck;

    @BeforeAll
    static void beforeAll() {
        deckFactory = new DeckFactory();
    }

    @BeforeEach
    void setUp() {
        deck = deckFactory.createDeck(DeckType.DECK_SHORT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"06h", "06c", "08d", "09s", "14s", "13h"})
    void getCard(String cardLiteral) {
        assertThat(deck.getCard(cardLiteral)).isNotNull();
        assertThat(deck.getCard(cardLiteral)).hasToString(cardLiteral);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0h", "6c", "08a", "09S", "18s", "00h", "-1s"})
    void getCardIllegal(String cardLiteral) {
        assertThatThrownBy(() -> deck.getCard(cardLiteral)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Card literal is incorrect [%s]", cardLiteral);
    }

    @Test
    void getCardsIllegal() {
        assertThatThrownBy(() -> deck.getCards(new String[]{"06h", "06s", "08s", "09s", "7s"})).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Card literal is incorrect [%s]", "7s");
    }

    @Test
    void getCards() {
        assertThat(deck.getCards(new String[]{"06h", "06s", "08s", "09s", "07s"})).isNotNull()
                .hasSize(5)
                .containsExactlyInAnyOrder(
                        deck.getCard("06h"),
                        deck.getCard("06s"),
                        deck.getCard("08s"),
                        deck.getCard("09s"),
                        deck.getCard("07s")
                );
    }

}