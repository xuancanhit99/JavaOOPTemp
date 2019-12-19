package com.company;

class Ball {
    private double x = 0.0;
    private double y = 0.0;

    public Ball() {}

    public Ball(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setXY(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void move( double xDisp, double yDisp){
        x+=xDisp;
        y+=yDisp;
    }

    @Override
    public String toString() {
        return "Ball ("+this.x+", "+this.y+")";
    }
}

public class TestBall {

    public static void main(String[] args) {
        Ball b = new Ball(100, 100);
        System.out.println(b);

        b.move(30, 15);
        System.out.println(b);

        b.setXY(10.0,20.0);
        System.out.println(b);
    }
}
