public class ListaEnlazadax {
    Nodo nodoInicio, nodoFin;

    // 1) Crear
    public ListaEnlazadax() {
        nodoInicio = null;
        nodoFin = null;
    }

    // 2.1) Agregar Al inicio
    public void agregarElementoAlInicio(double dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (nodoInicio == null) { // Lista Vacia
            // System.out.println("La lista esta vacia");
            nodoInicio = nodoFin = nuevoNodo;
        } else {// Yuea existen nodos o elementos en la lista
            nuevoNodo.setNodoSiguiente(nodoInicio);
            nodoInicio = nuevoNodo;
        }
    }

    public void agregarElementoAlFinal(double dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (nodoInicio == null) {
            nodoInicio = nodoFin = nuevoNodo;
        } else {
            nodoFin.setNodoSiguiente(nuevoNodo);
            nodoFin = nuevoNodo;

        }
    }

    // Eliminar Elemento al inicio
    public void eliminarElementoAlInicio() {
        if (nodoInicio == null) {
            System.out.println("No puedes eliminar lo que nunca a existido");
        } else {
            nodoInicio = nodoInicio.getNodoSiguiente();
        }
    }

    // Eliminar elemento al Final
    public void eleminarElementoAlFinal() {
        if (nodoInicio == null) {
            System.out.println("No puedes eliminar lo que no ha sido ingresado");
        } else {
            nodoFin = nodoInicio.getNodoSiguiente();
        }
    }

    // Eliminar Elemento al Final
    public void eliminarElementoAlFinal() {
        if (nodoInicio == null) {
            System.out.println("No puedes eliminar lo que no existe");
        } else if (nodoInicio == nodoFin) {
            // La lista tiene un solo nodo
            nodoInicio = null;
            nodoFin = null;
        } else {
            Nodo nodoAnterior = nodoInicio;
            Nodo nodoPosterior = nodoInicio.getNodoSiguiente();

            while (nodoPosterior.getNodoSiguiente() != null) {
                nodoAnterior = nodoPosterior;
                nodoPosterior = nodoPosterior.getNodoSiguiente();
            }
            nodoAnterior.setNodoSiguiente(null);
            nodoFin = nodoAnterior;
        }
    }

    // Elimar elemento buscado
    public void eliminarDatoEspecifico(double dataFind) {

        // Si la lista esta vacia
        if (nodoInicio == null) {
            System.out.println("Lista vacia");
        } else if (dataFind == nodoInicio.getDato()) {
            System.out.println("Dato encontrado en el primer NODO: ");
            nodoInicio = nodoInicio.getNodoSiguiente();
            System.out.println("Elemento eliminado correctamente...");
        } else {
            Nodo anterior, nodoQueSigue;
            anterior = nodoInicio;
            nodoQueSigue = nodoInicio.getNodoSiguiente();

            // Buscar el dato mientras que no se acabe la lista
            while (dataFind != nodoQueSigue.getDato() && nodoQueSigue.getNodoSiguiente() != null) {
                anterior = nodoQueSigue;
                nodoQueSigue = anterior.getNodoSiguiente();

            }
            if (dataFind == nodoQueSigue.getDato()) {
                anterior.setNodoSiguiente((nodoQueSigue.getNodoSiguiente()));
                nodoQueSigue = nodoQueSigue.getNodoSiguiente();
                System.out.println("Nodo eliminado correctamente");
            } else {
                System.out.println("No se encontro");
            }

        }
    }

    public void eliminarPosicionEspecifica(int pos) {
        if (nodoInicio == null) {
            System.out.println("La lista esta vacia, no puedes eliminar");

        } else if (pos < 0) {
            System.out.println("Esa posicion no es valida");
        } else if (pos == 0) {
            nodoInicio = nodoInicio.getNodoSiguiente();

            if (nodoInicio == null) {
                nodoFin = null;
            }
            System.out.println("Nodo eliminado...");
        }
        Nodo anterior = nodoInicio;
        Nodo nodoSiguiente = nodoInicio.getNodoSiguiente();
        int contador = 1;

        while (nodoSiguiente != null && contador < pos) {
            anterior = nodoSiguiente;
            nodoSiguiente = nodoSiguiente.getNodoSiguiente();
            contador++;
        }
        if (nodoSiguiente == null) {
            System.out.println("Esa posicion no existe en la lista");
        }
        anterior.setNodoSiguiente(nodoSiguiente.getNodoSiguiente());

        if (nodoSiguiente == nodoFin) {
            nodoFin = anterior;
        }
        System.out.println("Se ha eliminado el nodo de la listA");
    }

    // 4) Mostrar Elementos
    public void mostrarElementos() {
        Nodo NodoActual = nodoInicio;

        while (NodoActual != null) {
            System.out.print("[ " + NodoActual.getDato() + " ]===>");
            NodoActual = NodoActual.getNodoSiguiente();
        }
        System.out.println();
    }

    public void promedioTemps() {
        double suma = 0;
        double tamañodeLista = 0;
        Nodo nodoActual = nodoInicio;

        while (nodoActual != null) {
            suma += nodoActual.getDato();
            nodoActual = nodoActual.getNodoSiguiente();
            tamañodeLista++;
        }
        double promedio = suma / tamañodeLista;
        if (promedio <= 10) {
            System.out.println("El promedio de temperaturas es: " + promedio + "°C Esta Congelado");
        } else if (promedio <= 20) {
            System.out.println("El promedio de temperaturas es: " + promedio + "°C Esta Frio");
        } else if (promedio <= 30) {
            System.out.println("El promedio de temperaturas es: " + promedio + "°C Esta Normal");
        } else {
            System.out.println("El promedio de temperaturas es: " + promedio + "°C Esta Caliente");
        }
    }

}
