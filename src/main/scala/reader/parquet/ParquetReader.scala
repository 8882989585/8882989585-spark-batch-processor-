package reader.parquet

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DataType, StructType}
import reader.Constants.{PATHS, SCHEMA_JSON, commonReadConfigs}
import reader.util.CommonUtils.applyOptions

import scala.collection.immutable.HashMap

object ParquetReader {

  def read(ss: SparkSession, configs: HashMap[String, String]): Unit = {
    val schemaOrSchemaLessReader = if (Option(configs(commonReadConfigs(SCHEMA_JSON))).exists(_.trim.nonEmpty)) ss.read.schema(
      DataType.fromJson(configs(commonReadConfigs(SCHEMA_JSON))).asInstanceOf[StructType]) else ss.read
    applyOptions(schemaOrSchemaLessReader, configs)
      .parquet(configs(commonReadConfigs(PATHS)).split(",").map(_.trim).toList: _*)
  }
}
