package atividade4;

import java.util.Scanner;

public class Atividade4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome da empresa: ");
        String nomeEmpresa = scanner.nextLine();
        Pagamentos pagamentos = new Pagamentos(nomeEmpresa);

        while (true) {
            System.out.print("Informe o tipo de imposto dentre os cadastrados (PIS ou IPI até o momento),  se deseja encerrar digite 'pare': ");
            String tipoImposto = scanner.nextLine();

            if (tipoImposto.equalsIgnoreCase("pare")) {
                break;
            }

            if (tipoImposto.equalsIgnoreCase("PIS")) {
                System.out.print("Informe o valor do débito: ");
                double debito = scanner.nextDouble();
                System.out.print("Informe o valor do crédito: ");
                double credito = scanner.nextDouble();
                scanner.nextLine(); // Limpar o buffer

                Imposto pis = new PIS(debito, credito);
                pagamentos.adicionarImposto(pis);
            } else if (tipoImposto.equalsIgnoreCase("IPI")) {
                System.out.print("Informe o valor do produto: ");
                double valorProduto = scanner.nextDouble();
                System.out.print("Informe o valor do frete: ");
                double frete = scanner.nextDouble();
                System.out.print("Informe o valor do seguro: ");
                double seguro = scanner.nextDouble();
                System.out.print("Informe o valor de outras despesas: ");
                double outrasDespesas = scanner.nextDouble();
                System.out.print("Informe a alíquota: ");
                double aliquota = scanner.nextDouble();
                scanner.nextLine(); // Limpar o buffer

                Imposto ipi = new IPI(valorProduto, frete, seguro, outrasDespesas, aliquota);
                pagamentos.adicionarImposto(ipi);
            } else {
                System.out.println("Tipo de imposto inválido.");
            }
        }

        System.out.println("Total de impostos a pagar: R$" + pagamentos.calcularTotalImpostos());
        System.out.println("Impostos:");
        pagamentos.listarImpostos();

        scanner.close();
    }
}