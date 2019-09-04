package benchs;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@BenchmarkMode(Mode.All)
@Warmup(iterations = 1000)
@Measurement(iterations = 1000000, batchSize = 10)
public class CreateArrayListBench {
    private static final String VALUE = "any value";

    @Benchmark
    public void createSingletonListWithCollections(Blackhole bh) {
        List<String> anySingleton = new ArrayList<>(Collections.singletonList(VALUE));
        bh.consume(anySingleton);
    }

    @Benchmark
    public void createSingletonListWithArrays() {
        List<String> anySingleton = new ArrayList<>(Arrays.asList(VALUE));
    }

    @Benchmark
    public void createSingletonListWithStream() {
        List<String> anySingleton = Stream.of(VALUE).collect(Collectors.toList());
    }

    @Benchmark
    public void createSingletonListWithAnonymous() {
        List<String> anySingleton = new ArrayList<String>() {{
            add(VALUE);
        }};
    }

    @Benchmark
    public void createSingletonListWithSimpleInstance() {
        List<String> anySingleton = new ArrayList<>();
        anySingleton.add(VALUE);
    }
}
