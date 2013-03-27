package experiments
import java.util.PriorityQueue
import problems.Square

class GPRunner {
        def problem = new Square()//create problem here
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
                                    println("toClone")
                                    println(toClone.generateDot())
                                    println("item Tree")
                                    println(item.generateDot())
                                    def a = rand.nextInt(item.findSize())
                                    def b = rand.nextInt(toClone.findSize())
                                    def c = rand.nextInt(item.findSize())
                                    println("First int: ${a}, Second int: ${b}, crossover item: ${c}")
                                    def crossTree = item.crossover(toClone, a, b)
                                    println("crossoverTree")
                                    println(crossTree.generateDot())
                                    def mutantTree = crossTree.pointMutate(c)
                                    println("MUTANTTREE WASDAS")
                                    println(mutantTree.generateDot())
                                    queue.offer(mutantTree)
                                    //queue.offer(item.crossover(toClone, rand.nextInt(item.findSize()), rand.nextInt(toClone.findSize())).pointMutate(rand.nextInt(item.findSize())))
                                    println("WE GOT HERE YAY")
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
                        //println("size is " + queue.size())
                        def top = queue.poll()
                        println("top is " + top)
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