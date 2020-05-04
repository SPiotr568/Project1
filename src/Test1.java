import java.util.*;

public class Test1 {

	public static void main(String[] args) {
		System.out.println("Kolejka FIFO:\n");
		FIFO<Integer> s = new FIFO<Integer>();
		s.addVal(6);
		s.addVal(7);
		s.addVal(89);
		s.addVal(2);
		s.showIterator();
		System.out.println(s);
		System.out.println("Zdjecie elementow z kolejki: ");
		System.out.println(s.getVal());
		System.out.println(s.getVal());
		System.out.println(s);
		s.showIterator();
		int size=s.getSize();
        for(int i=0; i<size+1; i++) {
            try {
                System.out.println(s.getVal());
            }catch(EmptyStackException e){
                System.out.println(e);
                System.exit(0);
            }
        }
	}
}

class FIFO<T>{
	private LinkedList<T> fifo;
    public FIFO() {
    	fifo = new LinkedList<T>();
    }
    
    public void addVal(T val) {
        fifo.add(val);
    }
    
    public T getVal() throws EmptyStackException {
        if(fifo.isEmpty())
            throw new EmptyStackException();
        else
            return fifo.pollFirst();
    }
    
    public int getSize() {
        return fifo.size();
    }
    
    public void showIterator() {
    	Iterator it=fifo.iterator();
    	System.out.print("FIFO z uzyciem iteratora: ");
    	while(it.hasNext()) {
			Object element = it.next();
	        System.out.print(element + " ");
		}
    	System.out.print("\n");
    }
    
    public String toString() {
        String temp="FIFO: ";
        for(T val: fifo) {
            temp+=val+" ";
        }
        return temp;
    }
}