/**
  Represent a list, implemented in a chain of nodes
 */

public class List_inChainOfNodes{
    private Node headReference;

    /**
      Construct an empty list
      The default constructor is fine:
      take zero arguments
      do nothing
     */

    /**
      @return the number of elements in this list
     */
    public int size() {
        // recursive approach seems more perspicuous
        if( headReference == null) return 0;
        else return size( headReference);
    }

    // recursively-called helper
    private int size( Node startingAt) {
        Node next = startingAt.getReferenceToNextNode();
        if( next == null) return 1;
        else return 1+ size( next);
    }


     /**
       @return a string representation of this list,
       format:
           # elements [element0,element1,element2,]
      */
    public String toString() {
        String stringRep = size() + " elements [";

        for( Node node = headReference
           ; node != null
           ; node = node.getReferenceToNextNode() )
            stringRep += node.getCargoReference() + ",";
        return stringRep + "]";
    }


    /**
      Append @value to the head of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean addAsHead( Object val) {
        headReference = new Node( val, headReference);
        return true;
     }
     
     public Node iterateNode( int index) {
         Node val;
         int i;
         for ( i = 0, val = headReference;
              i < index;
              i++, val = val.getReferenceToNextNode()) {
        }
        return val;
     }
     public Object get( int index){
        // pass-through request
        Node val = this.iterateNode(index);
        return val.getCargoReference();
    }
    
    public Object set(int index, Object val){
        if (index == 0) {
            headReference = new Node (val, this.iterateNode(index+1));
            return val;
        }
        Node currentNode = this.iterateNode(index-1);
        Node newNode = new Node(val, this.iterateNode(index+1));
        currentNode.setReferenceToNextNode(newNode);
        return val;
    }
    
    public boolean add(int index, Object val){
        if (index == 0) {
            this.addAsHead (val);
            return true;
        }
        Node newNode = new Node(val, this.iterateNode(index + 1));
        Node currentNode = this.iterateNode(index);
        currentNode.setReferenceToNextNode(newNode);
        return true;
   }
   
   public boolean remove(int index){
        if (index == 0) {
            headReference = this.iterateNode(index+1);
            return true;
        }
        Node prevNode = this.iterateNode(index-1);
        prevNode.setReferenceToNextNode(this.iterateNode(index+1));
        return true;
   }
}