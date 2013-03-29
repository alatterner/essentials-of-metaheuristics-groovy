package problems

import TreeManipulation.Functions
import TreeManipulation.TreeBuilder



class Square {

    def variableList = ["x"]

    def testPoints = [25, 16, 9, 4, 1, 0, 1, 4, 9, 16, 25]

    def variableValues = [["x" : -5], ["x" : -4], ["x" : -3], ["x" : -2], ["x" : -1], ["x" : 0], ["x" : 1], ["x" : 2], ["x" : 3], ["x" : 4], ["x" : 5]]

    def functions = (new Functions()).getFunctions()
    def makeTree = {
        def build = new TreeBuilder(depth: 5, variables: variableList, functions: functions, constantRange: [-5, 5], terminalProb: 0.1, varsMap: variableValues, testPoints: testPoints)
        build.makeTree()
    }

}