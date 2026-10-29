public class a_ListaEnlazada_CnFecha {
    a_Nodo_Confecha nodoInicio, nodoFin;

    public a_ListaEnlazada_CnFecha() {
        nodoInicio = null;
        nodoFin = null;
    }

    public void agregarElementoAlInicio(a_TEMPERATURAS temp) {
        a_Nodo_Confecha nuevoNodo = new a_Nodo_Confecha(temp);

        if (nodoInicio == null) {
            nodoInicio = nodoFin = nuevoNodo;
        } else {
            nuevoNodo.setNodoSiguiente(nodoInicio);
            nodoInicio = nuevoNodo;
        }
    }

    public void agregarElementoAlFinal(a_TEMPERATURAS temp) {
        a_Nodo_Confecha nuevoNodo = new a_Nodo_Confecha(temp);

        if (nodoInicio == null) {
            nodoInicio = nodoFin = nuevoNodo;
        } else {
            nodoFin.setNodoSiguiente(nuevoNodo);
            nodoFin = nuevoNodo;
        }
    }

    public void eliminarElementoAlInicio() {
        if (nodoInicio == null) {
            System.out.println("No puedes eliminar lo que nunca ha sido creado");
        } else {
            nodoInicio = nodoInicio.getNodoSiguiente();
        }
    }

    public void eliminarElementoAlFinal() {
        if (nodoInicio == null) {
            System.out.println("No puedes eliminar lo que nunca ha sido creado");
        } else if (nodoInicio == nodoFin) {
            nodoInicio = null;
            nodoFin = null;
        } else {
            a_Nodo_Confecha nodoAnterior = nodoInicio;
            while (nodoAnterior.getNodoSiguiente() != nodoFin) {
                nodoAnterior = nodoAnterior.getNodoSiguiente();
            }
            nodoAnterior.setNodoSiguiente(null);
            nodoFin = nodoAnterior;
        }
    }

    public void eliminarDatoEspecifico(a_TEMPERATURAS temp) {
        if (nodoInicio == null) {
            System.out.println("La lista esta vacia");
        } else if (temp == nodoInicio.getTemps()) {
            System.out.println("Dato encontrado en el primer nodo");
            nodoInicio = nodoInicio.getNodoSiguiente();
            System.out.println("Dato eliminado correctamente");
        } else {
            a_Nodo_Confecha anterior, nodoPosterior;
            anterior = nodoInicio;
            nodoPosterior = nodoInicio.getNodoSiguiente();

            while (temp != nodoPosterior.getTemps() && nodoPosterior.getNodoSiguiente() != null) {
                anterior = nodoPosterior;
                nodoPosterior = anterior.getNodoSiguiente();
            }
            if (temp == nodoPosterior.getTemps()) {
                anterior.setNodoSiguiente((nodoPosterior.getNodoSiguiente()));
                nodoPosterior = nodoPosterior.getNodoSiguiente();
                System.out.println("Nodo eliminado correctamente");
            } else {
                System.out.println("No se encontro el nodo");
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
        a_Nodo_Confecha anterior = nodoInicio;
        a_Nodo_Confecha nodoSiguiente = nodoInicio.getNodoSiguiente();
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

    public void mostrarElementos() {
        a_Nodo_Confecha NodoActual = nodoInicio;

        while (NodoActual != null) {
            System.out.print("[ " + NodoActual.getTemps() + " ]===>");
            NodoActual = NodoActual.getNodoSiguiente();
        }
        System.out.println();
    }

    public void promedioPorFecha(String fechaComiezo, String fechaTerminak) {
        String[] partesF1 = fechaComiezo.split("/");
        int diaf1 = Integer.parseInt(partesF1[0]);
        int mesf1 = Integer.parseInt(partesF1[1]);
        int añof1 = Integer.parseInt(partesF1[2]);

        String[] partesF2 = fechaTerminak.split("/");
        int diaf2 = Integer.parseInt(partesF2[0]);
        int mesf2 = Integer.parseInt(partesF2[1]);
        int añof2 = Integer.parseInt(partesF2[2]);

        double suma = 0;
        int cantLista = 0;

        a_Nodo_Confecha nodoActual = nodoInicio;

        while (nodoActual != null) {
            a_TEMPERATURAS temp = nodoActual.getTemps();
            String[] fecha = temp.getFecha().split("/");
            int dia = Integer.parseInt(fecha[0]);
            int mes = Integer.parseInt(fecha[1]);
            int año = Integer.parseInt(fecha[2]);

            if ((año > añof1 || (año == añof1 && mes > mesf1) || (año == añof1 && mes == mesf1 && dia >= diaf1)) && (año < añof2 || (año == añof2 && mes < mesf2) || (año == añof2 && mes == mesf2 && dia <= diaf2))) {

                suma += temp.getTemperatura();
                cantLista++;
            }

            nodoActual = nodoActual.getNodoSiguiente();
        }

        if (cantLista == 0) {
            System.out.println("No hay temperaturas en ese rango de fechas");
        }

        double promedio = suma / cantLista;

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
