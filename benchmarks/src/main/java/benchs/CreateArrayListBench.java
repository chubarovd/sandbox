package benchs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Thread)
@BenchmarkMode({Mode.AverageTime})
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 2)
@Warmup(iterations = 2, batchSize = 1)
@Measurement(iterations = 10, batchSize = 1)
public class CreateArrayListBench {

  private static final String VALUE = "any value";

  @Benchmark
  @Measurement(iterations = 1)
  public void createSingletonListWithCollections(Blackhole bh) {
    List<String> anySingleton = new ArrayList<>(Collections.singletonList(VALUE));
    bh.consume(anySingleton);
  }

  @Benchmark
  @Measurement(iterations = 1)
  public void createSingletonListWithArrays(Blackhole bh) {
    List<String> anySingleton = new ArrayList<>(Arrays.asList(VALUE));
    bh.consume(anySingleton);
  }

  @Benchmark
  @Measurement(iterations = 1)
  public void createSingletonListWithStream(Blackhole bh) {
    List<String> anySingleton = Stream.of(VALUE).collect(Collectors.toList());
    bh.consume(anySingleton);
  }

  @Benchmark
  @Measurement(iterations = 1)
  public void createSingletonListWithAnonymous(Blackhole bh) {
    List<String> anySingleton = new ArrayList<String>() {{
      add(VALUE);
    }};
    bh.consume(anySingleton);
  }

  @Benchmark
  @Measurement(iterations = 1)
  public void createSingletonListWithSimpleInstance(Blackhole bh) {
    List<String> anySingleton = new ArrayList<>();
    anySingleton.add(VALUE);
    bh.consume(anySingleton);
  }
}
