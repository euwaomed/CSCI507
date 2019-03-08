package RectangleProject;

public class test1
{
    public static void main(String [] args)
    {
        Rectangle r1 = new Rectangle(5,10);
        Rectangle r2 = new Rectangle(5, 10);
        Rectangle r3 = new Rectangle(4, 9);


        /**System.out.println(r1.equals(r2));
        System.out.println(r1.equals(r3));*/
        if(r1 == r2)
            System.out.print("Similar and Congruent");
        else
            System.out.print("They are not similar and Congruent");



        if(r1 == r3)
            System.out.print("Similar and Congruent");
        else
            System.out.print("They are not similar and Congruent");


    }
}
