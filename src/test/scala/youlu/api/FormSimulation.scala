package youlu.api

import io.gatling.core.Predef._
import io.gatling.http.Predef._
class FormSimulation extends Simulation {
    val httpConf = http.baseUrl("http://computer-database.gatling.io")
    //注意这里,设置提交内容type
    val contentType = Map("Content-Type" -> "application/x-www-form-urlencoded")
    //声明scenario
    val scn = scenario("form Scenario").repeat(1000) {
        exec(http("form_test") //http 请求name
            .post("/computers") //post地址, 真正发起的地址会拼上上面的baseUrl http://computer-database.gatling.io/computers
            .headers(contentType)
            .formParam("name", "Beautiful Computer") //form 表单的property name = name, value=Beautiful Computer
            .formParam("introduced", "2012-05-30")
            .formParam("discontinued", "")
            .formParam("company", "37"))
    }
    setUp(scn.inject(atOnceUsers(1)).protocols(httpConf))
}
