package problems

import TreeManipulation.Functions
import TreeManipulation.TreeBuilder



class AllRand {
    def rand = new Random()
    def variableList = ["x"]

    def testPoints = [rand.nextInt(), rand.nextInt(), rand.nextInt(), rand.nextInt(), rand.nextInt(),
        rand.nextInt(), rand.nextInt(), rand.nextInt(), rand.nextInt()]


    def variableValues = [["x" : rand.nextInt()], ["x" : rand.nextInt()], ["x" : rand.nextInt()],
        ["x" : rand.nextInt()], ["x" : rand.nextInt()], ["x" : rand.nextInt()], ["x" : rand.nextInt()],
        ["x" : rand.nextInt()], ["x" : rand.nextInt()]]

    def functions = (new Functions()).getFunctions()
    def makeTree = {
        def build = new TreeBuilder(depth: 5, variables: variableList, functions: functions, constantRange: [-5, 5], terminalProb: 0.1, varsMap: variableValues, testPoints: testPoints)
        build.makeTree()
    }

}