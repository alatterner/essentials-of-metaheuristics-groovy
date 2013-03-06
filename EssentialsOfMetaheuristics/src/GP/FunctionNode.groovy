package GP

class FunctionNode {
	def value
	def parent
	def children
	def id
	def arity
	
	def evaluate = {
		value(children)
	}
}
