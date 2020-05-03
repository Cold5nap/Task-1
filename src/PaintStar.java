import java.awt.*;

public class PaintStar {
    /*16.	Геометрическая фигура – звезда (вида https://ru.wikipedia.org/wiki/Звезда_(геометрия)).
Задается параметрами: координатами центра, внежним радиусом, внутренним радиусом и кол-вом "лучиков".
Реализовать методы: отображение, перемещение, массштабирование (см. задачу № 14).
В идеале (часть задания, которую можно не выполнять) сделать метод сохранения фигуры в svg-формате.
*/
    public static void main(String[] args) {
        FrameMain frameMain = new FrameMain();
        double zoomFactor = 1;
        double outRadius = 200;
        double inRadius = 100;
        double xCenter = outRadius;
        double yCenter = outRadius;
        frameMain.setSize((int)(outRadius*2*zoomFactor+40),(int)(zoomFactor*outRadius*2+40) );
        /**
         * Звезда задается в программе
         */
        Star star1 = new Star(xCenter, yCenter, outRadius, inRadius, 14);
        /**
         * 1)Ввод звезды с консоли(координата центра, внешний и внутренний радиус, кол-во лучей
         */
        /*
        Star starFromConsole = Star.enterStarFromConsole();
         */
        /**
         * 2)Отображение звезды через FrameMain(наследник JFrame)
         */
        DisplayStar ds = new DisplayStar(star1,zoomFactor);
        frameMain.add(ds);
        /**
         * 3)Перемещение звезды
         */
/*
        star1.changeStarCoordinates(100,50);
        frameMain.repaint();*/
        /**
         * 4)Маштабирование звезды
         */
    }
}
