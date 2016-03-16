// Team : Manish Saha, Nalanda Sharadjaya
// APCS2 pd05
// HW14 -- On the DLL
// 2016-03-16

public class LList implements List {
    private LLNode _head;
    private int _size;

    public LList( ) {
	_head = null;
	_size = 0;
    }

    public boolean add( String newVal ) {
        LLNode tmp = new LLNode( newVal, _head );
	_head = tmp;
	_size++;
	return true;
    }

    public void add( int index, String newVal ) {
	if ( index < 0 || index > size() )
	    throw new IndexOutOfBoundsException();
	
	LLNode newNode; // node with newVal
	LLNode tmp = _head; // alias

	if ( index == 0 ) {
	    newNode = new LLNode( newVal, tmp );
	    _head = newNode;
	}

	else {
	    newNode = new LLNode( newVal, null );
	    for ( int i = 0; i < index - 1; i++ ) {
		tmp = tmp.getNext(); // stop slicing when you reach target index
	    }

	    newNode.setNext( tmp.getNext() ); // set new node's cdr to remainder of alias
	    tmp.setNext( newNode );	 // set cdr from target index to new node
	}
	_size++;
    }

    public String remove( int index ) {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	String old;
	LLNode tmp = _head;

	if ( index == 0 ) {
	    old = tmp.getCargo();
	    tmp = tmp.getNext();
	    _head = tmp;
	}
	
	else {
	    for ( int i = 0; i < index - 1; i++ ) {
		tmp = tmp.getNext();
	    }

	    old = tmp.getNext().getCargo();
	    tmp.setNext( tmp.getNext().getNext() );
	}

	return old;
    }

    public String get( int index ) {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	String retVal;
	LLNode tmp = _head;

	for( int i = 0; i < index; i++ )
	    tmp = tmp.getNext();

	retVal = tmp.getCargo();
	return retVal;
    }

    public String set( int index, String newVal ) {
        if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	LLNode tmp = _head;

	for( int i = 0; i < index; i++ )
	    tmp = tmp.getNext();

	String oldVal = tmp.setCargo( newVal );
	
	return oldVal;
    }
    
    public int size() {
        return _size;
    }
    
    public String toString() { 
	String retStr = "HEAD->";
	LLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }

    public static void main( String[] args ) {

	LList james = new LList();

	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	System.out.println( "2nd item is: " + james.get(1) );

	james.set( 1, "got" );
	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

	System.out.println( james );
	System.out.println();
	
	james.add( 0, "foo" );
	System.out.println( james );
	System.out.println();

	james.add( 2, "poo" );
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
	
    }

}
