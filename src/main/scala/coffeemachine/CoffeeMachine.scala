package coffeemachine

import coffeemachine.commands.Command

/**
  * @author KAMOUN Ahmed
  */
class CoffeeMachine(instructionTranslator: InstructionTranslator) {
  def getCommand(money: BigDecimal, command: Command, quantity: Int): String = {
    if (money >= command.price)
      instructionTranslator.getDrinkMakerCommand(command, quantity)
    else
      (command.price - money).toString()
  }
}
