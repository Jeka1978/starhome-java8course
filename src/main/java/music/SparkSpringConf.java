package music;

import org.apache.spark.SparkConf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Evgeny Borisov
 */
@Configuration
public class SparkSpringConf {
    @Bean
    @Profile("LOCAL")  //spring.profiles.active = LOCAL
    public SparkConf confLocal(){
        return new SparkConf().setAppName("music").setMaster("local[*]");
    }

    @Bean
    @Profile("PROD")
    public SparkConf confProd(){
        return new SparkConf().setAppName("music");
    }
}
