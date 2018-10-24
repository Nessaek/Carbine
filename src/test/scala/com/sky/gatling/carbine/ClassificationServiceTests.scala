package com.sky.gatling.carbine

import com.sky.cel.mapper.perf.model.Classification
import org.scalacheck.Arbitrary
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class ClassificationServiceTests extends FlatSpec with GeneratorDrivenPropertyChecks with Matchers {

  implicit val arbitraryClassification: Arbitrary[Classification] = Arbitrary(classificationGen)

  private val classificationGen = ClassificationService.generateClassification()

  "generateClassification" should "generate different classifications every time it is called" in {
    forAll{ (classification:Classification) =>
      val classification2 = ClassificationService.generateClassification()
      classification.equals(classification2) should be (false)

    }
  }

}
