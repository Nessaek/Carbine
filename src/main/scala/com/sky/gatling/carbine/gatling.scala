package com.sky.gatling.carbine

import io.gatling.core.check.Check

package object gatling {
  type CarbineCheck = Check[List[Map[String, Any]]]
}
