package experiments
import java.util.PriorityQueue
import problems.*

class GPRunner {
        def static problem = new Sine()//create problem here
        static numRuns
        def numTrees = 100
        def treeStore = []
        def results
        def system
        def queue = new PriorityQueue(numTrees)
        def rand = new Random()
        
        

        def createTrees = {
                def tree
                numTrees.times{
                        tree = problem.makeTree()
                        treeStore.add(tree)
                        queue.offer(tree)
                }
                
                numRuns.times {
                        replaceQueueAndTreeStore()
                        for(item in treeStore.clone()){
                                9.times{
                                    item.getSize()
                                    def toClone = treeStore[rand.nextInt(treeStore.size())]
                                    def a = rand.nextInt(item.findSize())
                                    def b = rand.nextInt(toClone.findSize())
                                    def crossTree = item.crossover(toClone, a, b)
                                    def c = rand.nextInt(crossTree.findSize())
                                    def mutantTree = crossTree.pointMutate(c)
                                    queue.offer(mutantTree)
                                    //queue.offer(item.crossover(toClone, rand.nextInt(item.findSize()), rand.nextInt(toClone.findSize())).pointMutate(rand.nextInt(item.findSize())))
                      
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
                        newTreeStore.add(top)
                }
                treeStore = newTreeStore
                queue=newQueue
        }
        
        static main(args) {
            //CreateSystem
            def runner = new GPRunner()
            
            numRuns = 2
            runner.createTrees()
            
            
    }
        

}