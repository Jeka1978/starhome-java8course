package taxi_lab;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.storage.StorageLevel;
import scala.Tuple2;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setAppName("taxi").setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(sparkConf);
        JavaRDD<String> rdd = sc.textFile("data/taxi/taxi_order.txt");

        rdd.persist(StorageLevel.MEMORY_AND_DISK());
        System.out.println("total trips: " + rdd.count());

        JavaRDD<Trip> trips = rdd.map(FunctionUtils::convertLineToTrip);
        trips.persist(StorageLevel.MEMORY_AND_DISK());

        JavaRDD<Trip> longBostonTrips = trips
                .filter(trip -> trip.getCity().equals("boston"))
                .filter(trip -> trip.getKm() > 10);
        System.out.println("longBostonTrips count " + longBostonTrips.count());

     /*   trips.filter(trip -> trip.getCity().equals("boston"))
                .map(Trip::getKm).reduce((a,b)->a+b);

        trips.filter(trip -> trip.getCity().equals("boston"))
                .map(Trip::getKm).reduce(Integer::sum);*/

        Double totalBostonKm = trips.filter(trip -> trip.getCity().equals("boston"))
                .mapToDouble(Trip::getKm).sum();
        System.out.println("totalBostonKm = " + totalBostonKm);

        JavaPairRDD<Integer, Integer> id2TotalKm = trips.
                mapToPair(trip -> new Tuple2<>(trip.getId(), trip.getKm()));
        id2TotalKm = id2TotalKm.reduceByKey(Integer::sum);

        JavaPairRDD<Integer, String> driversData = sc.textFile("data/taxi/drivers.txt")
                .mapToPair(line -> {
                            String[] strings = line.split(",");
                    return new Tuple2<>(Integer.valueOf(strings[0]), strings[1]);
                        }
                );
        JavaPairRDD<Integer, Tuple2<Integer, String>> joinedRdd = id2TotalKm
                .join(driversData);
        joinedRdd.mapToPair(Tuple2::_2).
                sortByKey(false).take(3).forEach(System.out::println);


    }


}



