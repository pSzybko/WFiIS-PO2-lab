public class LinkedList{
    public static void main(String[] args){
        int[] tab = new int[10];
        for(int i=0; i<10; i++)
            tab[i]=i;
        LinkedList lista = new LinkedList(tab);
        System.out.print("lista: ");
        lista.display();
        int[] tab2 = new int[3];
        for(int i=0; i<3; i++)
            tab2[i]=20+i;
        LinkedList lista2 = new LinkedList(tab2);
        System.out.print("lista2: ");
        lista2.display();
        lista.merge(lista2);
        System.out.print("lista + lista2: ");
        lista.display();
        System.out.print("usuwanie heada: ");
        lista.remove();
        lista.display();
        System.out.println("Czy polaczona lista zawiera wartosc 0 : "+lista.contains(0));
        System.out.println("Czy polaczona lista zawiera wartosc 22 : "+lista.contains(22));
        System.out.println("Czy polaczona lista zawiera wartosc 40 : "+lista.contains(40));
        lista.clear();
        lista.display();
    }
    private Node head;

    LinkedList(int[] arr){
        if(arr.length>0)
            for(int i : arr)
                this.add(i);
    }

    public void add(int v){
        if(head==null){
            head=new Node(v);
            return;
        }
        Node ptr=head;
        while(ptr.getNext()!=null)
            ptr=ptr.getNext();
        ptr.setNext(new Node(v));
    }
    public Node getHead(){
        return this.head;
    }
    public void display(){
        if(head==null){
            System.out.println("Lista jest pusta!!!"); 
            return;
        }
        Node ptr=head;
        while(ptr!=null){
            System.out.print(ptr+"\t");
            ptr=ptr.getNext();
        }
        System.out.println();
    }
    public void remove(){
        if(head==null){
            return;
        }
        head=head.getNext();
    }
    public void merge(LinkedList other){
        if(other==null) return;
        if(this.head==null){
            this.head=other.head;
            return;
        }
        Node ptr=this.head;
        while(ptr.getNext()!=null) ptr=ptr.getNext();
        ptr.setNext(other.head);
        other=null;
    }
    public void clear(){
        System.out.println("wyczyszczenie listy");
        while(head!=null)
            this.remove();
    }
    public boolean contains(int v){
        if(this.head==null) return false;
        Node ptr=this.head;
        while(ptr!=null)
            if(ptr.getValue()==v)
                return true;
            else ptr=ptr.getNext();
        return false;
    }
}

class Node{
    private int value;
    private Node next=null;

    Node(int value){
        this.value=value;
    }
    public void setNext(Node next){
        this.next=next;
    }
    public Node getNext(){
        return this.next;
    }
    public int getValue(){
        return this.value;
    }
    @Override
    public String toString(){
        return ""+this.value;
    }
}