package music;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Service
public class MusicJudgeService {
    @Autowired
    private JavaSparkContext sc;

    @Autowired
    private TopXWordsService topXWordsService;

    public void printTopX(String artistName, int x) {
        JavaRDD<String> rdd = sc.textFile("data/songs/" + artistName + "/*");
        List<String> topWords = topXWordsService.topX(rdd, x);
        System.out.println("topWords = " + topWords);
    }
}





