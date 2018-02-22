package music;

import org.apache.spark.api.java.JavaRDD;

import java.io.Serializable;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
public interface TopXWordsService extends Serializable{
    List<String> topX(JavaRDD<String> rdd, int x);

}
