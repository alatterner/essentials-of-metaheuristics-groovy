package TreeManipulation

import GP.ConstantNode
import GP.VariableNode

class NodeStack {

    def stack = new Stack()
    def functions
    def variables
    // array of two numbers that is the range
    def constantRange
    def terminalProb
    def rand = new Random()
    def idCounter = 0

    def private addToStack = {
        10.times {
            if (rand.nextFloat() > terminalProb) {
                def function = functions[rand.nextInt(functions.size())]
                function.id=idCounter++
                stack.push(function)
            } else {
                if (rand.nextBoolean()) {
                    def variable = variables[rand.nextInt(variables.size())]
                    def varNode = new VariableNode(value: variable, id: idCounter++)
                    stack.push(varNode)
                } else {
                    def constant = rand.nextInt(constantRange[1]-constantRange[0])+constantRange[0]
                    def consNode = new ConstantNode(value: constant, id: idCounter++)
                    stack.push(consNode)
                }
            }
        }
    }

    def pop = {
        if (stack.empty()) {
            addToStack()
        }
        stack.pop()
    }

    def empty = {
        stack.empty()
    }
    //This will give us a non-functionNode terminal node.
    def getTerminal = {
        def value = this.pop()

        while(value.class == GP.FunctionNode){
            value=this.pop()
        }
        value
    }

    


    //This doesn't work
    def String toString = {
        stack.toString()
    }
}
