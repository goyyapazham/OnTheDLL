// Team : Manish Saha, Nalanda Sharadjaya
// APCS2 pd05
// HW14 -- On the DLL
// 2016-03-16

public class DLLNode {
    private LLNode _prevNode;
    private String _cargo;
    private LLNode _nextNode;

    // constructor
    public DLLNode( DLLNode prev, String value, DLLNode next ) {
	_prevNode = prev;
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

    public DLLNode getNext() {
	return _nextNode;
    }

    public DLLNode setNext( LLNode newNext ) {
	DLLNode old = getNext();
	_nextNode = newNext;
	return old;
    }

    public DLLNode getPrev() {
	return _prevNode;
    }

    public DLLNode setPrev(DLLNode newPrev) {
	DLLNode old = getPrev();
	_prevNode = newPrev;
	return old;
    }

}
