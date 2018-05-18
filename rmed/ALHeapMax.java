//Team bluemykolyk - Taaseen Ali, James Huang, Zane Wang
//APCS2 pd1
//HW50 -- Run Run Run
//2018-05-17

/*****************************************************
 * class ALHeapMax
 * Implements a max heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeapMax
{

    //instance vars
    private ArrayList<Integer> _heap;

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeapMax()
    {
	_heap = new ArrayList<Integer>();
    }



    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (more complicated, more fun)
     *****************************************************/
    public String toString()
    {
	String retStr = "[";
	for (Integer i: _heap) {
	    retStr += i + ", ";
	}
	if (retStr.length() > 2) {
	    retStr = retStr.substring(0, retStr.length() - 2);
	}
	retStr += "]";
	return retStr;
    }//O(?)


    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty()
    {
	return _heap.size() == 0;
    }//O(?)

public int getSize() {
	return _heap.size();
}
    /*****************************************************
     * Integer peekMax()
     * Returns max value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMax()
    {
	return _heap.get(0);
    }//O(?)


    /*****************************************************
     * add(Integer)
     * Inserts an element in the heap
     * Postcondition: Tree exhibits heap property.
     *****************************************************/
    public void add( Integer addVal )
    {
	_heap.add(addVal);
	int addPos = _heap.size() - 1;
	while (addVal > _heap.get((addPos - 1) / 2)) {
	    swap(addPos, (addPos - 1) / 2);
	    addPos = _heap.indexOf(addVal);
	}
    }//O(?)


    /*****************************************************
     * removeMax()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public Integer removeMax()
    {
	if (isEmpty()) {
	    System.out.println("No Integers left in heap");
	    return null;
	}
	Integer removed = _heap.get(0);
	swap(0,_heap.size() - 1);
	_heap.remove(_heap.size() - 1);
	if (_heap.size() >= 2) {
	    Integer swapped = _heap.get(0);
	    int maxPos = 0;
	    while (maxChildPos(maxPos) != -1) {
		swap(maxPos, maxChildPos(maxPos));
		maxPos = _heap.indexOf(swapped);
	    }
	}
	return removed;
    }//O(?)


    /*****************************************************
     * maxChildPos(int)  ---  helper fxn for removeMax()
     * Returns index of least child, or
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int maxChildPos( int pos )
    {
	if (2 * pos + 1 >= _heap.size()) {
	    return -1;
	}
	else if (2 * pos + 2 >= _heap.size()) {
	    return 2 * pos + 1;
	}
	else {
	    if (maxOf(_heap.get(2*pos + 1), _heap.get(2*pos + 2)) == _heap.get(2*pos + 1)) {
		return 2 * pos + 1;
	    }
	    else {
		return 2 * pos + 2;
	    }
	}
    }//O(?)


    //************ aux helper fxns ***************
    private Integer maxOf( Integer a, Integer b )
    {
	if ( a.compareTo(b) < 0 )
	    return b;
	else
	    return a;
    }

    //swap for an ArrayList
    private void swap( int pos1, int pos2 )
    {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );
    }
    //********************************************



    //main method for testing
    public static void main( String[] args )
    {
	  ALHeapMax pile = new ALHeapMax();

	  pile.add(2);
	  System.out.println(pile);
	  pile.add(4);
	  System.out.println(pile);
	  pile.add(6);
	  System.out.println(pile);
	  pile.add(8);
	  System.out.println(pile);
	  pile.add(10);
	  System.out.println(pile);
	  pile.add(1);
	  System.out.println(pile);
	  pile.add(3);
	  System.out.println(pile);
	  pile.add(5);
	  System.out.println(pile);
	  pile.add(7);
	  System.out.println(pile);
	  pile.add(9);
	  System.out.println(pile);

	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class ALHeap
