package LinkedList;

public class ShiftLinkedList {

    public static LinkedList shiftLinkedList(LinkedList head, int k) {
		int size = 0;
		LinkedList temp = head;
		while(temp != null){
			temp = temp.next;
			size++;
		}
		if(k<0){
			k=-k;
			if(k%size == 0) return head;
			k = k%size;
			k = size-k;
		}
		if(k == size || k==0) return head;
		if(k>size){
			if(k%size == 0) return head;
			k = k%size;
		}
		System.out.println(size);
		int op = size-k;
		LinkedList newHead = head;
		LinkedList oldTail = head;
		LinkedList newTail = head;
		while(oldTail.next != null){
			oldTail = oldTail.next;
			
		}
		while(op>1){
			newHead = newHead.next;
			newTail = newTail.next;
			op--;
		}
		
		newHead = newHead.next;
		newTail.next = null;
		oldTail.next = head;
    return newHead;
  }

  static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      next = null;
    }
  }
}