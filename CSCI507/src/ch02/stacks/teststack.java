package ch02.stacks;


public class teststack {
    public static void main(String[] args) {
        ArrayBoundedStack<Integer> test = new ArrayBoundedStack<>(10);
        test.push(1);
        test.push(3);
        test.push(4);
        test.push(1452);
        test.push(10);
        test.push(122);
        test.push(17);


        System.out.println(test);
        System.out.println(test.size());

        test.popSome(3);
        System.out.println(test);

        System.out.println(test.swapStart());
        System.out.println(test);

        System.out.println(test.poptop());
        System.out.println(test);
    }

}
