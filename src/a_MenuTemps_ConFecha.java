import java.util.Scanner;

public class a_MenuTemps_ConFecha {
    public static void main(String[] args) {
        Scanner nrg = new Scanner(System.in);
        a_ListaEnlazada_CnFecha regs = new a_ListaEnlazada_CnFecha();
        a_TEMPERATURAS registtroTemps;
        int op;

        do {
            System.out.println("== MENU DE Registro de TEMPERATURAS EN °C ==");
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
                    System.out.println("Dime la fecha en la que estas registrando dicha temperratura");
                    String fechaIni=nrg.next();

                    registtroTemps=new a_TEMPERATURAS(e, fechaIni);

                    regs.agregarElementoAlInicio(registtroTemps);
                    break;
                case 2:
                    System.out.println("Dime que Temperatura quieres ingresar al final");
                    double ef = nrg.nextInt();
                    System.out.println("Dime la fecha para registrar dicha temp (dd/mm/yyyy)");
                    String fechaRegFinal=nrg.next();
                    registtroTemps=new a_TEMPERATURAS(ef, fechaRegFinal);
                    regs.agregarElementoAlFinal(registtroTemps);
                    break;
                case 3:
                    regs.eliminarElementoAlInicio();
                    break;
                case 4:
                    regs.eliminarElementoAlFinal();
                    break;
                case 5:
                    System.out.println("Que temperatura quieres eliminar");
                    double tempElim = nrg.nextInt();
                    System.out.println("Ingresa la fecha del registro de ese dato (dd/mm/yyyy)");
                    String fechaE=nrg.next();
                    registtroTemps=new a_TEMPERATURAS(tempElim, fechaE);
                    regs.eliminarDatoEspecifico(registtroTemps);
                    break;
                case 6:
                    System.out.println("Dime la posicion de la temperatura que quieres eliminar");
                    int pos = nrg.nextInt();
                    regs.eliminarPosicionEspecifica(pos);
                    break;
                case 7:
                    regs.mostrarElementos();
                    break;
                case 8:
                    System.out.println("Dime una fecha inicial para calcular de donde va a iniciar el calculo (dd/mm/yyyy)");
                    String fechaInical=nrg.next();
                    System.out.println("Dime el limite de la fecha para calcular el promedio (dd/mm/yyyy)");
                    String fechaFinal=nrg.next();
                    regs.promedioPorFecha(fechaInical, fechaFinal);
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
