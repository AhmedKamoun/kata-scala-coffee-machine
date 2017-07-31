package coffeemachine

import coffeemachine.commands.{Chocolate, Coffee, Command, Tea}

/**
  * @author KAMOUN Ahmed
  */
class InstructionTranslator {

  def getDrinkMakerCommand(command: Command, sugarQte: Int): String = {

    s"${command.getCode()}${getSugarCode(sugarQte)}"
  }

  private def getSugarCode(quantity: Int) = {
    quantity match {
      case 0 => "::"
      case 1 => ":1:0"
      case 2 => ":2:0"
      case _ => ""
    }

  }

  def getMessageContent(message: String): String = message.replaceFirst("M:", "")

}
