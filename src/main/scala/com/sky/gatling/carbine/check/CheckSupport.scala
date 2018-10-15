package com.sky.gatling.carbine.check

trait CheckSupport {
  def simpleCheck: CassandraSimpleCheck.type = CassandraSimpleCheck
}
