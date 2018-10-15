package com.sky.gatling.carbine.check
import com.sky.gatling.carbine.gatling.CarbineCheck
import io.gatling.commons.validation.{Failure, Validation}
import io.gatling.core.check.CheckResult
import io.gatling.core.session.Session

import scala.collection.mutable

case class CassandraSimpleCheck(func: List[Map[String, Any]] => Boolean) extends CarbineCheck {

  override def check(response: List[Map[String, Any]], session: Session)(
    implicit cache: mutable.Map[Any, Any]): Validation[CheckResult] = {
    if (func(response)) {
      CheckResult.NoopCheckResultSuccess
    } else {
      Failure("Cassandra check failed")
    }
  }
}