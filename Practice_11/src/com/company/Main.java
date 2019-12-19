package com.company;

public class Main {

    public static void main(String[] args) {
        // task 1
        ArrayQueueModule arrM = new ArrayQueueModule();
        ArrayQueueModule.enqueue("line 1");
        ArrayQueueModule.enqueue("line 2");
        ArrayQueueModule.enqueue("line 3");
        System.out.println(ArrayQueueModule.dequeue().toString());
        System.out.println(ArrayQueueModule.dequeue().toString());
        ArrayQueueModule.enqueue("new line");
        System.out.println(ArrayQueueModule.dequeue().toString() + '\n');

        ArrayQueueADT arrADT = new ArrayQueueADT(10);
        ArrayQueueADT.enqueue(arrADT,5);
        ArrayQueueADT.enqueue(arrADT,4);
        ArrayQueueADT.enqueue(arrADT,3);
        System.out.println(ArrayQueueADT.dequeue(arrADT).toString());
        System.out.println(ArrayQueueADT.dequeue(arrADT).toString() + '\n');

        ArrayQueue arrQ = new ArrayQueue(10);
        arrQ.enqueue(1);
        arrQ.enqueue(2);
        System.out.println(arrQ.dequeue().toString());
        arrQ.enqueue(3);
        System.out.println(arrQ.dequeue().toString());
        System.out.println(arrQ.dequeue().toString() + '\n');


        // task 2
        LinkedQueue linQ = new LinkedQueue(10);
        linQ.enqueue("line 1");
        linQ.enqueue("line 2");
        linQ.enqueue("line 3");
        System.out.println(linQ.dequeue().toString());
        System.out.println(linQ.dequeue().toString());
        linQ.enqueue("new line");
        System.out.println(linQ.dequeue().toString() + '\n');
    }
}