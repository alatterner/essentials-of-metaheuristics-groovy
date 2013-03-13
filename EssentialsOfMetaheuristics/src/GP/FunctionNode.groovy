package GP

class FunctionNode {
    def value
    def parent
    def children
    def id
    def size

    def evaluate = {
        value(children)
    }

    def getArity = {
        value.getArity()
    }

    String toString() {
        value.toString()
    }
    
    def generateDot = {
        def returnString = ""
        returnString = this.id + " [label=\"" + this.value.toString() + "\"]\n"
        children.each{
            returnString+=this.id + " -- " +it.id +"\n"
            returnString+=it.generateDot()
        }
        returnString
    }
    
    def countSize = {
        int sizeOf = value.getArity()
        children.each{
            sizeOf += it.countSize()
        }
        size = sizeOf+1
        sizeOf
    }

}
