package com.sky.cel.mapper.perf

import com.sky.cel.mapper.perf.model.Classification
import com.sky.cel.mapper.perf.phantom.PhantomService
import com.sky.cel.mapper.perf.phantom.connector.PhantomConnector
import com.sky.gatling.carbine.SimulationRunner
import com.sky.gatling.carbine.cassandra.PhantomService
import com.sky.gatling.carbine.cassandra.connector.PhantomConnector
import com.sky.gatling.carbine.model.Classification
import com.sky.gatling.carbine.protocol.ProtocolBuilder
import io.gatling.commons.validation.Validation
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.core.session.Expression
import io.gatling.core.structure.ScenarioBuilder

import scala.collection.immutable

class CassandraSimulation extends Simulation {

  val persistenceService = new PhantomService(PhantomConnector.connector)

 val numberOfObjects: Int = 10000
  val numberOfUsers: Int = 1
  val config = ProtocolBuilder(testName,functionUnderTest,checkResult)

  val classificationFeeder: immutable.IndexedSeq[Map[String, Classification]] = for (_ <- 0 until numberOfObjects) yield Map("id" -> feedGenerator.apply())

  val result = scenario("test").repeat(numberOfObjects) {
    feed(classificationFeeder)
      .exec()
  }


}
