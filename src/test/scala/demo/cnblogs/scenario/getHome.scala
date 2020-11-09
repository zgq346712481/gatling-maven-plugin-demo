package demo.cnblogs.scenario

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.structure.ChainBuilder

import demo.cnblogs.base.phHeaders.headers_base

object getHome {
    val getHome: ChainBuilder = exec(http("home")
        .get("/")
        .headers(headers_base))
}
