package problems

import singleStateMethods.IteratedLocalSearchRandomRestarts

class ILSOptimize {
	protected rand = new java.util.Random()
	Integer evalCount = 0
	Integer maxIterations = 1000
	Float lowerBound = 1
	Float upperBound = 50
	Float halfMutationRange = 10
	def smallProblem
	
	def create = {
		smallProblem=new LeadingOnes(numBits : 50 , maxIterations : 100)
		//smallProblem=new OnesMax(numBits:10, maxIterations:100)
		return new IteratedLocalSearchRandomRestarts()
	}
	
	def copy = { a -> new IteratedLocalSearchRandomRestarts(mutationRate: a.mutationRate) }
	//Change quality to a loop. Mean the quality.
	def quality = { a ->
		//println "evaluating quality of ILS_OPT, ${a.mutationRate}"
		++evalCount
		def qualList = new ArrayList()
		def runTimes = 30
		runTimes.times{
			smallProblem.evalCount = 0
			qualList.add(smallProblem.quality(a.maximize(smallProblem)))
		}
		def average = 0
		qualList.each() {
			average += it
		}
		average=average/runTimes
		return average
	}
	
	def tweak = { a ->
		new IteratedLocalSearchRandomRestarts(mutationRate:(bound(a.mutationRate  + (2 * rand.nextFloat() - 1) * halfMutationRange)))
	}
	
	private bound(x) {
		if (x < lowerBound) {
			lowerBound
		} else if (x > upperBound) {
			upperBound
		} else {
			x
		}
	}
	
	def terminate = { a, q = quality(a) ->
		evalCount >= maxIterations || q == maximalQuality()
	}
	
	def maximalQuality = {
		smallProblem.maximalQuality()
	}
	
	String toString(){
		"ILS_OPT_${smallProblem.toString()}_$maxIterations"
	}

}