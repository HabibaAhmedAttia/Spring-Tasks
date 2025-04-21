public class Square implements Shape{

    private Draw2D draw2D;
    private Draw3D draw3D;

    public void setDraw2D(Draw2D draw2D) {
        this.draw2D = draw2D;
    }

    public void setDraw3D(Draw3D draw3D) {
        this.draw3D = draw3D;
    }

    @Override
    public void drawShape() {
        System.out.println("square");
        draw2D.draw();
        draw3D.draw();

    }
}
