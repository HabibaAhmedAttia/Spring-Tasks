public class Circle implements Shape{
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }


    @Override
    public void getArea() {
        System.out.println("The area of circle is "+(Math.PI*radius*radius));
    }

    public void getArea(double radius) {
        System.out.println("The area of circle is "+(Math.PI*radius*radius));

    }

}
