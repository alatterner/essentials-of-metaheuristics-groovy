package GP

class FunctionNode {
    def value
    def children
    def id
    def size

    def evaluate = {valueMap ->
        def childValues = [this.getArity()]

        children.size().times {
            childValues[it] = children[it].evaluate(valueMap)
        }

        if(this.getArity() == 1) {
            this.value.function(childValues[0])
        } else if(this.getArity() == 2) {
            this.value.function(childValues[0], childValues[1])
        } else if(this.getArity() == 3) {
            this.value.function(childValues[0], childValues[1], childValues[2])
        } else {
            println("lol u got hacked brah")
        }
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

    def traverse = {location, helperNum ->
        if(location <= helperNum) {
            this
        } else {
            def node
            children.each {
                if((location <= it.size + 1) && (node == null)) {
                    node = it.traverse(location-1, helperNum)
                } else {
                    location = location - (it.size)
                    if ((location <= helperNum) && (helperNum == 2) && node == null) {
                        node = this
                    }
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
