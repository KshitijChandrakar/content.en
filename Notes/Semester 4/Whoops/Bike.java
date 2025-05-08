 class Vehicle{
 int speed=50; // parent instance variable
 }

 class Bike extends Vehicle{
 int speed=100; // child instance variable

void display(){
 System.out.println(speed);
}
public static void main(String args[]){
Bike b=new Bike();
b.display();
}
}
