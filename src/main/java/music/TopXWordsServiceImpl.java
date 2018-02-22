package music;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scala.Tuple2;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Service
public class TopXWordsServiceImpl implements TopXWordsService {

    @AutowiredBroadcast
    private Broadcast<UserProps> broadcastUserProps;



    @Override
    public List<String> topX(JavaRDD<String> rdd, int x) {
        return rdd.map(String::toLowerCase)
                .flatMap(WordsUtil::getWords)
                .filter(word -> !this.broadcastUserProps.getValue().getGarbage().contains(word))
                .mapToPair(word -> new Tuple2<>(word, 1))
                .reduceByKey(Integer::sum)
                .mapToPair(Tuple2::swap)
                .sortByKey(false)
                .map(Tuple2::_2).
                        take(x);

    }
}
