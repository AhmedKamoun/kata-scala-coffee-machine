package coffeemachine.commands

/**
  * @author KAMOUN Ahmed
  */
abstract class Command(val code: String, val price: BigDecimal) {

  def getCode(): String = this.code
}
