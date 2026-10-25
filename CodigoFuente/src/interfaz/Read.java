package interfaz;

import java.util.Scanner;

public class Read {
    public static final Scanner scan = new Scanner(System.in);

    //Métodos GOATS, no dejan salto de línea en el buffer ni truenan ૮₍ ˶ᵔ ᵕ ᵔ˶ ₎ა
    public static int intReader(){
        String aux ;
        boolean notApproved=false;
        int num=0;
        do{
            try {
                notApproved=false;
                aux = scan.nextLine();
                num = Integer.parseInt(aux);
            } catch (NumberFormatException e) {
                notApproved=true;
                System.out.println("Porfavor, introduce solo números y sin decimales");
                
            }
        }while(notApproved);
        return num;
        
    }

    public static float floatReader(){
        String aux ;
        boolean notApproved=false;
        float num=0;
        do{
            try {
                notApproved=false;
                aux = scan.nextLine();
                num = Float.parseFloat(aux);
            } catch (NumberFormatException e) {
                notApproved=true;
                System.out.println("Porfavor, introduce solo números");
                
            }
        }while(notApproved);
        return num;
        
    }
}
