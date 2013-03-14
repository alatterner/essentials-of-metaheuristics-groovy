package GP

class VariableNode {

    def value
    def children = null
    def id
    def size = 1

    def evaluate = {
        //We need to check the variable against a mapping of the variables passed into it. We don't know where that is yet.
        value
    }

    String toString() {
        value
    }

    def getArity = {
        0
    }
    
    def generateDot = {
        def returnString = ""
        returnString = this.id + " [label=\"" + this.value + "\"]\n"
        returnString
    }
    
    def countSize = {
        0
    }

    def traverse = {num ->
        this
    }
    
    @Override
    Object clone() {
        new VariableNode(value : this.value, children : null, id : this.id, size : 1)
    }
}
