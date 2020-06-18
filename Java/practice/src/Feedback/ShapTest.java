package Feedback;

abstract class Shape{
 abstract double area();
 abstract double circumference();  //���� �ѷ�
}

class Rectangle extends Shape{
 
 private int width, height;
 /*-----------------------------------------------------------1�� -------------*/
 public Rectangle(int width, int height) {
  super();
  this.width = width;
  this.height = height;
 }
 /*-----------------------------------------------------------2�� -------------*/
 @Override
 double area() {
  double result = width * height;
  return result;
 }
 /*-----------------------------------------------------------3�� -------------*/
 @Override
 double circumference() {
  double result = 2*(width + height);
  return result;
 }

 
}
class Circle extends Shape{
 private int r;
 
 Circle(int r){
  this.r=r;
 }
 double area(){
  return Math.PI * r * r;
  
 }
 double circumference(){
  return Math.PI * r * 2;
 }
}

public class ShapTest {
 public static void main(String[] args) {
 
  Shape s1 = new Rectangle(4, 5);
  Shape s2 = new Circle(5);
  
  System.out.println("�簢���� �ʺ� = " + s1.area());
  System.out.println("�簢���� �ѷ� = " + s1.circumference());
  System.out.println("���� �ʺ� = " + s2.area());
  System.out.println("���� �ѷ� = " + s2.circumference());
 }
}