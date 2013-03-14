package GP

class GPTree {
    def root = null
    def functions
    //listOfTestPoints: List of maps that are the test values for the variables
    def listOfTestPoints
    def depth
    def size
    def maxId
    def nodeStack


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
        def treeCopy = this.clone()
        def node = treeCopy.traverse(num)
        if(node.class == GP.FunctionNode) {
            def func = nodeStack.getFunction()
            if(func.getArity() > node.getArity()) {
                def toAdd = func.getArity-node.getArity
                def clonedNode = node.children[0].clone()
                toAdd.times{
                    node.children.add(clonedNode)
                }
            } else if(func.getArity() < node.getArity()) {
                node.children=node.children[0..func.getArity()-1]
                
            }
            node.value = func.value
            node.size = func.size
        } else {
            def terminal = nodeStack.getTerminal()
            node.value = terminal.value
        }
        treeCopy
    }
    
    def updateSize = {
        size = root.countSize()+1
    }
    
    def traverse = {num ->
        this.updateSize()
        root.traverse(num)
    }
    
    @Override
    Object clone() {
        def cloneTree = new GPTree(root : this.root.clone(), functions : this.functions, 
            listOfTestPoints : this.listOfTestPoints, depth : this.depth, size : this.size, maxId : this.maxId)
        cloneTree
    }
}
