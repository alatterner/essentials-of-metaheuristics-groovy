package GPTest;

import static org.junit.Assert.*
import static spock.util.matcher.HamcrestMatchers.closeTo
import GP.ConstantNode
import GP.FunctionNode
import GP.VariableNode
import spock.lang.Specification


public class NodeTest extends Specification {
	def cNode
	def vNode
	def vNodeValue
	def fNode
	def fNodeChildren

	def setup() {
		cNode = new ConstantNode(value: 2)
		vNodeValue = 3
		vNode = new VariableNode(value: vNodeValue)
		fNodeChildren = [cNode, vNode]
		
	}

	def "Basic call to the constructor test"() {
		given:
		cNode = new ConstantNode(value: 2)
		//when:
		expect:
		cNode.evaluate() == 2
	}

	def "Basic call to the VariableNode test"() {
		given:
		vNodeValue = 3
		vNode = new VariableNode(value: vNodeValue)
		expect:
		vNode.evaluate() == 3
	}
	
	def "Basic call to the FunctionTest test"() {
		given:
		def fFunction = {x ->
			x[0].evaluate() + x[1].evaluate()
		}
		
		fNode = new FunctionNode(value: fFunction, children: fNodeChildren)
		
		expect:
		fNode.evaluate() == 5
	}


}
