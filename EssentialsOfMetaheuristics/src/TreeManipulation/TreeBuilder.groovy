package TreeManipulation

class TreeBuilder {

	def depth
	def functions
	def variables
	// array of two numbers that is the range
	def constantRange
	def nodeStack
	def terminalProb
	def root

	def makeTree = {
		nodeStack = new NodeStack(functions: functions, variables: variables, constantRange: constantRange, terminalProb: terminalProb)

		root = nodeStack.pop()
		childrenBuilder(1, root)

	}

	def childrenBuilder = {currDepth, node ->
		node.children=new Object[node.arity]
		if(currDepth<depth){
			node.arity.each{
				node.children[it]=nodeStack.pop()
				childrenBuilder(currDepth+1, node.children[it])
			}
		} else {
			node.arity.each{
				node.children[it]=nodeStack.getTerminal()
			}
		}
	}
}