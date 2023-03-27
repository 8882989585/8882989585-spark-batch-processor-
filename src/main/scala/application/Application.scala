package application

import reader.parquet.ParquetReader

object Application extends App {
    val ss = Context.buildSparkSession();
    ParquetReader.read(ss, );
}
