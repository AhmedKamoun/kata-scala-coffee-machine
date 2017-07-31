package coffeemachine

import coffeemachine.commands.{Coffee, Tea}
import org.mockito.Mockito.when
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{BeforeAndAfterAll, FlatSpec, Matchers}

/**
  * @author KAMOUN Ahmed
  */
class CoffeeMachineTest extends FlatSpec with Matchers with MockitoSugar with BeforeAndAfterAll {

  val instructionTranslator = mock[InstructionTranslator]
  var coffeeMachine: CoffeeMachine = _

  override def beforeAll() = {
    coffeeMachine = new CoffeeMachine(instructionTranslator)
  }

  "coffee machine" should "get 1 tea with one sugar and stick" in {

    //when
    when(instructionTranslator.getDrinkMakerCommand(Tea(), 1)).thenReturn("T:1:0")

    //then
    val result = coffeeMachine.getCommand(0.4, Tea(), 1)

    result should equal("T:1:0")
  }

  it should "get 1 coffee  without stick" in {

    //when
    when(instructionTranslator.getDrinkMakerCommand(Coffee(), 0)).thenReturn("C::")

    //then
    val result = coffeeMachine.getCommand(0.8, Coffee(), 0)

    result should equal("C::")
  }

  it should "return missing money" in {

    //when
    when(instructionTranslator.getDrinkMakerCommand(Tea(), 0)).thenReturn("T::")

    //then
    val result = coffeeMachine.getCommand(0.1, Tea(), 0)

    result should equal("0.3")
  }

}
