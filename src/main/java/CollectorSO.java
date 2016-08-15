import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorSO {
    public static <K, V> void main(String[] args) {
        Collector<Entry<K, V>, ?, Map<K, V>> collector = Collectors.toMap(Entry::getKey, Entry::getValue);
        Stream<Entry<String, Object>> stream = Stream.empty();
//        stream.collect(collector);
    }
}