package uvg.edu.gt;

import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Predefinir la ruta del archivo que contiene la expresión matemática
        String filePath = "expression.txt";
        Scanner scanner = new Scanner(System.in);
        Stack<String> stack;

        try {
            // Solicitar al usuario la implementación de Stack
            System.out.println("Por favor, elige la implementación de Stack: ArrayList, Vector, Lista");
            String stackChoice = scanner.nextLine();

            if ("ArrayList".equalsIgnoreCase(stackChoice)) {
                stack = DataStructureFactory.createStack("ArrayList");
            } else if ("Vector".equalsIgnoreCase(stackChoice)) {
                stack = DataStructureFactory.createStack("Vector");
            } else if ("Lista".equalsIgnoreCase(stackChoice)) {
                System.out.println("Por favor, elige la implementación de List: SimplementeEncadenada, DoblementeEncadenada");
                String listChoice = scanner.nextLine();
                stack = DataStructureFactory.createStack("List", listChoice);
            } else {
                throw new IllegalArgumentException("Implementación de Stack desconocida.");
            }

            // Leer la expresión matemática del archivo
            String infixExpression = new String(Files.readAllBytes(Paths.get(filePath)));

            // Convertir la expresión a notación postfix
            ExpressionConverter converter = new ExpressionConverterImpl(); // Implementa esta clase
            String postfixExpression = converter.toPostfix(infixExpression);

            // Obtener la instancia de Calculator y evaluar la expresión postfix
            Calculator calculator = Calculator.getInstance();
            int result = calculator.evaluatePostfix(postfixExpression);

            // Mostrar los resultados
            System.out.println("La expresión infix es: " + infixExpression);
            System.out.println("La expresión postfix es: " + postfixExpression);
            System.out.println("El resultado de la evaluación es: " + result);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}


