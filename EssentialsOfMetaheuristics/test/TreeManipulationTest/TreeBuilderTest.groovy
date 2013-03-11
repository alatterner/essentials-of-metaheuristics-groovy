package TreeManipulationTest

import static org.junit.Assert.*
import static spock.util.matcher.HamcrestMatchers.closeTo
import GP.ConstantNode
import GP.FunctionNode
import GP.VariableNode
import TreeManipulation.TreeBuilder
import spock.lang.Specification

class TreeBuilderTest extends Specification{
	def functions = new Functions()
	def funcList = functions.getFunctions()
	def variables = ["x", "y", "z"]
	def constantRange = [-5, 5]
	def terminalProb = 0.25
	def treeBuilder
	
	def setup() {
		treeBuilder = new TreeBuilder(functions: funcList, variables : variables, constantRange : constantRange, terminalProb : terminalProb, depth: 4)
	}

	
	def "no smoke test"() {
		given:
		def testTree = treeBuilder.makeTree()
		println(testTree)
		
		expect:
		testTree != null
	}
}
