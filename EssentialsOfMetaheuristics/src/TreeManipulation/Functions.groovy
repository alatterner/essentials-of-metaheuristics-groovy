package TreeManipulation

import GP.FunctionNode
import GP.GPFunctions

class Functions {

    def addition = {x,y ->
        x+y
    }

    def subtract = {x,y ->
        x-y
    }

    def multiplication = {x,y ->
        x*y
    }

    def division = {x,y ->
        if(y==0){
            y
        } else {
            x/y
        }
    }

    def ifFunc = {x,y,z ->
        if(x>0){
            y
        } else {
            z
        }

    }

    def sin = {x ->
        Math.sin(x)
    }

    def cos = {x ->
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
