package Ejercicio2;

public class GatoSimple implements Comparable<GatoSimple> {
    // Atributos privados
    private String color;
    private double peso;
    private String raza;
    private int edad;
    private String nombre;
    private String sexo;  // macho o hembra

    // Constructor parametrizado
    public GatoSimple(String color, double peso, String raza, int edad, String nombre, String sexo) {
        this.color = color;
        this.peso = peso;
        this.raza = raza;
        this.edad = edad;
        this.nombre = nombre;
        this.sexo = sexo;
    }

    // Método maullar
    public void maullar() {
        System.out.println("Miauu");
    }

    // Método ronronear
    public void ronronear() {
        System.out.println("prrrr");
    }

    // Método comer
    public void comer(String comida) {
        if (comida.equalsIgnoreCase("pescado")) {
            System.out.println("Que rico ¡Gracias!!");
        } else {
            System.out.println("Lo siento, yo solo como pescado");
        }
    }

 // Método pelear
    public void pelear(GatoSimple gatoContrincante) {
        System.out.println("Sexo del gato contrincante: " + gatoContrincante.getSexo()); // Depuración

        if (this.sexo.equalsIgnoreCase("hembra")) {
            System.out.println("No me gusta pelear");
        } else if (this.sexo.equalsIgnoreCase("macho")) {
            if (gatoContrincante.getSexo().equalsIgnoreCase("hembra")) {
                System.out.println("No peleo contra gatitas");
            } else if (gatoContrincante.getSexo().equalsIgnoreCase("macho")) {
                System.out.println("¡Ven aquí que te vas a enterar!");
            } else {
                System.out.println("El contrincante tiene un sexo no identificado.");
            }
        }
    }

    // Métodos getters
    public String getNombre() {
        return nombre;
    }

    public String getSexo() {
        return sexo;
    }

    // Para la comparación en el TreeSet
    @Override
    public int compareTo(GatoSimple otroGato) {
        return this.nombre.compareTo(otroGato.nombre);
    }

    // Sobreescribir toString para mostrar los atributos
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Sexo: " + sexo + ", Color: " + color + ", Peso: " + peso + 
               ", Raza: " + raza + ", Edad: " + edad;
    }
}