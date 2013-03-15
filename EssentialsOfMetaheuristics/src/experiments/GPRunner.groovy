package experiments
import java.util.PriorityQueue


class GPRunner {
        def problem //create problem here
        static numRuns
        def numTrees = 100
        def treeStore = []
        def results
        def system
        def queue = new PriorityQueue(numTrees)
        def rand = new Random()
        
        static main(args) {
                problem = new Square()
                //CreateSystem
                numRuns = 2
                createTrees()
                
        }

        def createTrees = {
                def tree
                numTrees.each{
                        tree = problem.makeTree()
                        treeStore = treeStore.add(tree)
                        queue.offer(tree)
                }
                numRuns.times {
                        replaceQueueAndTreeStore()
                        for(item in treeStore.clone()){
                                9.times{
                                        queue.offer(system.crossover(treeStore(rand.nextInt(treeStore.size()))).performMutation(item))
                                }
                        }
                }
                replaceQueueAndTreeStore()
                treeStore.each{
                        println(it.generateDot())
                }
        }

        def replaceQueueAndTreeStore = {
                def newQueue = new PriorityQueue(numTrees)
                def newTreeStore = []
                10.times {
                        def top = queue.poll()
                        newQueue.offer(top)
                        newTreeStore = newTreeStore.add(top)
                }
                treeStore = newTreeStore
                queue=newQueue
        }
        

}