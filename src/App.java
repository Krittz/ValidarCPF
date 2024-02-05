import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int op = 0;
        do {
            System.out.println("------::: Validador de CPF :::------");
            System.out.println(">>> [ 1 ] - Testar CPF <<<");
            System.out.println(">>> [ 0 ] - Sair       <<<");
            System.out.print(">>> Opção: ");
            op = Integer.parseInt(sc.nextLine());
            switch (op) {
                case 1:
                System.out.print(">>> CPF: ");
                    String cpf = sc.nextLine();
                    if (validar(cpf)) {
                        System.out.println("͡° ͜ʖ ͡ – Válido");
                    } else {
                        System.out.println("<<<(⊙︿⊙)>>> Inválido");
                    }
                    break;

                default:
                    if (op != 0) {
                        System.out.println("(!) OPÇÃO INVÁLIDA (!)");
                    } else {
                        System.out.println("(ᴗᵔᴥᵔ) Bye-Bye (ᴗᵔᴥᵔ)");
                    }
                    break;
            }
        } while (op != 0);

    }

    public static boolean validar(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            return false;
        }
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int primeiroDigitoVerificador = 11 - (soma % 11);
        if (primeiroDigitoVerificador > 9) {
            primeiroDigitoVerificador = 0;
        }
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        int segundoDigitoVerificador = 11 - (soma % 11);
        if (segundoDigitoVerificador > 9) {
            segundoDigitoVerificador = 0;
        }
        return primeiroDigitoVerificador == Character.getNumericValue(cpf.charAt(9))
                && segundoDigitoVerificador == Character.getNumericValue(cpf.charAt(10));

    }
}
