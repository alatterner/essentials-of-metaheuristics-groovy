package GP

class GPTree {
    def root = null
    def functions
    //listOfTestPoints: List of maps that are the test values for the variables
    def listOfTestPoints
    def depth
    def size
    def maxId


    def evaluate = {
        if(root) {
            root.evaluate()
        } else {
            null
        }
    }


    String toString() {
        "eat me"
    }
    
    def generateDot = {
       "graph G {\n" + root.generateDot()+ "\n}"
    }
    
    def pointMutate = {num ->
        updateSize()
        
        
    }
    
    def updateSize = {
        size = root.countSize()+1
    }
}
