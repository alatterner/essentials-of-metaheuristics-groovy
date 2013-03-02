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
	
	def "test null tree evaluate"() {
		given:
		def nullTree = new GPTree()
		expect:
		nullTree.evaluate()==null
	}
	
	def "test single unit tree evaluate"() {
		given:
		def singleTree = new GPTree(root: constantNode)
		expect:
		singleTree.evaluate()==3
	}
}
