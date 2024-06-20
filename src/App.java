import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa la palabra a esconder:");
        String palabra = scan.next();
        int vidas = 5;
        int turnos = 0;
        boolean gano = false;
        String[] descubrir = new String[palabra.length()];
        String[] respuesta = new String[palabra.length()];

        for(int j = 0; j <= palabra.length()-1;j++){
            char palabras = palabra.charAt(j);
            descubrir[j] = Character.toString(palabras);
            respuesta[j] = "-";
        }

        while (vidas < 0 || !gano) {
            boolean palabra_encontrada = false;
            System.out.println();
            System.out.println("Cual es la letra #"+turnos+" que elegiste");
            String eleccion = scan.next();
            for(int j = 0; j <= palabra.length()-1;j++){
                if(descubrir[j].equals(eleccion) ){
                    respuesta[j] = eleccion; 
                    palabra_encontrada = true;       
                }
            }

            if(!palabra_encontrada){
                System.out.println("No se encontro esa letra en la palabra");
                vidas--;
                System.out.println("Te quedan "+vidas+" restantes");
                System.out.println();
            }
            
            for(int j = 0; j <= palabra.length()-1;j++){
                System.out.print(respuesta[j]);
              
            }

            gano = true;
            for (int j = 0; j < palabra.length(); j++) {
                if (respuesta[j].equals("-")) {
                    gano = false;
                    break;
                }
            }

            if (gano) {
                System.out.println("¡Felicidades! Has adivinado la palabra.");
            } else if (vidas == 0) {
                System.out.println("JUEGO TERMINADO. HAS PERDIDO.");
                System.out.println("La palabra era: " + palabra);
                break;
            }


            turnos++;

            
        }
            
        

        
     

    }


   
}
