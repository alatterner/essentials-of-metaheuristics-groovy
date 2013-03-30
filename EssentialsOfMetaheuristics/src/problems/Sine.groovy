package problems

import TreeManipulation.Functions
import TreeManipulation.TreeBuilder



class Sine {

    def variableList = ["x"]

    def testPoints = [0, Math.sin(-7/4 * Math.PI), 1, Math.sin(-5/4 * Math.PI), 0, Math.sin(-3/4 * Math.PI),
         -1, Math.sin(-1/4 * Math.PI), 0, Math.sin(1/4 * Math.PI), 1, Math.sin(3/4 * Math.PI), 0, Math.sin(5/4 * Math.PI)
         , -1, Math.sin(7/4 * Math.PI), 0]

    def variableValues = [["x" : (-2 * Math.PI)], ["x" : (-7/4 * Math.PI)], ["x" : (-6/4 * Math.PI)], ["x" : (-5/4 * Math.PI)], 
        ["x" : (-4/4 * Math.PI)], ["x" : (-3/4 * Math.PI)], ["x" : (-2/4 * Math.PI)], ["x" : (-1/4 * Math.PI)], ["x" : 0], 
        ["x" : (1/4 * Math.PI)], ["x" : (2/4 * Math.PI)], ["x" : (3/4 * Math.PI)], ["x" : (4/4 * Math.PI)],
        ["x" : (5/4 * Math.PI)], ["x" : (6/4 * Math.PI)], ["x" : (7/4 * Math.PI)], ["x" : (2 * Math.PI)]]

    def functions = (new Functions()).getFunctions()
    def makeTree = {
        def build = new TreeBuilder(depth: 5, variables: variableList, functions: functions, constantRange: [-5, 5], terminalProb: 0.1, varsMap: variableValues, testPoints: testPoints)
        build.makeTree()
    }

}