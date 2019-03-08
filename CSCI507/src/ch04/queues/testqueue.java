package ch04.queues;

public class testqueue {
    public static void main(String[] args)
    {
        ArrayBoundedQueue<Integer> test = new ArrayBoundedQueue<Integer>(10);
        test.enqueue(1);
        test.enqueue(3);
        test.enqueue(4);
        test.enqueue(1452);
        test.enqueue(10);
        test.enqueue(122);
        test.enqueue(17);

        System.out.println(test);
        System.out.println(test.space());

        test.remove(3);
        System.out.println(test);

        System.out.println(test.swapEnds());
        System.out.println(test);

        System.out.println(test.swapStart());
        System.out.println(test);
    }
}
