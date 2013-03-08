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
		node.children=new Object[node.getArity()]
		if(currDepth<depth){
			node.getArity().each{
				node.children[it-1]=nodeStack.pop()
				childrenBuilder(currDepth+1, node.children[it-1])
			}
		} else {
			node.getArity().each{
				node.children[it-1]=nodeStack.getTerminal()
			}
		}
	}
}