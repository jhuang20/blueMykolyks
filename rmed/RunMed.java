//Team BlueMykolyks-James Huang, Zane Wang, Taaseen Ali
/*Develop an algorithm for calculating the running media of an input stream of Integers.
 * PLAN:
 * kms
 * 1. change ALHeap to ALHeapMin, modify it to creat ALHeapMAx
 * 2. do all the methods
 * ALGORITHM:
 * 1. getMedian()
 * get the size of each heap: median=mean of roots
 * OR if the sizes are not equal, the median is the root of the larger heat
 * 2. add(newVal)
 * compare to root of min heap first(always default to adding to min heap)
 * if larger add to that
 * compare to root of max heap and add to that if smoler
 * 
 * check sizes of two heaps
 * add to the smaller one from the larger one(using the ALheap add methods), to rebalance until as close to balanced as poss
 * always
 * 
 * 
 Form a plan for implementing each this algorithm.
 State algorithm in block comment at top of RunMed.java.
 Use ALHeap as the basis for writing ALHeapMin and ALHeapMax.
 Store ALHeapMin, ALHeapMax, RunMed in repoRoot/rmed/.
 Write class RunMed, which implements an efficient running median algorithm.
 instvars:
 ALHeapMin lilVals
 ALHeapMax bigVals
 methods:
 constructor
 getMedian() returns median or throws NoSuchElementException()
 add(Integer newVal) adds newVal to appropriate heap, balances if necessary
*/



//COMUNICATION use this to get attention if ya need
//James

//Zane

//Taaseen
public class RunMed {
    //inst var
    private ALHeapMin bigVals;
    private ALHeapMax lilVals;
	
    //constructor
    public RunMed() {
	lilVals=new ALHeapMax();
	bigVals=new ALHeapMin();
    }

    public double getMedian() {
	if(bigVals.getSize()-lilVals.getSize()>0) {
	    return bigVals.peekMin();
	}
	else if(lilVals.getSize()-bigVals.getSize()>0) {
	    return lilVals.peekMax();
	}
	else {
	    return (lilVals.peekMax()+bigVals.peekMin())/2.0;
	}
    
    }
    public boolean add(Integer newVal) {

	if(bigVals.getSize()==0) {
	    bigVals.add(newVal);//adds to appropriate position
	    return true;
	}
	else if(lilVals.getSize()==0){//otherwise add to maxheap
	    lilVals.add(newVal);
	    return true;
	}
      
	if(newVal>bigVals.peekMin()){
	    bigVals.add(newVal);
	}
	else{
	    lilVals.add(newVal);
	}

	//now rebalance
	if(bigVals.getSize()-lilVals.getSize()>2) {//if there is a difference
	    //remove the thing in bigVals, add it to lilVals
	    lilVals.add(bigVals.removeMin());
	    return true;
	}
	else if(lilVals.getSize()-bigVals.getSize()>2) {//if there is a difference
	    //remove the thing in lilVals, add it to bigVals
	    bigVals.add(lilVals.removeMax());
	    return true;
	}
	else {//otherwise everything is good
	    return true;
	}

    }

    public static void main(String args[]){
	RunMed r = new RunMed();
	r.add(1);
	r.add(2);
	r.add(3);
	r.add(4);
	r.add(5);
	System.out.println(r.getMedian());
    }
  


}
