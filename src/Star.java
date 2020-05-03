import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.util.Scanner;

public class Star {

    private static final double PI = Math.PI;
    private double x0;//Координаты центра
    private double y0;
    private double outerRadius;//Внешний радиус
    private double internalRadius;//Внутренний радиус
    private int numberOfRays;//Кол-во лучей

    public Star(double x0, double y0, double outerRadius, double internalRadius, int numberOfRays) {
        this.x0 = x0;
        this.y0 = y0;
        this.outerRadius = outerRadius;
        this.internalRadius = internalRadius;
        this.numberOfRays = numberOfRays;
    }

    public static Star enterStarFromConsole() {
        System.out.println("Введите координаты центра, внешний радиус, внутренний радиус и кол-во \"лучиков\":");
        Scanner scanner = new Scanner(System.in);
        double x0 = scanner.nextDouble();
        double y0 = scanner.nextDouble();
        double outerRadius = scanner.nextDouble();
        double internalRadius = scanner.nextDouble();
        int numberOfRays = scanner.nextInt();
        return new Star(x0, y0, outerRadius, internalRadius, numberOfRays);
    }

    public void changeStarCoordinates(double deltaX, double deltaY) {
        setX0(deltaX + x0);
        setY0(deltaY + y0);
    }

    public void setX0(double x) {
        x0 = x;
    }

    public void setY0(double y) {
        y0 = y;
    }

    public int getNumberOfRays() {
        return numberOfRays;
    }

    //координата внешнего луча
    public double getXOfExternalRay(int rayNumber) {
        return x0 + outerRadius * Math.cos(rayNumber * 2 * PI / numberOfRays);
    }

    public double getYOfExternalRay(int rayNumber) {
        return y0 + outerRadius * Math.sin(rayNumber * 2 * PI / numberOfRays);
    }

    public double getXOfInternalRay(int rayNumber) {
        return x0 + internalRadius * Math.cos(rayNumber * 2 * PI / numberOfRays + PI / numberOfRays);
    }

    public double getYOfInternalRay(int rayNumber) {
        return y0 + internalRadius * Math.sin(rayNumber * 2 * PI / numberOfRays + PI / numberOfRays);
    }
}

class DisplayStar extends JPanel {

    private double zoomFactor ;
    private Star st;

    public DisplayStar(Star star, double zoomFactor) {
        this.st = star;
        this.zoomFactor = zoomFactor;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D gr2d = (Graphics2D) g;
        gr2d.scale(zoomFactor,zoomFactor);
        //добавление сглаживания
        gr2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gr2d.setPaint(Color.ORANGE);
        //толщина линии
        BasicStroke p = new BasicStroke(2);
        gr2d.setStroke(p);
        Star star = st;
        for (int n = 0; n < star.getNumberOfRays(); n++) {
            int xOuterRay = (int) star.getXOfExternalRay(n);
            int yOuterRay = (int) star.getYOfExternalRay(n);
            int xInnerRay = (int) star.getXOfInternalRay(n);
            int yInnerRay = (int) star.getYOfInternalRay(n);
            int xOuterRayNext = (int) star.getXOfExternalRay(n + 1);
            int yOuterRayNext = (int) star.getYOfExternalRay(n + 1);
            gr2d.drawLine(xOuterRay, yOuterRay, xInnerRay, yInnerRay);
            gr2d.drawLine(xOuterRayNext, yOuterRayNext, xInnerRay, yInnerRay);
        }
    }
}

