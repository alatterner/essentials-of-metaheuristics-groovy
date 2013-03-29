package TreeManipulationTest

import GP.FunctionNode
import GP.GPFunctions

class Functions {

    def add = {x,y ->
        x+y
    }

    def subtract = {x,y ->
        x-y
    }

    def multiply = {x,y ->
        x*y
    }

    def division = {x,y ->
        if(y == 0) {
            1
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

  //  def sin = {x ->
  //      Math.sin(x)
  //  }

    def cos = {x ->
        Math.cos(x)
    }

    //createFunction(sin, "sin"), 

    def public getFunctions() {
        [createFunction(add, "+"), createFunction(subtract, "-"), createFunction(multiply, "*"),
            createFunction(division, "/"), createFunction(ifFunc, "if"), createFunction(cos, "cos")]
    }
    def createFunction = {x,y ->
        new FunctionNode(value: new GPFunctions(function:x, string:y))
    }
}
