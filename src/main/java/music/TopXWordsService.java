package music;

import org.apache.spark.api.java.JavaRDD;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public interface TopXWordsService {
    List<String> topX(JavaRDD<String> rdd, int x);

}
