package com.sky.gatling.carbine

import com.sky.gatling.carbine.protocol.ProtocolBuilder
import io.gatling.commons.validation.Validation
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.core.session.Expression
import io.gatling.core.structure.ScenarioBuilder

import scala.collection.immutable

class SimulationRunner[A, B](testName: Expression[String],functionUnderTest: A => B, predef: Dsl[A, B], feedGenerator: () => A, checkResult:(B,B) => Status) extends Simulation {


  val numberOfObjects: Int = 10000
  val numberOfUsers: Int = 1
  val config: ProtocolBuilder[A, B] = ProtocolBuilder(functionUnderTest)

  val classificationFeeder: immutable.IndexedSeq[Map[String, A]] = for (_ <- 0 until numberOfObjects) yield Map("id" -> feedGenerator.apply())



  val result = scenario(testName.toString()).repeat(numberOfObjects) {
    feed(classificationFeeder)
      .exec()
  }

}

