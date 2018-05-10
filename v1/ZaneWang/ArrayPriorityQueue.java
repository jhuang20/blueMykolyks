// Zane Wang
// APCS2 pd1
// HW46 -- Arrr, There Be Priorities Here Matey
// 2018-05-10 R

import java.util.ArrayList;

public class ArrayPriorityQueue {
    private int _size;
    private ArrayList<String> _queuer;

    public void ArrayPriorityQueue() {
	_size = 0;
	_queuer = new ArrayList<String>();
    }

    public void add(String input) {
	_queuer.add( input);
	_size++;
    }

    public boolean isEmpty() {
	return (_size == 0);
    }

    public String peekMin() {
	String min = _queuer.get(0);
	for (String str : _queuer) {
	    if (str.compareTo(min) < 0) {
		min = str;
	    }
	}
	return min;
    }

    public String removeMin() {
	String retStr = peekMin();
	for (int i = 0; i < _queuer.size(); i++) {
	    if (i == _queuer.size() - 1) {
		_queuer.set(i,null);
	    }
	    else if (i >= _queuer.indexOf(retStr)) {
		_queuer.set(i,_queuer.get(i + 1));
	    }
	}
	_size--;
	return retStr;
    }

    public static void main(String[] args) {
	ArrayPriorityQueue apq = new ArrayPriorityQueue();

	System.out.println(apq.isEmpty());

	apq.add("hello");
	apq.add("you");
	apq.add("are");
	apq.add("a");
	apq.add("goose");

	System.out.println(apq.peekMin());
	System.out.println(apq.removeMin());

	System.out.println(apq.peekMin());
	System.out.println(apq.removeMin());

	System.out.println(apq.peekMin());
	System.out.println(apq.removeMin());

	System.out.println(apq.peekMin());
	System.out.println(apq.removeMin());

	System.out.println(apq.peekMin());
	System.out.println(apq.removeMin());
    }
}

