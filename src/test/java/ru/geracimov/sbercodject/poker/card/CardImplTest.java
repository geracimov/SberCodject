package ru.geracimov.sbercodject.poker.card;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardImplTest {

    @Test
    void testEquals() {
        CardImpl card1 = new CardImpl(Rank.C06, Suit.SPADE);
        CardImpl card2 = new CardImpl(Rank.C06, Suit.SPADE);
        assertThat(card1).isEqualTo(card2);
    }
}