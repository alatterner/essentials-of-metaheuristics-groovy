package experiments

import problems.ILSOptimize
import singleStateMethods.HillClimber

class ResearchRunner {
	static main(args){
		def searcher=new HillClimber()
		def problem=new ILSOptimize(maxIterations:100)
		def numRuns=30
		def mutationRates = new ArrayList()
		//Let's look at the mean or median mutationRate...
		for (i in 0..<numRuns) {
			problem.evalCount = 0
			def result = searcher.maximize(problem)
			//println "${searcher.toString()}\t${problem.toString()}\t${problem.quality(result)}"
			mutationRates.add(result.mutationRate)
		}
		//Let's take a gander at the mutation rates
		println mutationRates.toString()
		def sum = 0
		mutationRates.each() {
			sum+=it
		}
		def average = sum/mutationRates.size()
		println average
		def median = mutationRates.get((Integer) mutationRates.size()/2)
		println median
		
	}
	

}