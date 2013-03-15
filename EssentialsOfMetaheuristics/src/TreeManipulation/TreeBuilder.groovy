package TreeManipulation

import GP.GPTree

class TreeBuilder {

    def depth
    def functions
    def variables
    // array of two numbers that is the range
    def constantRange
    def nodeStack
    def terminalProb
    def root
    def varsMap
    

    def makeTree = {
        if (nodeStack == null) {
            nodeStack = new NodeStack(functions: functions, variables: variables, constantRange: constantRange, terminalProb: terminalProb)
        }

        root = nodeStack.pop()
        childrenBuilder(1, root)
        new GPTree(root:root.clone(), nodeStack : nodeStack)
    }

    def childrenBuilder = {currDepth, node ->
        node.children=new Object[node.getArity()]

        if(currDepth<depth){
            node.getArity().times{
                node.children[it]=nodeStack.pop()
                childrenBuilder(currDepth+1, node.children[it])
            }
        } else {
            node.getArity().times{
                node.children[it]=nodeStack.getTerminal()
            }
        }
    }
    
    
}