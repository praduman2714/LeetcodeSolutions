class MyCircularQueue {
    
    int[] arr; int front, rear;

    public MyCircularQueue(int k) {
        arr = new int[k];
        front = -1;
        rear = -1;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        if(front == -1){
            front++;
            rear ++;
            arr[rear] = value;
            return true;
        }
        rear = (rear + 1)% arr.length;
        arr[rear] = value;
        return true;
    }
    
    public boolean deQueue() {
        
        if(isEmpty()) return false;
        if(rear == front){
            front = -1;
            rear = -1;
            return true;
        }
        
        front = (front+1)%arr.length;
        return true;
        
    }
    
    public int Front() {
        if(front == -1) return -1;
        return arr[front];
    }
    
    public int Rear() {
        if(rear == -1) return -1;
        return arr[rear];
    }
    
    public boolean isEmpty() {
        return front == -1;
    }
    
    private int size(){
        if(front == rear) return 1;
        if(rear > front) return rear - front +1;
        return arr.length - (front - rear) + 1;
    }
    
    public boolean isFull() {
        return front!=-1 && (rear + 1) % arr.length ==front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */