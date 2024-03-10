package entidadFinanciera;//Movemos la clase al paquete entidadFinanciera

public class CCuenta {
	//  Encapsulamos los atributos
    /**
     * Nombre de la persona titular
     */
    private String nombre;
    private String cuenta;
    private double saldo;
    private double tipoInterés;

    // Paso 6: Creamos el atributo constante ERRORCANTIDADNEGATIVA
    public static final String ERRORCANTIDADNEGATIVA = "No se puede ingresar una cantidad negativa";
    
   // Constructor
    public CCuenta(String nom, String cue, double sal, double tipo)
    {
        nombre =nom;
        cuenta=cue;
        saldo=sal;
    }
    
    // Métodos
    //Encapsulamos los atributos
    public double estado(){
        return this.saldo;
    }

    public void ingresar(double cantidad) throws Exception
    {
        if (cantidad<0)
            throw new Exception("No se puede ingresar una cantidad negativa");
        saldo = saldo + cantidad;
    }

    public void retirar(double cantidad) throws Exception
    {
        if (cantidad <= 0)
            throw new Exception ("No se puede retirar una cantidad negativa");
        if (saldo < cantidad)
            throw new Exception ("No se hay suficiente saldo");
        saldo = saldo - cantidad;
    }
}
/** Método que realiza una prueba de retirada.
 * @param cantidad la cantidad a retirar
 * @param cantidadEsperada la cantidad esperada después de la operación
 */
public void probarRetirar(double cantidad, double cantidadEsperada) {
    try {
        retirar(cantidad);
        if (saldo == cantidadEsperada) {
            System.out.println("Retiro exitoso");
        } else {
            System.out.println("Error en el retiro");
        }
    } catch (Exception e) {
        System.out.println("Error en el retiro: " + e.getMessage());
    }
}

/** Método que realiza una prueba de ingreso.
 * @param cantidad la cantidad a ingresar
 * @param cantidadEsperada la cantidad esperada después de la operación
 */
public void probarIngresar(double cantidad, double cantidadEsperada) {
    try {
        ingresar(cantidad);
        if (saldo == cantidadEsperada) {
            System.out.println("Ingreso exitoso");
        } else {
            System.out.println("Error en el ingreso");
        }
    } catch (Exception e) {
        System.out.println("Error en el ingreso: " + e.getMessage());
    }
}
}

    