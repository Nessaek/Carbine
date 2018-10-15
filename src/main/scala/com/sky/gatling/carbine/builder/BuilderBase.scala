package com.sky.gatling.carbine.builder


import io.gatling.core.session.Expression

case class CassandraFindBuilderBase[A](value: Expression[String],
                                    service: A) {
  def find(): ActionBuilder =
    ActionBuilder(value, service)
}
