package com.sky.gatling.carbine.model

import com.outworkers.phantom.dsl._
import io.circe._
import io.circe.generic.semiauto._
import io.circe.parser._
import io.circe.syntax._


object Classification {
  implicit val jsonDecoder: Decoder[Classification] = deriveDecoder[Classification]
  implicit val jsonEncoder: Encoder[Classification] = deriveEncoder[Classification]

  implicit val classifPrimitive: Primitive[Classification] = Primitive.json[Classification](_.asJson.noSpaces)(decode[Classification](_).right.get)
}

/**
  * Model to represent Classification object.
  *
  * @param classifKey
  * @param categoryType
  * @param parentalRating
  * @param hideIfEmpty
  * @param usage
  * @param filter          - String as we don't know what it is
  * @param fieldTrial
  * @param description
  * @param name
  * @param shortName
  * @param softKey
  * @param resourcePackage - String as we don't know what it is
  * @param renderHint      - String as we don't know what it is
  * @param darwinHint      - String as we don't know what it is
  * @param uuid
  * @param classifId
  * @param classifications
  * @param parent          - String as we don't know what it is
  * @param ordered         - String as we don't know what it is
  */

case class Classification(
                           classifKey: String,
                           categoryType: Int,
                           parentalRating: Int,
                           hideIfEmpty: Boolean,
                           usage: Int,
                           filter: String,
                           fieldTrial: Int,
                           description: String,
                           name: String,
                           shortName: String,
                           softKey: String,
                           resourcePackage: String,
                           renderHint: String,
                           darwinHint: String,
                           uuid: String,
                           classifId: Long,
                           classifications: List[String] = List(""),
                           parent: String = "",
                           ordered: String = ""
                         ) {

  def getClassifKey: String = classifKey
}
