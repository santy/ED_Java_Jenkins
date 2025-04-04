public class NumberUtils {
    // Constructor privado para evitar instanciaciones
    private NumberUtils() {
    }

    /**
     * Devuelve true si el número es par, false en caso contrario.
     */
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
