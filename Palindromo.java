/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package palindromo;
/**
 * Practica: Verificacion de palindromos mediante recursividad y patron Wrapper.
 * Materia: Estructura de Datos
 * Alumno: Oscar Abdiel Soto De la Cruz
 * Grado y Grupo: 4to C
 */
public class Palindromo {

    /**
     * Metodo publico: Se encarga de validar entradas nulas,
     * normalizar el texto e iniciar la llamada recursiva con los
     * punteros en los extremos.
     */
    public static boolean esPalindromo(String texto) {
        // Validacion de seguridad para evitar un NullPointerException
        if (texto == null) {
            return false;
        }
        
        // Normalizacion: pasamos a minusculas y quitamos espacios y signos de puntuacion
        String textoLimpio = texto.toLowerCase().replaceAll("[^a-z0-9]", "");
        
        // Llamada inicial al metodo recursivo
        return esPalindromoRecursivo(textoLimpio, 0, textoLimpio.length() - 1);
    }

    /**
     * Metodo privado (Recursivo): Compara los caracteres de los extremos
     * convergiendo paso a paso hacia el centro de la cadena.
     */
    private static boolean esPalindromoRecursivo(String textoLimpio, int izquierda, int derecha) {
        // Caso base 1: Los punteros se encontraron en el centro (impar)
        // o se cruzaron (par o cadena vacia).
        if (izquierda >= derecha) {
            return true;
        }
        
        // Caso base 2: Los caracteres actuales no coinciden, se corta la recursion.
        if (textoLimpio.charAt(izquierda) != textoLimpio.charAt(derecha)) {
            return false;
        }
        
        // Paso recursivo: Mover izquierda hacia adelante (+1)
        // y derecha hacia atras (-1).
        return esPalindromoRecursivo(textoLimpio, izquierda + 1, derecha - 1);
    }

    /**
     * Metodo principal para ejecutar los casos de prueba solicitados.
     */
    public static void main(String[] args) {
        // Bateria de pruebas con palindromos impares, pares, frases, no palindromos y casos borde
        String[] casosPrueba = {
            "reconocer",             // Palindromo longitud impar
            "radar",                 // Palindromo longitud impar
            "erre",                  // Palindromo longitud par
            "¡Anita, lava la tina!", // Palindromo con mayusculas, espacios y signos de puntuacion
            "java",                  // No palindromo
            "estructura",            // No palindromo
            "",                      // Caso borde con una cadena vacia
            "a",                     // Caso borde con un solo caracter
            null                     // Caso borde con una entrada nula
        };

        System.out.println("Pruebas de Palindromo Recursivo");
        for (String palabra : casosPrueba) {
            System.out.println("Palabra: \"" + palabra + "\" -> Es palindromo?: " + esPalindromo(palabra));
        }
    }
}