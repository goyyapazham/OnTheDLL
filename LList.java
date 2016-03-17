// Team nodelanda: Manish Saha, Nalanda Sharadjaya
// APCS2 pd05
// HW14b -- On the DLL
// 2016-03-16

public class LList implements List {
    private DLLNode _head;
    private int _size;

    public LList( ) {
	_head = null;
	_size = 0;
    }

    public boolean add( String newVal ) {
        DLLNode tmp = new DLLNode( null, newVal, _head );
	if ( _head != null ) {
	    _head.setPrev( tmp );
	}
        _head = tmp;
	_size++;
	return true;
    }

    public void add( int index, String newVal ) {
	if ( index < 0 )
	    throw new IndexOutOfBoundsException();
	
	DLLNode newNode; // node with newVal
	DLLNode tmp = _head; // alias
	if ( index == 0 ) {
	    add( newVal );
	}

	else {
	    newNode = new DLLNode( null, newVal, null );
	    
	    if ( index >= size() ) {
	        for ( int i = 0; i < size() - 1; i++ ) {
		    tmp = tmp.getNext();
		}

		tmp.setNext( newNode );
		newNode.setPrev( tmp );
	    }

	    else {
		for ( int i = 0; i < index; i++ ) {
		    tmp = tmp.getNext(); // stop slicing when you reach target index
		}
	    
		tmp.getPrev().setNext( newNode ); // point tmp_prev's next to newNode
		newNode.setPrev( tmp.getPrev() ); // make newNode's prev point to tmp_prev
		tmp.setPrev( newNode ); // set tmp's prev to newNode
		newNode.setNext( tmp ); // set newNode's next to tmp
	    }
	    _size++;
	}
    }

    public String remove( int index ) {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	String old;
	DLLNode tmp = _head;

	if ( index == 0 ) {
	    old = tmp.getCargo();
	    tmp = tmp.getNext();
	    _head = tmp;
	    return old;
	}

	for ( int i = 0; i < index; i++ ) {
	    tmp = tmp.getNext();
	}
	old = tmp.getCargo();

	if ( index < size() - 1 ) {
	    tmp.getPrev().setNext( tmp.getNext() );
	    tmp.getNext().setPrev( tmp.getPrev() );
	}

	else {
	    tmp.getPrev().setNext( new DLLNode( null, null, null ) );
	}

	return old;
    }

    public String get( int index ) {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	String retVal;
	DLLNode tmp = _head;

	for( int i = 0; i < index; i++ )
	    tmp = tmp.getNext();

	retVal = tmp.getCargo();
	return retVal;
    }

    public String set( int index, String newVal ) {
        if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	DLLNode tmp = _head;

	for( int i = 0; i < index; i++ )
	    tmp = tmp.getNext();

	String oldVal = tmp.setCargo( newVal );
	
	return oldVal;
    }
    
    public int size() {
        return _size;
    }
    
    public String toString() { 
	String retStr = "NULL<-HEAD";
	DLLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += "<-" + tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }

    public static void main( String[] args ) {

	LList james = new LList();

	System.out.println( james );
	System.out.println( "size: " + james.size() );
	System.out.println();

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );
	System.out.println();

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );
	System.out.println();

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );
	System.out.println();

	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );
	System.out.println();

	System.out.println( "2nd item is: " + james.get(1) );
	System.out.println();

	james.set( 1, "got" );
	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
	System.out.println();

	System.out.println( james );
	System.out.println();
	
	james.add( 0, "foo" );
	System.out.println( james );
	System.out.println();

	james.add( 5, "poo" );
	System.out.println( james );
	System.out.println();
	
	System.out.println( james.remove( 0 ) );
	System.out.println( james );
	System.out.println();

	System.out.println( james.remove( 2 ) );
	System.out.println( james );
	System.out.println();

	System.out.println( james.remove( 1 ) );
	System.out.println( james );
	System.out.println();

	System.out.println( james.remove( 0 ) );
	System.out.println( james );
	System.out.println();

	System.out.println( james.remove( 1 ) );
	System.out.println( james );
	System.out.println();

	System.out.println( james.remove( 0 ) );
	System.out.println( james );
	System.out.println();
	
    }

}
