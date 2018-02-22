package music;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MainConf.class)
@ActiveProfiles("LOCAL")
public class SparkSpringConfTest {
    @Autowired
    private TopXWordsService topXWordsService;

    @Autowired
    JavaSparkContext sc;

    @Test
    public void confProd() throws Exception {
        JavaRDD<String> rdd = sc.parallelize(Arrays.asList("java is the best java language",
                "scala is not better than Java",
                "groovy is like java, but groovy groovy java java"));


        List<String> topWords = topXWordsService.topX(rdd, 1);
        Assert.assertEquals(1,topWords.size());
        Assert.assertEquals("java",topWords.get(0));

    }

}