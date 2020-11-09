//package demo.cnblogs.simulation
//
//import io.gatling.core.Predef._
//import scala.concurrent.duration._
//
//import demo.cnblogs.scenario._
//import demo.cnblogs.base._
//
//class userLoginTest extends Simulation {
//    import demo.cnblogs.base.phHttpProtocol.{noneBlackList, noneWhiteList}
//
//    val httpProtocol = phHttpProtocol("http://192.168.100.141:9000")
//
//    val scn = scenario("user_login")
//        .exec(
//            getHome.getHome
//                .pause(5 seconds),
//            userLogin.login
//                .pause(60 seconds)
//        )
//
//    setUp(scn.inject(rampUsers(1000) over (3 seconds))).protocols(httpProtocol)
//
//}
