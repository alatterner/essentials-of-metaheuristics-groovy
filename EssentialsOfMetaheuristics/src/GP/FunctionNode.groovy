package GP

class FunctionNode {
	def value
	def parent
	def children
	def id
	
	def evaluate = {
		value(children)
	}
	
	def getArity = {
		value.getArity()
	}
	
	String toString() {
		value.toString()
	}
}
