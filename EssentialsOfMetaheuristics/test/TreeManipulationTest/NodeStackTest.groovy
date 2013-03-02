package TreeManipulationTest

import static org.junit.Assert.*
import static spock.util.matcher.HamcrestMatchers.closeTo
import GP.ConstantNode
import GP.FunctionNode
import GP.VariableNode
import TreeManipulation.NodeStack
import spock.lang.Specification

class NodeStackTest extends Specification{

	def nodeStack
	def constantRange = [-5, 5]
	def variables = ["x", "y", "z"]
	def functions = ["if", "+", "-", "*", "/", "sin"]
	def terminalProb = 0.25
	
	def setup() {
		nodeStack = new NodeStack(constantRange: constantRange, variables: variables, functions: functions, terminalProb: terminalProb)
		nodeStack.rand.setSeed(-6301399511171497922)
	}
	
	def "test initiating"() {
		expect:
		nodeStack != null
	}
	
	def "test making a stack"() {
		given:
		nodeStack.pop()
		Stack expectedStack = new Stack()

		expectedStack.push("z")
		expectedStack.push("+")
		expectedStack.push("y")
		expectedStack.push("-")
		expectedStack.push("y")
		expectedStack.push("+")
		expectedStack.push("/")
		expectedStack.push("/")
		expectedStack.push("*")
		println(nodeStack.toString())
		println(expectedStack.toString())
		
		expect:
		nodeStack.stack.toString().equals(expectedStack.toString())
		
	}
}
