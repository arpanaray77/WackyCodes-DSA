class MyCircularQueue {

    int front;
    int rear;
    int size;
    int queue[]; //queue using arrays
    
    public MyCircularQueue(int k) {
        size=k;
        front=0;
        rear=0;
        queue=new int[k];
        Arrays.fill(queue,-1);
        
    }
    
    public boolean enQueue(int value) {
        
        if(front==rear && queue[rear]!= -1) //full queue
            return false;
        
        queue[rear]=value;
        if(rear==size-1) //if rear was at last position
             rear=0;
        else
            rear++;
        
        return true;
    }
    
    public boolean deQueue() {
        
        if(queue[front]==-1)
             return false;
        
        queue[front]=-1;
        if(front==size-1) //if front was at last position
            front=0;
        else
            front++;
        return true;
    }
    
    public int Front() {
        
        return queue[front];
        
    }
    
    public int Rear() {
        
         return rear==0?queue[size-1]:queue[rear-1]; //if rear at 0th position return last item of array
    }
    
    public boolean isEmpty() {
        if(front==rear && queue[rear]==-1) //empty queue
            return true;
        return false;       
    }
    
    public boolean isFull() {
         if(front==rear && queue[rear]!=-1) //full queue
            return true;
        return false;       
    }
}