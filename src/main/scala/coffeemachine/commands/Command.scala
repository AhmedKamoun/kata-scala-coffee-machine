package coffeemachine.commands

/**
  * @author KAMOUN Ahmed
  */
abstract class Command(code: String) {

  def getCode(): String = this.code
}


case class Chocolate() extends Command("H")
case class Tea() extends Command("T")