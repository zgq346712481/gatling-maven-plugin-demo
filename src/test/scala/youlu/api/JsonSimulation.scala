package youlu.api

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._
import scala.concurrent.duration._

//运行说明 只要要执行gatling.bat就可以了  键入脚本序号，以0排序，敲击两次Enter就可以开始执行测试了

class JsonSimulation extends Simulation {

//    curl -X POST http://10.1.20.96:8080/seq/save -H 'Postman-Token: 66a84769-58b9-4fa5-81d7-50e07996b739' -H 'cache-control: no-cache'

    val httpConf = http.baseUrl("http://127.0.0.1:7001/tst")
    //1.http head配置 注意这里,设置提交内容type
    val headers_json = Map("Content-Type" -> "application/json")
    val contentType = Map("Content-Type" -> "application/x-www-form-urlencoded")

    //2.scenario执行细节
    val scn = scenario("json scenario").repeat(1000) {
        exec(http("test_json") //http 请求name
            .post("/order/get") //post url
            .headers(headers_json) //设置body数据格式
            //将json参数用StringBody包起,并作为参数传递给function body()
            .body(StringBody("{\"orderNo\":201519828113}")))
    }

    //3.setUp组装
    setUp(scn.inject(atOnceUsers(1000))).protocols(httpConf)

}
