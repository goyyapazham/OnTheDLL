// Manish Saha
// APCS2 pd05
// HW13: LoList, LoLit
// 2016-03-15

public class LLNode {
    private String _cargo;
    private LLNode _nextNode;

    // constructor
    public LLNode( String value, LLNode next ) {
	_cargo = value;
	_nextNode = next;
    }

    // accessors & modifiers
    public String getCargo() {
	return _cargo;
    }

    public String setCargo( String newCargo ) {
	String old = getCargo();
	_cargo = newCargo;
	return old;
    }

    public LLNode getNext() {
	return _nextNode;
    }

    public LLNode setNext( LLNode newNext ) {
	LLNode old = getNext();
	_nextNode = newNext;
	return old;
    }

}
