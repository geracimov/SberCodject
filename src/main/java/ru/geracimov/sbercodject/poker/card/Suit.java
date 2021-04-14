package ru.geracimov.sbercodject.poker.card;

import java.util.Arrays;

public enum Suit {
    HEART('h'), DIAMOND('d'), CLUB('c'), SPADE('s');

    private static final String VALUE_OF_ILLEGAL_MESSAGE_TEMPLATE = "Incorrect card suite [%c]";

    Suit(char suiteChar) {
        this.suiteChar = suiteChar;
    }

    private final char suiteChar;

    public char getSuiteChar() {
        return suiteChar;
    }

    public static Suit valueOf(char suiteChar) {
        return Arrays.stream(values())
                .filter(s -> s.getSuiteChar() == suiteChar).findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format(VALUE_OF_ILLEGAL_MESSAGE_TEMPLATE, suiteChar)));
    }

    @Override
    public String toString() {
        return String.valueOf(suiteChar);
    }

}
