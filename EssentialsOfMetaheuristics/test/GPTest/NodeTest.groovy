package GPTest;

import static org.junit.Assert.*
import static spock.util.matcher.HamcrestMatchers.closeTo
import GP.ConstantNode
import GP.FunctionNode
import GP.VariableNode
import TreeManipulationTest.Functions
import spock.lang.Specification


public class NodeTest extends Specification {
    def cNode
    def vNode
    def vNodeValue
    def fNode
    def fNodeChildren = [2]
    def functionList = new Functions()
    def functions

    def setup() {
        cNode = new ConstantNode(value: 2)
        vNode = new VariableNode(value: "x")
        fNodeChildren = [cNode, vNode]
        functions = functionList.getFunctions()

    }

    def "Basic call to the constructor test"() {
        given:
        cNode = new ConstantNode(value: 2)
        //when:
        expect:
        cNode.evaluate([x : "DEATH"]) == 2
    }

    def "Basic call to the VariableNode test"() {
        given:
        vNode = new VariableNode(value : "x")
        expect:
        vNode.evaluate([x : 3]) == 3
    }

    def "Basic call to the FunctionTest test"() {
        given:
        //def fFunction = {x, y ->
        //    x + y
            //x[0].evaluate([x : 3]) + x[1].evaluate([x : 3])
        //}

        fNode = functions[0]
        fNode.children = fNodeChildren

        expect:
        fNode.evaluate([x : 3]) == 5
    }


}
