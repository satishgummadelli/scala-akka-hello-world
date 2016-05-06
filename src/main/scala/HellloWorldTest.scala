
import akka.actor.{Actor, ActorSystem, Props}


/**
 * Created by satishgummadelli on 06/05/16.
 */
object HellloWorldTest extends App {

  val actorSystem = ActorSystem("Hello-World-Akka")
  val greetingActor = actorSystem.actorOf(Props(GreeterActor), "greetingActor")

  greetingActor ! Greeting("Hello World Akka")

  greetingActor ! Greeting("Again Hello World From Akka")

}

case class Greeting(message: String)

class GreeterActor extends Actor {
  override def receive: Receive = {
    case Greeting(message) => println(s"$message")
  }

}