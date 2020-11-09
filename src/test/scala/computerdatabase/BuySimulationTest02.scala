package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

//脚本串联
//gatling比较好的一个功能,就是可以把业务串联起来.
//比如:首页->详情->下单-支付.这个业务逻辑就是一个简单的全链路. 这个脚本是从串联的三个接口并且在每个接口设置一定的停顿时间,总体是并发1000的虚拟用户.
//这个场景也比较符合压测的漏斗效应,在最后面的接口一般都是用户请求量较小的(比如支付).
class BuySimulationTest02  extends Simulation{
    val httpProtocol = http
        .baseUrl("http://computer-database.gatling.io") // Here is the root for all relative URLs
        .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
        .acceptEncodingHeader("gzip, deflate")
        .acceptLanguageHeader("en-US,en;q=0.5")
        .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

    val scn = scenario("Scenario Name") // A scenario is a chain of requests and pauses
        .exec(http("request_home")
        .get("/home"))
        .pause(7) // Note that Gatling has recorder real time pauses
        .exec(http("request_detail")
        .get("/ebookdetail?id=123"))
        .pause(2)
        .exec(http("request_buy") // Here's an example of a POST request
            .post("/buy")
            .formParam("""name""", """时间简史""")
        )

    setUp(scn.inject(atOnceUsers(1000)).protocols(httpProtocol))
}
