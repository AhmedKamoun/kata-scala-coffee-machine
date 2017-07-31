package coffeemachine

import coffeemachine.commands.{Chocolate, Coffee, Tea}
import org.scalatest.{FlatSpec, Matchers}

/**
  * @author KAMOUN Ahmed
  */
class InstructionTranslatorTest extends FlatSpec with Matchers {

  "instruction translator " should "get 1 tea with one sugar and stick" in {
    //when
    val result = InstructionTranslator.getDrinkMakerCommand(Tea(), 1)

    //then
    result should equal("T:1:0")

  }
  it should "get 1 tea without sugar" in {
    //when
    val result = InstructionTranslator.getDrinkMakerCommand(Tea(), 0)

    //then
    result should equal("T::")
  }

  it should " 1 chocolate with no sugar and therefore no stick" in {
    //when
    val result = InstructionTranslator.getDrinkMakerCommand(Chocolate(), 0)
    //then
    result should equal("H::")
  }

  it should "get 1 coffee with 2 sugars and a stick" in {
    //when
    val result = InstructionTranslator.getDrinkMakerCommand(Coffee(), 2)
    //then
    result should equal("C:2:0")
  }

  it should "get message content from drink maker" in {
    //when
    val result = InstructionTranslator.getMessageContent("M:message-content")
    //then
    result should equal("message-content")
  }
}
