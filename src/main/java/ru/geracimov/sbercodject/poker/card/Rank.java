package ru.geracimov.sbercodject.poker.card;

public enum Rank {
    C02(2),
    C03(3),
    C04(4),
    C05(5),
    C06(6),
    C07(7),
    C08(8),
    C09(9),
    C10(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14),
    JOKER(15);

    private final int intValue;

    Rank(int intValue) {
        this.intValue = intValue;
    }

    @Override
    public String toString() {
        return String.format("%02d", intValue);
    }
}
