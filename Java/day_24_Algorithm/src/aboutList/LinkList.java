package aboutList;

class Node<T>{
	private T item;
	private Node<T> next;
	
	public Node(T item,Node<T> next){
		this.item = item;
		this.next = next;
	}

	/* SET & GET */
	
	public T getItem() {return item;}

	public void setItem(T item) {this.item = item;}

	public Node<T> getNext() {return next;}

	public void setNext(Node<T> next) {this.next = next;}
	
	/* SET & GET */
}

public class LinkList <E>{
	private Node head;
	private int size;
	
	public void LinkList(){
		head=null;
		size=0;
	}
	
	public int search(E target){
		Node p = head;
		for(int i=0;i<size;i++){
			if(target.equals(p.getItem())){
				return -1;
			}
			p=p.getNext();
		}
		return -1;
	}
	
	public void insertAfter(E newItem, Node p){
		p.setNext(new Node(newItem, p.getNext())); // ���ο� Node�� �߰��ϴµ� ���ο� �����۰� p�� setNext�� 
		size++;																			// ���ο� �����۰� p�� ���� �ּҸ� �־��ش�
	}
	
	public void insertFront(E newItem){
		head = new Node(newItem, head);
		size++;
		
	}
	
	public void deleteFront(){
		head=head.getNext();
		size--;
	}
	
	public void deleteAfter(Node p){
		Node t = p.getNext();
		p.setNext(t.getNext());
		t.setNext(null);
		size--;
	}
}