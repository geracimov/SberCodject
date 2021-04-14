package ru.geracimov.sbercodject.poker.card;

/**
 * Игральная карта
 * Suit - масть
 * Rank - достоинство
 */
public interface Card {
    Suit getSuit();

    Rank getRank();
}
