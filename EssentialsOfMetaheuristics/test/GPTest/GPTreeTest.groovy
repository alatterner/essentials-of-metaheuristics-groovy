package GPTest

import static org.junit.Assert.*
import static spock.util.matcher.HamcrestMatchers.closeTo
import GP.ConstantNode
import GP.GPTree
import spock.lang.Specification

class GPTreeTest extends Specification{
	def constantNode
	
	def setup(){
		constantNode = new ConstantNode(value: 3)
	}
	
	def "test empty tree evaluate"() {
		given:
		def emptyTree = new GPTree()
		expect:
		emptyTree.evaluate(3, 4)==null
	}
	
	def "test single unit tree evaluate"() {
		given:
		def singleTree = new GPTree(root: constantNode)
		expect:
		singleTree.evaluate([x: 4], [3])==0
	}
}
