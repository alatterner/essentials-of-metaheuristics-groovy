package GP

class VariableNode {
	
	def value
	def parent
	def children = null
	def id
	
	
	def evaluation = {
		//We need to check the variable against a mapping of the variables passed into it. We don't know where that is yet.
		value
	}
}
