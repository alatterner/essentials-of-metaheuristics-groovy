package TreeManipulationTest

import static org.junit.Assert.*
import static spock.util.matcher.HamcrestMatchers.closeTo
import GP.ConstantNode
import GP.FunctionNode
import GP.VariableNode
import TreeManipulation.*
import spock.lang.Specification

class TreeBuilderTest extends Specification{
    def functions = new Functions()
    def funcList = functions.getFunctions()
    def variables = ["x", "y", "z"]
    def constantRange = [-5, 5]
    def terminalProb = 0.25
    def treeBuilder
    def rand
    def nodeStack

    def setup() {
        functions = funcList
        nodeStack = new NodeStack(constantRange: constantRange, variables: variables, functions: functions, terminalProb: terminalProb)
        nodeStack.rand.setSeed(-6301399911171497922)
        treeBuilder = new TreeBuilder(depth: 4, nodeStack : nodeStack)
    }


    def "no smoke test"() {
        given:
        def testTree = treeBuilder.makeTree()

        expect:
        testTree != null
    }

    def "test generateDot"() {
        given:
        def testTree = treeBuilder.makeTree()
        testTree.generateDot()

        expect:
        testTree != null
    }

    def "test getSize"() {
        given:
        def testTree = treeBuilder.makeTree()
        def treeSize = testTree.updateSize()

        expect:
        treeSize instanceof Integer
    }

    def "test traverse"() {
        given:
        def testTree = treeBuilder.makeTree()

        expect:
        testTree.traverse(1).toString() == "*"
        testTree.traverse(2).toString() == "2"
        testTree.traverse(3).toString() == "+"
        testTree.traverse(4).toString() == "sin"
        testTree.traverse(5).toString() == "-5"
        testTree.traverse(6).toString() == "y"
    }
    
    def "test find parent()"() {
        given:
        def testTree = treeBuilder.makeTree()
        
        expect:
        testTree.getParent(1).toString() == "*"
        testTree.getParent(2).toString() == "*"
        testTree.getParent(3).toString() == "*"
        testTree.getParent(4).toString() == "+"
        testTree.getParent(5).toString() == "sin"
        testTree.getParent(6).toString() == "+"
    }

    def "test the mutation function"() {
        given:
        def testTree = treeBuilder.makeTree()

        expect:
        testTree.pointMutate(3).traverse(3).toString() == "cos"
        testTree.pointMutate(2).traverse(2).toString() == "-4"
    }
    
    def "test crossover mutation"() {
        given:
        def testTree = treeBuilder.makeTree()
        treeBuilder.makeTree() //This is just a really lame tree and we don't want to reseed after all of this work
        def otherTree = treeBuilder.makeTree()
        def newTree = testTree.crossover(otherTree, 2, 1)
        expect:
        newTree.traverse(1).toString() == "*"
        newTree.traverse(2).toString() == "sin"
        newTree.traverse(3).toString() == "-"
        newTree.traverse(4).toString() == "4"
        newTree.traverse(5).toString() == "x"
        newTree.traverse(6).toString() == "+"
        newTree.traverse(7).toString() == "sin"
        newTree.traverse(8).toString() == "-5"
        newTree.traverse(9).toString() == "y"
    }
    
    def "test test test() "() {
        given:
        def testTree = treeBuilder.makeTree()
        def listOfExpectedValues = [45, 23]
        println(testTree.evaluate([[x : 3, y : 2, z : 9], [x : 1, y : 3, z : -4]], listOfExpectedValues))
        
        
        expect:
        true
    }

}
