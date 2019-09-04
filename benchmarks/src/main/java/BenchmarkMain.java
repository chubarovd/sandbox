import benchs.CreateArrayListBench;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkMain {
    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
            .include(CreateArrayListBench.class.getSimpleName())
            .forks(5)
            .build();

        new Runner(opt).run();
    }
}
