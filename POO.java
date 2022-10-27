
public class POO {
    int y;
    int x;
    public POO(int x, int y){
        this.x = x;
        this.y = y;
    }
    private int mult(){
        return x*y;
    }
    private double div(){
        return y/x;
    }
    private int sum(){
        return x+y;
    }
    private int res(){
        return x-7;
    }
    public static void main(String[] args) {
        POO obj = new POO(12,24);
        System.out.println("x ->"+obj.x);
        System.out.println("y ->"+obj.y);
        System.out.println("--------------");
        System.out.println("Multiplicación ->"+obj.mult());
        System.out.println("División ->"+obj.div());
        System.out.println("Suma ->"+obj.sum());
        System.out.println("Resta ->"+obj.res());
        
    }
}
