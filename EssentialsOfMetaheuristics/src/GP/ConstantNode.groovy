package GP

class ConstantNode {

    def value
    def children = []
    def id
    def size = 1
    def rand = new Random()

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
        new ConstantNode(value : this.value*1, children : [], id : rand.nextLong(), size : 1)
    }
}
