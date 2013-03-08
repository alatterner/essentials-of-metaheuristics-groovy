package GP

class ConstantNode {

	def value
	def parent
	def children = null
	def id
	
	def evaluate = {
		value
	}
	
	String toString() {
		value.toString()
	}
	
	def getArity = {
		0
	}
}
