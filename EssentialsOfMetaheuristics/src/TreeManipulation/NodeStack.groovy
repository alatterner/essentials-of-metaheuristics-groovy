package TreeManipulation

class NodeStack {

	def stack = new Stack()
	def functions
	def variables
	// array of two numbers that is the range
	def constantRange
	def terminalProb
	def rand = new Random()

	def private addToStack = {
		10.times {
			if (rand.nextFloat() > terminalProb) {
				stack.push(functions[rand.nextInt(functions.size())])
			} else {
				if (rand.nextBoolean()) {
					stack.push(variables[rand.nextInt(variables.size())])
				} else {
					stack.push(rand.nextInt(constantRange[1]-constantRange[0])+constantRange[0])
				}
			}
		}
	}

	def pop = {
		if (stack.empty()) {
			addToStack()
		}
		stack.pop()
	}
	
	def empty = {
		stack.empty()
	}
	
	
	//This doesn't work
	def String toString = {
		stack.toString()
	}
}
