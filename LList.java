// Team nodelanda: Manish Saha, Nalanda Sharadjaya
// APCS2 pd05
// HW14b -- On the DLL
// 2016-03-16

public class LList<T> implements List<T> {
    private DLLNode<T> _head;
    private int _size;

    public LList( ) {
	_head = null;
	_size = 0;
    }

    public boolean add( T newVal ) {
	add( size(), newVal );
	return true;
    }

    public void add( int index, T newVal ) {
	if ( index < 0 )
	    throw new IndexOutOfBoundsException();
	
	DLLNode<T> newNode; // node with newVal
	DLLNode<T> tmp = _head; // alias
	if ( index == 0 ) {
	    tmp = new DLLNode<T>( null, newVal, _head );
	    if ( _head != null ) {
		_head.setPrev( tmp );
	    }
	    _head = tmp;
	}

	else {
	    newNode = new DLLNode<T>( null, newVal, null );
	    
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
	}
	_size++;
    }

    public T remove( int index ) {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	T old;
	DLLNode<T> tmp = _head;

	if ( index == 0 ) {
	    old = tmp.getCargo();
	    tmp = tmp.getNext();

	    if ( tmp != null )
		tmp.setPrev( null );
	    
	    _head = tmp;
	}

	else {
	    for ( int i = 0; i < index; i++ ) {
		tmp = tmp.getNext();
	    }
	    old = tmp.getCargo();

	    DLLNode<T> prev = tmp.getPrev();
	    DLLNode<T> next = tmp.getNext();
	    
	    if ( prev != null ) {
		tmp.getPrev().setNext( next );
	    }
	    if ( next != null ) {
		tmp.getNext().setPrev( prev );
	    }
	}
	_size--;
	return old;
    }

    public T get( int index ) {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	T retVal;
	DLLNode<T> tmp = _head;

	for( int i = 0; i < index; i++ )
	    tmp = tmp.getNext();

	retVal = tmp.getCargo();
	return retVal;
    }

    public T set( int index, T newVal ) {
        if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	DLLNode<T> tmp = _head;

	for( int i = 0; i < index; i++ )
	    tmp = tmp.getNext();

	T oldVal = tmp.setCargo( newVal );
	
	return oldVal;
    }
    
    public int size() {
        return _size;
    }
    
    public String toString() { 
	String retStr = "NULL<-HEAD->";
	DLLNode<T> tmp = _head; //init tr
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
	
	System.out.println( james.remove( 5 ) );
	System.out.println( james );
	System.out.println();

	System.out.println( james.remove( 2 ) );
	System.out.println( james );
	System.out.println();

	System.out.println( james.remove( 1 ) );
	System.out.println( james );
	System.out.println();

	System.out.println( james.remove( 1 ) );
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
