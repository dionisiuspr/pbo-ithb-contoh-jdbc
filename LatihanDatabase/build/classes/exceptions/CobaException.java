package exceptions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hanschristian
 */
public class CobaException {

    private static int[] array = new int[3];

    public static void main(String[] args) {
        int temp = 7;
        if(temp < array.length)
            System.out.println(array[temp]);

        String name = null;
        if (name != null) {
            if (name.equals("Budi")) {
                System.out.println("HALO Budi");
            }
        }
        System.out.println("Masuk");

        // Exception Handling
        try {
            System.out.println("Array 10: " + array[2]);
        } catch(Exception e) {
            System.out.println("MASUK INDEX OUT OF BOUND");
            // Exception Logging
//            tools.sendLog(e.printStackTrace());
//            e.printStackTrace();
        }
        finally {
            System.out.println("MASUK FINALLY");
        }
        

        System.out.println("Array 2: " + array[2]);
    }
}
