package youlu.api

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._

//txt的文件内容为JSON数据，存放目录/resources/bodies下
class RawFileBodySimulation extends Simulation {
    val httpConf = http.baseUrl("http://127.0.0.1:7001/tst")
    //注意这里,设置提交内容type
    val headers_json = Map("Content-Type" -> "application/json")
    val scn = scenario("json scenario")
    .exec(http("test_json")   //http 请求name
    .post("/order/get")     //post url
    .headers(headers_json)  //设置body数据格式
    //将json参数用StringBody包起,并作为参数传递给function body()
    .body(RawFileBody("request.txt")))

        setUp(scn.inject(atOnceUsers(10))).protocols(httpConf)
}
