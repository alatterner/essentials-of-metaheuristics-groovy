package experiments

import problems.ILSOptimize
import singleStateMethods.HillClimber

class ResearchRunner {
	static main(args){
		def searcher=new HillClimber()
		def problem=new ILSOptimize()
		def numRuns=1
		for (i in 0..<numRuns) {
			problem.evalCount = 0
			def result = searcher.maximize(problem)
			println "${searcher.toString()}\t${problem.toString()}\t${problem.quality(result)}"
			println result.mutationRate
		}
	}

}
