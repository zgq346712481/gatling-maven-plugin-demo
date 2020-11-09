//package youlu.api
//
//import io.gatling.core.Predef._
//import io.gatling.core.scenario.Simulation
//import io.gatling.http.Predef._
//​
//class SpringBootSimulation extends Simulation{
//    //设置请求的根路径
//    val httpConf = http.baseUrl("http://localhost:8080")
//    /*
//      运行100秒 during 默认单位秒,如果要用微秒 during(100 millisecond)
//     */
//    val scn = scenario("SpringBootSimulation").during(100){
//        exec(http("springboot_home").get("/helloworld"))
//    }
//    //设置线程数
//    //  setUp(scn.inject(rampUsers(500) over(10 seconds)).protocols(httpConf))
//    setUp(scn.inject(atOnceUsers(10)).protocols(httpConf))
//}
