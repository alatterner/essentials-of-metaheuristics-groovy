package TreeManipulation

import GP.FunctionNode
import GP.GPFunctions

class Functions {

    def addition = {x,y ->
        println "x = " + x.class + " and y = " + y.class
        x+y
    }

    def subtract = {x,y ->
        println "x = " + x.class + " and y = " + y.class
        x-y
    }

    def multiplication = {x,y ->
        println "x = " + x.class + " and y = " + y.class
        x*y
    }

    def division = {x,y ->
        println "x = " + x.class + " and y = " + y.class
        if(y==0){
            y
        } else {
            x/y
        }
    }

    def ifFunc = {x,y,z ->
        println "x = " + x.class + " and y = " + y.class + " and z = " + z.class
        if(x>0){
            y
        } else {
            z
        }

    }

    def sin = {x ->
        println "x = " + x.class
        Math.sin(x)
    }

    def cos = {x ->
        println "x = " + x.class
        Math.cos(x)
    }


    def public getFunctions() {
        [createFunction(addition, "+"), createFunction(subtract, "-"), createFunction(multiplication, "*"),
            createFunction(division, "/"), createFunction(ifFunc, "if"), createFunction(sin, "sin"), createFunction(cos, "cos")]
    }
    def createFunction = {x,y ->
        new FunctionNode(value: new GPFunctions(function:x, string:y))
    }
}
