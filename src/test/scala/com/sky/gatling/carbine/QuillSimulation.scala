package com.sky.gatling.carbine

import com.sky.cel.mapper.perf.model.Classification
import com.sky.cel.mapper.perf.quill.QuillService
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation

class QuillSimulation extends Simulation {

  val persistenceService: QuillService = new QuillService
  val simulation = new  SimulationRunner[String, Classification](persistenceService, ClassificationPredef, () => ClassificationService.generateClassification())

  setUp(simulation.insertAndFind.inject(atOnceUsers(simulation.numberOfUsers)).protocols(simulation.cassandraConfig.build)).protocols(simulation.cassandraConfig.build)

}
