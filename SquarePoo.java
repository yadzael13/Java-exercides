import java.util.*;
import java.util.stream.Stream;

public class SquarePoo {
    List<List<Integer>> cube = new ArrayList<>();
    int size;
    int dimention;
    int number_to_magic;
    int current_sum;
//--------------------  CONSTRUCTOR  -----------------------    
     public SquarePoo(List<List<Integer>> cube){
        this.cube = cube;
     }
//--------------------  GETTERS AND SETTERS  -----------------------    

public int getSize() {
    return size;
}
public void setSize(int size) {
    this.size = size;
}

public int getDimention() {
    return dimention;
}
public void setDimention(int dimention) {
    this.dimention = dimention;
}

public int getNumber_to_magic() {
    int aux = factorialSum()/size;
    return aux;
}
//--------------------  METHODS  -----------------------
     //-- Funcion para obtener el factorial sumatorio
    //-- Function to get the factorial sum
    public int factorialSum(){
        int i = 1;
        int facsum = 0;
        while(i <= dimention){
            facsum += i;
            i++;
        }
        return facsum;
    }
    //-- Funcion para verificar si es cubo
    //-- Function to verify if is a cube
    public boolean is_a_cube(){
        int final_length = cube.size();
        for (List<Integer> l1 : cube) {
            if(!(l1.size()==final_length)){
                return false;
            }
        }
        return true;
    }
//--------------------  Main  -----------------------
    public static void main(String[] args) {
        List<List<Integer>> square = new ArrayList<>();
        square.add(Arrays.asList(4,8,2));
        square.add(Arrays.asList(4,5,7));
        square.add(Arrays.asList(6,1,6));

        formingMagicSquare(square);
        
        
    }

//--------------------  The other methods  -----------------------

    public static int formingMagicSquare(List<List<Integer>> square) {
    SquarePoo cube = new SquarePoo(square);
    if(cube.is_a_cube()){
        int s = square.size();
        cube.setSize(s);
        int d = s*s;
        cube.setDimention(d);

        System.out.println(cube.getSize());
        System.out.println(cube.getDimention());
        System.out.println(cube.getNumber_to_magic());
    
        // List<Integer> aux = new ArrayList<>();
        // aux.add(0);
        // aux.add(1);
        // System.out.println(cube.cube);
        // System.out.println(cube.missingList());
        // cube.modify_el(aux, 9);
        System.out.println(cube.cube);
        System.out.println(cube.missingList());
        List<List<Integer>> list_of_all = cube.get_p_t();
        List<List<Integer>> n_lis = Stream.concat(cube.cube.stream(),list_of_all.stream()).toList();
        System.out.println(n_lis);
        System.out.println(total_arr_sum(n_lis));
        return 1;

    }else{
        System.out.println("Not a cube");
        return 0;
    }
    }
    //-- Funcion para obtener la suma de todas las lineas
    //-- Function to get the total sum of all arrays
    public static List<Integer> total_arr_sum(List<List<Integer>> s){
        List<Integer> ret = new ArrayList<>();
        for(List<Integer> lis : s){
            int aux = arraySum(lis);
            ret.add(aux);
        }
        return ret;
     }
 
     //-- Funcion para obtener la suma de un array
     //-- Function to get the total sum of one array
     public static int arraySum(List<Integer> numbs){
         int aux = 0;
         for(int it : numbs){
             aux += it;
         }
         return aux;
     }
     //-- Funcion para modificar un elemento en el array cube
     //-- Function to modify a single element on array cube

     public void modify_el(List<Integer>pos,int el){
         int pos_x = pos.get(0);
         int pos_y = pos.get(1);

         List<Integer> lisToWork = new ArrayList<>();
         lisToWork = cube.get(pos_x);
         lisToWork.set(pos_y, el);
         cube.set(pos_x, lisToWork);

         
     }
   //-- Funcion para obtener las listas paralelas y transversales
    //-- Function to get the parallel and transversal lists

    public List<List<Integer>> get_p_t(){
        List<List<Integer>> aux = new ArrayList<>();
        for(int i = 0; i<size;i++){
            List<Integer> lisint = new ArrayList<>();
            aux.add(lisint);
        }
        //Parallel
       for(List<Integer> lis : cube){
           int k = 0;
           for(int it : lis){
               aux.get(k).add(it);
                k++;
           }
           
        }
        //diagonal
        List<Integer> aux2 = new ArrayList<>();
        for(List<Integer> diagLis : cube){
            int ind = cube.indexOf(diagLis);
            aux2.add(cube.get(ind).get(ind));
        }
        aux.add(aux2);
        //diagonal invert
        List<Integer> aux3 = new ArrayList<>();
        int w = size-1;
        int j = 0;
        while(w >= 0){
            aux3.add(cube.get(j).get(w));
            j++;
            w--;
        }
        aux.add(aux3);

        System.out.println(aux);
        return aux;
    }

   //-- Funcion para obtener elementos faltantes
    //-- Function to get the missing elements
    public List<Integer> missingList(){
        List<Integer> new_list = new ArrayList<>();
        for(List<Integer> el : cube){
            for(int it : el){
                new_list.add(it);
            } }
        List<Integer>aux = new ArrayList<>();
        int i = 1;
        while(i<=dimention){
            if(!new_list.contains(i)){
                aux.add(i);
            }
            i++;
        }
        return aux;
    } 

    }
