import java.util.*;

public class Square {
    public static void main(String[] args) {
        List<List<Integer>> square = new ArrayList<>();
        square.add(Arrays.asList(4,8,2));
        square.add(Arrays.asList(4,5,7));
        square.add(Arrays.asList(6,1,6));
        

        int result = formingMagicSquare(square);
        System.out.println(result);
    }
    /*
        * Code by: Hiram Yadzael Vargas Chalico
        * formingMagicSquarefunction
        * Hope it work!

        * 26/10/2022
    */
    public static int formingMagicSquare(List<List<Integer>> s) {
        Boolean iscube= is_a_cube(s);
        if(iscube){
                int n = s.size();
                int dim = n*n;
                int sum_number = factorialSum(dim) / n;
                total_arr_sum(s);
                
               System.out.println(missingList(s, dim));
                
                return 1;
            }
        else{
            System.out.println("Not a cube");
            return 0;
        }
            
        }
    //-- Funcion para obtener la suma de todas las lineas
    //-- Function to get the total sum of all arrays
    public static List<Integer> total_arr_sum(List<List<Integer>> s){
       List<Integer> ret = new ArrayList<>();
       int limit = s.size()*2+2;
       int i = 0;
       while( i < limit){
        System.out.println(i);
        i++;
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

     //-- Funcion para obtener el factorial sumatorio
    //-- Function to get the summatory factorial
    public static int factorialSum(int n){
        int i = 1;
        int facsum = 0;
        while(i <= n){
            facsum += i;
            i++;
        }
        return facsum;
    }

    //-- Funcion para obtener elementos faltantes
    //-- Function to get the missing elements
    public static List<Integer> missingList(List<List<Integer>> cube, int n){
        List<Integer> new_list = new ArrayList<>();
        for(List<Integer> el : cube){
            for(int it : el){
                new_list.add(it);
            } }
        List<Integer>aux = new ArrayList<>();
        int i = 1;
        while(i<=n){
            if(!new_list.contains(i)){
                aux.add(i);
            }
            i++;
        }
        return aux;
    } 

    //-- Funcion para verificar si es cubo
    //-- Function to verify if is a cube
    public static boolean is_a_cube(List<List<Integer>> a){
        int final_length = a.size();
        for (List<Integer> l1 : a) {
            if(!(l1.size()==final_length)){
                return false;
            }
        }
        return true;
    }

}
