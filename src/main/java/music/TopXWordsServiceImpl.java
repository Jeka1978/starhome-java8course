package music;

import org.apache.spark.api.java.JavaRDD;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Service
public class TopXWordsServiceImpl implements TopXWordsService {
    @Override
    public List<String> topX(JavaRDD<String> rdd, int x) {
        return null;
    }
}
