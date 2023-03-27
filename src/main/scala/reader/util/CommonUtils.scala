package reader.util

import org.apache.spark.sql.DataFrameReader
import reader.Constants.commonReadConfigs

import scala.collection.immutable.HashMap

object CommonUtils {

  def applyOptions(dfr: DataFrameReader, configs: HashMap[String, String]): DataFrameReader = {
    dfr.options(configs.filter(pair => !commonReadConfigs.contains(pair._1)))
  }
}
