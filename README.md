## Building Water Molecules

**_Problem Statement_**

There are two kinds of threads, namely, oxygen and hydrogen.
In order to assemble these threads into water molecules, we have to create a barrier that makes each thread wait until 
a complete molecule is ready to proceed. <br>
As each thread passes the barrier, it should invoke bond. You must guarantee that all the threads from one molecule 
invoke bond before any of the threads from the next molecule do.<br>
In other words: <br>
• If an oxygen thread arrives at the barrier when no hydrogen threads are present, it has to wait for two hydrogen 
threads.<br>
• If a hydrogen thread arrives at the barrier when no other threads are present, it has to wait for an oxygen thread 
and another hydrogen thread.<br>
Write synchronization code for oxygen and hydrogen molecules that enforces these constraints.

**_Description_**

To encapsulate the functioning of the barrier, we have used the `CyclicBarrier` class from the `java.util.concurrent` 
package. <br>
It is a synchronization aid that can synchronize threads progressing through some algorithm. <br>
`CyclicBarrier` is used to make threads wait for each other. 
It is used when different threads process a part of computation and when all threads have completed the execution, the 
result needs to be combined in the parent thread. <br>
After completing its execution, threads call await() method and wait for other threads to reach the barrier. 
Once all the threads have reached, the barriers then give the way for threads to proceed. <br>
 `CyclicBarrier`s are useful in programs involving a fixed sized party of threads that must occasionally wait for each 
 other.<br> The barrier is called cyclic because it can be re-used after the waiting threads are released. <br>

**_Solution_**

We have used the following variables in our solution:
A `CyclicBarrier` object `hydroxyBarrier`
Counts `hydrogen` and `oxygen`
Semaphore `hydrogenQueue`, upon which hydrogen atoms queue
Semaphore `oxygenQueue`, upon which oxygen atoms queue

We have two kinds of threads: `Hydrogen` and `Oxygen`. 
Every `Hydrogen` thread waits upon the barrier. It checks whether a hydrogen atom and an oxygen atom are available.
If they are available, it signals them and invokes `bond()` method, thus combining with them.
Else, it increments `hydrogen` and queues up on `hydrogenQueue`.

Every `Oxygen` thread also waits upon the barrier. It checks whether two hydrogen atoms are waiting. 
If they are, it releases them and invokes `bond()` method, thus combining with both of them and producing a water molecule.
Else, it increments `oxygen` and queues up on `oxygenQueue`.

The `bond()` method resets both the `hydroxyBarrier` and the counts `hydrogen` and `oxygen` to 0.

The Driver class creates and instance of `BuildingH2O`, which all threads share.
It then creates multiple threads of both `Hydrogen` and `Oxygen` types, and runs them.
