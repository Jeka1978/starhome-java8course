package linkedIn;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.functions;

import java.util.Arrays;

import static org.apache.spark.sql.functions.*;

/**
 * @author Evgeny Borisov
 */
public class Main {

    public static final String SALARY = "salary";
    public static final String AGE = "age";
    public static final String KEYWORDS = "keywords";
    public static final String KEYWORD = "keyword";

    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setMaster("local[*]").setAppName("Linked In");
        JavaSparkContext sc = new JavaSparkContext(sparkConf);
        SQLContext sqlContext = new SQLContext(sc);
        DataFrame dataFrame = sqlContext.read().json("data/linkedIn/*.json");
        dataFrame.show();
        dataFrame.printSchema();
        Arrays.stream(dataFrame.schema().fields()).forEach(System.out::println);
        dataFrame = dataFrame.withColumn(SALARY, col(AGE).multiply(10).multiply(size(col(KEYWORDS))));
        dataFrame.persist();
        dataFrame.show();


        DataFrame keyWordDF = dataFrame.withColumn(KEYWORD, explode(col(KEYWORDS))).select(KEYWORD);
        Row first = keyWordDF.groupBy(col(KEYWORD)).agg(count(KEYWORD).as("amount"))
                .sort(col("amount").desc()).first();
        String mostPopular = first.getAs(KEYWORD);

        System.out.println("mostPopular = " + mostPopular);

        dataFrame.filter(col(SALARY).leq(1200).and(array_contains(col(KEYWORDS), mostPopular))).show();

    }
}






