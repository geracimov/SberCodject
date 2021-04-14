package ru.geracimov.sbercodject.poker.analyzer;

import ru.geracimov.sbercodject.poker.analyzer.impl.*;
import ru.geracimov.sbercodject.poker.card.Card;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CombinationAnalyzerFacade {
    private final Collection<CombinationAnalyzer> analyzers;

    public CombinationAnalyzerFacade() {
        this.analyzers = List.of(
                new OnePairAnalyzer(),
                new TwoPairAnalyzer(),
                new ThreeAnalyzer(),
                new StraightAnalyzer(),
                new FlushAnalyzer(),
                new FullHouseAnalyzer(),
                new FourAnalyzer(),
                new StraightFlushAnalyzer()
        );
    }

    public int result(Collection<Card> cards) {
        if (cards.stream().distinct().count() < cards.size())
            return -1;
        List<CompletableFuture<Integer>> futures = analyzers.stream()
                .map(a -> CompletableFuture.supplyAsync(() -> a.analyze(cards))).collect(Collectors.toList());
        return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new))
                .thenApply(unused -> futures.stream()
                        .map(CompletableFuture::join)
                        .reduce(Math::max))
                .join().orElse(0);
    }

}
