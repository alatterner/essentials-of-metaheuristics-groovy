package GP

class ConstantNode {

    def value
    def children = [0]
    def id
    def size = 1

    def evaluate = {valueMap ->
        value
    }

    String toString() {
        value.toString()
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
    
    def traverse = {num, other ->
        this
    }
    
    @Override
    Object clone() {
        new ConstantNode(value : this.value, children : null, id : this.id, size : 1)
    }
}
