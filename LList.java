public class LList implements List {

    private LLNode firstNode;
    private int size;

    public LList() {
	this("!");
    }

    public LList(String x) {
	firstNode = new LLNode(x);
	size = 1;
    }

    public boolean add(String x) {
	LLNode temp = new LLNode(firstNode.car(), firstNode.cdr());
	firstNode = new LLNode(x, temp);
	size++;
	return true;
    }

    public void add(int i, String x) {
	LLNode add = new LLNode(x);
	LLNode temp = firstNode;
	for(; i > 1; i--)
	    temp = temp.cdr();
	add.setCdr(temp.cdr());
	temp.setCdr(add);
	size++;
    }

    public String remove(int i) {
	LLNode temp = firstNode;
	for(; i > 1; i--)
	    temp = temp.cdr();
	String ret = temp.cdr().car();
	LLNode add = temp.cdr().cdr();
	temp.setCdr(add);
	size--;
	return ret;
    }

    public String get(int i) {
	LLNode temp = firstNode;
        for(; i > 0; i--)
	    temp = temp.cdr();
	return temp.car();
    }

    public String set(int i, String x) {
	LLNode temp = firstNode;
	for(; i > 0; i--)
	    temp = temp.cdr();
	String tmp = temp.car();
	temp.setCar(x);
	return tmp;
    }

    public int size() {
	return size;
    }

    public String toString() {
	LLNode temp = firstNode;
	String ret = "";
	ret += temp.car() + " -> ";
	while(temp.cdr() != null) {
	    temp = temp.cdr();
	    ret += temp.car() + " -> ";
	}
	return ret + "NULL";
    }

    public static void main(String[] args) {

	System.out.println("............ TESTING ............");
	LList nala = new LList("the");
	System.out.println(nala);
	System.out.println("size: " + nala.size());
	
	System.out.println("\n~~ testing add ~~");
	nala.add("quick");
	nala.add("brown");
	nala.add("fox");
	nala.add("jumps");
	nala.add("over");
	nala.add("the");
	nala.add("lazy");
	nala.add("dog");
	System.out.println(nala);
	System.out.println("size: " + nala.size());

	System.out.println("\n~~ testing get ~~");
	System.out.println("get(0): " + nala.get(0));
	System.out.println("get(1): " + nala.get(1));
	System.out.println("get(2): " + nala.get(2));

	System.out.println("\n~~ testing set ~~");
	nala.set(4, "!!!");
	System.out.println("set(5, !!!):\n" + nala);
	nala.set(4, "fox");
	System.out.println("set(5, fox):\n" + nala);

	System.out.println("\n~~ testing remove ~~");
	nala.remove(4);
	System.out.println("remove(4):\n" + nala);
	System.out.println("size: " + nala.size());

	System.out.println("\n~~ testing add ~~");
	nala.add(4, "jumps");
	System.out.println("add(4, jumps):\n" + nala);
	System.out.println("size: " + nala.size());
    }

}
