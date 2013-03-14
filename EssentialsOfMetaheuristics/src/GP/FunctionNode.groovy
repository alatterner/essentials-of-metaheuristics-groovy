package GP

class FunctionNode {
    def value
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

    def traverse = {num ->
        if(num == 1) {
            this
        } else {
            def node
            children.each {
                if((num <= it.size + 1) && (node == null)) {
                    node = it.traverse(num-1)
                } else {
                    num = num - (it.size)
                }
            }
            node
        }
    }

    @Override
    Object clone() {
        def cloneChildren =  new Object[this.getArity()]
        this.getArity().times {
            cloneChildren[it] = this.children[it].clone()
        }
        new FunctionNode(value : this.value, id : this.id, size : this.size, children : cloneChildren)
    }
}
