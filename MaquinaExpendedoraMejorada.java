public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    //contador billetes vendidos
    private int vendidos;
    //premio o no premio
    private boolean premio;
    //numero maximo de venta de billetes
    private int maxBilletes;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean premioBillete, int maximoBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        vendidos = 0;
        premio = premioBillete;
        maxBilletes = maximoBilletes;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }
    
    /**
     * Devuelve la cantidad de billetes vendidos
     */
    public int getNumeroBilletesVendidos() {
        return vendidos;
    }
    
    /**
     * Imprime la cantidad de billetes vendidos
     */
    public void imprimeNumeroBilletesVendidos() {
        System.out.println("Billetes vendidos: " + vendidos);
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if(vendidos < maxBilletes) {
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }
        }
        else {
            System.out.println("No puede añadir más dinero. No hay billetes a la venta");
        }            
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        if(vendidos < maxBilletes) {
            int dineroQueFalta = precioBillete - balanceClienteActual;
            if (dineroQueFalta <= 0) {        
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                
        
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                vendidos++;
                if(premio == true) {
                    System.out.println("¡Ha ganado un premio de " + (precioBillete * 0.1) + " euros para su próxima compra en Alimerka!");
                }
                System.out.println("##################");
                System.out.println();
            }
            else {
                System.out.println("Necesitas introducir " + dineroQueFalta + " euros mas!");
                        
            }            
        }
        else {
            System.out.println("Error! Esta máquina alcanzó el máximo número de billetes vendidos.");
        }        
    }
    
    /**
     * vacia los dos depositos
     */
    public int vaciarDineroDeLaMaquina(){
        int depositoTotal;
        if(balanceClienteActual == 0){
           depositoTotal = totalDineroAcumulado;
           totalDineroAcumulado = 0;
        }
        else{
            depositoTotal = -1;
        }
        return depositoTotal;
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
}