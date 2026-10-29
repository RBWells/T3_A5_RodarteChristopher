import java.util.Scanner;

public class MenuTemperaturas {
    public static void main(String[] args) throws Exception {
        Scanner nrg = new Scanner(System.in);
        ListaEnlazadax le = new ListaEnlazadax();
        int op;

        do {
            System.out.println("== MENU DE TEMPERATURAS EN °C ==");
            System.out.println("1. Agregar Temperatura al inicio");
            System.out.println("2. Agregar Temperatura al final");
            System.out.println("3. Eliminar Temperatura al inicio");
            System.out.println("4. Eliminar Temperatura al final");
            System.out.println("5. Eliminar dato especifico");
            System.out.println("6. Eliminar Temperatura en posicion especifica");
            System.out.println("7. Mostrar Temperaturas");
            System.out.println("8. Promedio de temperaturas");
            System.out.println("-----------------------------------------------");
            System.out.println("0. Salir.....");
            op = nrg.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Dime que Temperatura quieres ingresar al inicio");
                    double e = nrg.nextDouble();
                    le.agregarElementoAlInicio(e);
                    break;
                case 2:
                    System.out.println("Dime que Temperatura quieres ingresar al final");
                    int ef = nrg.nextInt();
                    le.agregarElementoAlFinal(ef);
                    break;
                case 3:
                    le.eliminarElementoAlInicio();
                    break;
                case 4:
                    le.eliminarElementoAlFinal();
                    break;
                case 5:
                    System.out.println("Que dato quieres eliminar");
                    int dato = nrg.nextInt();
                    le.eliminarDatoEspecifico(dato);
                    break;
                case 6:
                    System.out.println("Dime la posicion de la temperatura que quieres eliminar");
                    int pos = nrg.nextInt();
                    le.eliminarPosicionEspecifica(pos);
                    break;
                case 7:
                    le.mostrarElementos();
                    break;
                case 8:
                    le.promedioTemps();
                    break;
                case 0:
                    System.out.println("Saliste....");
                    break;
                default:
                    System.out.println("Esa no es una opsion valida");
                    break;
            }
        } while (op != 0);
        nrg.close();
    }
}
