package application

import org.apache.spark.sql.SparkSession

object Context {

  def buildSparkSession() : SparkSession = {
    SparkSession.builder()
      .master("local[*]")
      .appName("spark-batch-processor")
      .getOrCreate();
  }
}
