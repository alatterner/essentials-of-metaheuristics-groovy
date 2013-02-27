package GP

class FunctionNode {
	def value
	def parent
	def children
	def id
	
	def evaluation = {
		value(children)
	}
}
