import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext container=new ClassPathXmlApplicationContext("applicationContext.xml");
        Square square1 = container.getBean("square1", Square.class);
        Circle circle1=container.getBean("circle1",Circle.class);
        double input=3;
        circle1.getArea(input);
        square1.getArea(input);
    }
}