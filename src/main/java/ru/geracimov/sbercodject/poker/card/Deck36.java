package ru.geracimov.sbercodject.poker.card;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Сокращенная колода 36 карт
 */
public class Deck36 implements Deck {
    private final Map<String, Card> cards;

    private Deck36(Map<String, Card> mutableMap) {
        this.cards = Collections.unmodifiableMap(mutableMap);
    }

    @Override
    public Card getCard(String cardLiteral) {
        return Optional.ofNullable(cards.get(cardLiteral))
                .orElseThrow(() -> new IllegalArgumentException(String.format("Card literal is incorrect [%s]", cardLiteral)));
    }

    @Override
    public Collection<Card> getCards(String[] cardStrings) {
        return Arrays.stream(cardStrings).map(this::getCard).collect(Collectors.toList());
    }

    public static Deck36 getInstance() {
        Map<String, Card> map = new HashMap<>();
        Arrays.stream(Rank.values())
                .filter(Deck36::isSuited).forEach(
                rank -> Arrays.stream(Suit.values())
                        .filter(Deck36::isSuited)
                        .forEach(suit -> {
                            CardImpl card = new CardImpl(rank, suit);
                            map.put(card.toString(), card);
                        })
        );
        return new Deck36(map);
    }

    private static boolean isSuited(Rank rank) {
        return rank.compareTo(Rank.C06) >= 0 && rank.compareTo(Rank.ACE) <= 0;
    }

    private static boolean isSuited(Suit suit) {
        return suit.compareTo(Suit.HEART) >= 0 && suit.compareTo(Suit.SPADE) <= 0;
    }

}
