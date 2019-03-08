package RectangleProject;
public class Rectangle implements FigureInterface
{
  protected double length, width;

  public Rectangle(double length, double width)
  {
    this.length = length;
    this.width = width;
  }    
       
  public double perimeter()
  // Returns perimeter of this figure.
  {
    return(2 * (length + width));
  }
   
  public double area()
  // Returns area of this figure.
  {
    return(length * width);
  }

  public boolean equals(Rectangle r)
  {
      if(r.length != this.length && r.width != this.width)
          return false;

      if(r.perimeter() != this.perimeter())
          return false;

      if(r.area() != this.area())
          return false;

      return  true;
  }
}
