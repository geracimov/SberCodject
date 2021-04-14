package ru.geracimov.sbercodject.poker.card;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SuitTest {

    @ParameterizedTest
    @ValueSource(chars = {'h'})
    void valueOfHeart(char charSuit) {
        assertThat(Suit.valueOf(charSuit)).isEqualTo(Suit.HEART);
    }

    @ParameterizedTest
    @ValueSource(chars = {'c'})
    void valueOfClub(char charSuit) {
        assertThat(Suit.valueOf(charSuit)).isEqualTo(Suit.CLUB);
    }

    @ParameterizedTest
    @ValueSource(chars = {'d'})
    void valueOfDiamond(char charSuit) {
        assertThat(Suit.valueOf(charSuit)).isEqualTo(Suit.DIAMOND);
    }

    @ParameterizedTest
    @ValueSource(chars = {'s'})
    void valueOfSpade(char charSuit) {
        assertThat(Suit.valueOf(charSuit)).isEqualTo(Suit.SPADE);
    }

    @ParameterizedTest
    @ValueSource(chars = {'g', '8', '-'})
    void valueOfInvalid(char charSuit) {
        assertThatThrownBy(() -> Suit.valueOf(charSuit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Incorrect card suite [%c]", charSuit);
    }

}