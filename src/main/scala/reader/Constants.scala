package reader

import scala.collection.immutable.HashMap

object Constants {

  val SCHEMA_JSON = "SCHEMA_JSON"
  val PATHS = "PATHS"

  val commonReadConfigs: HashMap[String, String] = HashMap(SCHEMA_JSON -> "schemaJson", PATHS -> "paths");
}
