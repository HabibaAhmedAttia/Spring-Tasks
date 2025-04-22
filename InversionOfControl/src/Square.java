public class Square implements Shape{
    private double length;

    public Square() {
    }

    public Square(double length) {
        this.length = length;
    }

    @Override
    public void getArea() {
        System.out.println("The area of Square is "+(length*length));
    }

    public void getArea(double length) {
        System.out.println("The area of Square is "+(length*length));
    }
}
