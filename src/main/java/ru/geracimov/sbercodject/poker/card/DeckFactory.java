package ru.geracimov.sbercodject.poker.card;

import java.util.EnumMap;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Фабрика колод,
 * возможно расширение поддерживаемых колод
 */
public class DeckFactory {
    private static final String UNSUPPORTED_OPERATION_FORMAT = "Deck type [%s] is not supported";
    private final EnumMap<DeckType, Supplier<Deck>> suppliers;

    public DeckFactory() {
        suppliers = new EnumMap<>(DeckType.class);
        suppliers.put(DeckType.DECK_SHORT, Deck36::getInstance);
    }

    public Deck createDeck(DeckType deckType) {
        return Optional.ofNullable(suppliers.get(deckType))
                .orElseThrow(() -> new UnsupportedOperationException(String.format(UNSUPPORTED_OPERATION_FORMAT, deckType)))
                .get();
    }

}
