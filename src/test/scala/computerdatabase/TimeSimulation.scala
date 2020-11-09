package computerdatabase
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class TimeSimulation  extends Simulation {

    val httpProtocol = http
        .baseUrl("http://www.baidu.com")
        .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
        .acceptEncodingHeader("gzip, deflate")
        .acceptLanguageHeader("en-US,en;q=0.5")
        .userAgentHeader("Mozilla/5.0")

    val scn = scenario("BaiduSimulation").during(100){
        exec(http("baidu_home").get("/"))
    }
    setUp(
        scn.inject(
            atOnceUsers(10)
        ).protocols(httpProtocol)
    )
}
