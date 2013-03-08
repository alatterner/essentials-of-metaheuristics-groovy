package GP

class ConstantNode {

	def value
	def parent
	def children = null
	def id
	def arity = 0
	
	def evaluate = {
		value
	}
	
	String toString() {
		value.toString()
	}
}
