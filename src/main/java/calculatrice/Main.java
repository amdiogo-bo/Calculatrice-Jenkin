package calculatrice;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculatrice calc = new Calculatrice();
        char continuer;

        do {
            System.out.println("\n===== CALCULATRICE JAVA =====");
            System.out.println("1 - Addition");
            System.out.println("2 - Soustraction");
            System.out.println("3 - Multiplication");
            System.out.println("4 - Division");
            System.out.print("Choisissez une opération : ");

            int choix = sc.nextInt();

            System.out.print("Entrer le premier nombre : ");
            int a = sc.nextInt();

            System.out.print("Entrer le deuxième nombre : ");
            int b = sc.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("Résultat : " + calc.addition(a, b));
                    break;

                case 2:
                    System.out.println("Résultat : " + calc.soustraction(a, b));
                    break;

                case 3:
                    System.out.println("Résultat : " + calc.multiplication(a, b));
                    break;

                case 4:
                    try {
                        System.out.println("Résultat : " + calc.division(a, b));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                default:
                    System.out.println("❌ Choix invalide");
            }

            System.out.print("\nVoulez-vous recommencer ? (O/N) : ");
            continuer = sc.next().toUpperCase().charAt(0);

        } while (continuer == 'O');

        System.out.println("\nMerci d'avoir utilisé la calculatrice 😊");
        sc.close();
    }
}
