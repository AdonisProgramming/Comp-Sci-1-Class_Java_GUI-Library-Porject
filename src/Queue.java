// First in last out

//this class is used to implement a Queue data structure in a static manner
public class Queue {

    private Book [] Queue;
    public static final int MAX =5;
    private int numOfElements;
    private int head; // front pointer
    private int tail; // rear pointer

    public Queue(){
    }

    public Queue(Book [] Queue, int head, int tail){
        this.Queue = Queue;
        this.head = head;
        this.tail = tail;
    }
/*
 * Add an element to a Queue
 *
 * @params: Book [] Queue, Book element)
 * return: NONE
 */

    public void enqueue(Book [] Queue, Book element){
        if (Queue.length == MAX){
            System.out.println("Queue is full");
        }else{
            tail++;
            Queue[tail] = element;
            numOfElements++;
        }
    }
    /*
     * Remove element from a Queue
     *
     * @params: Book [] Queue, Book element)
     * return: NONE
     */
    public void dequeue(Book [] Queue, Book element){
        if (Queue.length == 0){
            System.out.println("Queue is empty");
        }else{
            head++;
            Queue[head] = null;
            numOfElements--;
        }
    }

    public int getNumOfElements() {
        return numOfElements;
    }

    public void setNumOfElements(int numOfElements) {
        this.numOfElements = numOfElements;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }
}