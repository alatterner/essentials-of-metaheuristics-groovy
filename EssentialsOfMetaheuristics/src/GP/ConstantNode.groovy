package GP

class ConstantNode {

    def value
    def parent
    def children = null
    def id
    def size = 1

    def evaluate = {
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
}
