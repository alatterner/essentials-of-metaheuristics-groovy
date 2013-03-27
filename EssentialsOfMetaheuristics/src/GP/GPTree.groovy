package GP

class GPTree implements Comparable<GPTree>{
    def root = null
    def functions
    //listOfTestPoints: List of maps that are the test values for the variables
    def depth
    def size
    def maxId
    def nodeStack
    def rand = new Random()
    def fitness
    def listOfValueMap
    def listOfExpectedValues

    def evaluate = {
        if(this.root == null) {
            null
        } else if(fitness == null) {
            def num = 0
            if(root) {
                listOfValueMap.size().times {
                    num += (root.evaluate(listOfValueMap[it]) - listOfExpectedValues[it])**2
                }
            } else {
                null
            }
            num
        } else {
            fitness
        }
    }



    String toString() {
        this.root.toString()
    }

    def generateDot = {
        "graph G {\n" + root.generateDot()+ "\n}"
    }



    def crossover = {otherTree, thisTreePoint = rand.nextInt(this.size)+1, otherTreePoint = rand.nextInt(this.size)+1 ->


        def clonedTree = this.clone()
        def otherSubTree = otherTree.traverse(otherTreePoint).clone()
        def ourSubTree = clonedTree.getParent(thisTreePoint)

        ourSubTree.children.size().times {
            if (ourSubTree.children[it] == clonedTree.traverse(thisTreePoint)) {

                ourSubTree.children[it] = otherSubTree
            }
        }
        clonedTree
    }
    
    def findSize = {
        this.updateSize()
        this.size
    }

    def pointMutate = {num ->
        def treeCopy = this.clone()
        def node = treeCopy.traverse(num)
        if(node.class == GP.FunctionNode) {
            def func = nodeStack.getFunction()
            if(func.getArity() > node.getArity()) {
                def toAdd = func.getArity()-node.getArity()
                def clonedNode = node.children[0].clone()
                toAdd.times{
                    node.children[it] = clonedNode
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

    def traverseHelper = {location, helperNum ->
        this.updateSize()
        root.traverse(location, helperNum)
    }

    def traverse = {location ->
        this.traverseHelper(location, 1)
    }

    def getParent = {location ->
        this.traverseHelper(location, 2)
    }

    @Override
    Object clone() {
        def cloneTree = new GPTree(root : this.root.clone(), functions : this.functions,
                nodeStack : this.nodeStack, depth : this.depth, size : this.size, maxId : this.maxId,
                listOfValueMap : this.listOfValueMap, listOfExpectedValues : this.listOfExpectedValues)
        cloneTree
    }



    int compareTo(GPTree other) {
//        if(this.evaluate() < other.evaluate()) {
//            1
//        } else if (this.evaluate() > other.evaluate()){
//            -1
//        } else {
//            0
//        }
       // this.evaluate()<=>other.evaluate()
    this.evaluate()
        }


}
