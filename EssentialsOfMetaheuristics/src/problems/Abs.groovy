package problems

import TreeManipulation.Functions
import TreeManipulation.TreeBuilder



class Abs {

    def variableList = ["x"]

    def testPoints = [17, 13, 11, 7, 5, 3, 2, 1, 0, 1, 2, 3, 5, 7, 11, 13, 17]

    def variableValues = [["x" : -17], ["x" : -13], ["x" : -11], ["x" : -7], ["x" : -5], ["x" : -3], ["x" : -2], ["x" : -1], ["x" : 0], ["x" : 1], ["x" : 2], ["x" : 3], ["x" : 5], ["x" : 7], ["x" : 11], ["x" : 13], ["x" : 17]]

    def functions = (new Functions()).getFunctions()
    def makeTree = {
        def build = new TreeBuilder(depth: 5, variables: variableList, functions: functions, constantRange: [-5, 5], terminalProb: 0.1, varsMap: variableValues, testPoints: testPoints)
        build.makeTree()
    }

}