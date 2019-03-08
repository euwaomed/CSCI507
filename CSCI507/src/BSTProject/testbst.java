package BSTProject;

public class testbst
{
    public static void main (String [] args)
    {
        BinarySearchTree<String> test = new BinarySearchTree<String>();
        test.add("c");
        test.add("c");
        test.add("b");

        System.out.println(test.leafCount());
        System.out.println(test.oneChild());
        System.out.println("Height of tree is : " +
                test.height(test.root));


        BinarySearchTree<Integer> test1 = new BinarySearchTree<Integer>();
        test1.add(10);
        test1.add(5);
        test1.add(20);

        System.out.println(test1.leafCount());
        System.out.println(test1.oneChild());
        System.out.println("Height of tree is : " +
                test1.height(test1.root));
    }
}
