import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NewFeatureUtils {

    /**
     * 集合工厂方法  集合工厂方法返回的集合类是final类型
     */
    public static void listDemo(){
        Set<Integer> ints = Set.of(1,2);
        List<Integer> integerList = List.of(1,2,34,8);
    }

    /**
     * java 9 改进streamapi
     * Stream 接口中添加了 4 个新的方法：dropWhile, takeWhile, ofNullable。还有个 iterate 方法的新重载方法，
     * 可以让你提供一个 Predicate (判断条件)来指定什么时候结束迭代：
     */
    public static void streamApiDemo(){
        IntStream.iterate(1,i -> i < 100, i -> i + 1).forEach(System.out::print);

        //除了对 Stream 本身的扩展，Optional 和 Stream 之间的结合也得到了改进。
        // 现在可以通过 Optional 的新方法 `stram` 将一个 Optional 对象转换为一个(可能是空的) Stream 对象：
        Stream<Integer> stream = Optional.of(1).stream();
    }
}
