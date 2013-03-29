package GP

class VariableNode {

    def value
    def children = []
    def id
    def size = 1
    def rand = new Random()

    def evaluate = {valueMap ->
        (int) valueMap.getAt(this.value)
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

    def traverse = {num, other ->
        this
    }

    @Override
    Object clone() {
        new VariableNode(value : this.value, children : [], id : rand.nextLong(), size : 1)
    }
}
