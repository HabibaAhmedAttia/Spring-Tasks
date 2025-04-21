import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Circle circle=context.getBean("circleBean",Circle.class);
        circle.drawShape();
        Square square=context.getBean("squareBean",Square.class);
        square.drawShape();
    }
}