package GP

class GPTree {
	def root = null
	def functions
	//listOfTestPoints: List of maps that are the test values for the variables
	def listOfTestPoints
	def depth
	def size
	
	
	def evaluate = {
		if(root) {
			root.evaluate()
		} else {
			null
		}
	}
	
}
