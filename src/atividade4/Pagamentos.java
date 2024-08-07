package atividade4;

import java.util.ArrayList;
import java.util.List;

public class Pagamentos {
    private String nomeEmpresa;
    private List<Imposto> impostos = new ArrayList<>();

    public Pagamentos(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public void adicionarImposto(Imposto imposto) {
        impostos.add(imposto);
    }

    public double calcularTotalImpostos() {
        double total = 0;
        for (Imposto imposto : impostos) {
            total += imposto.calcularImposto();
        }
        return total;
    }

    public void listarImpostos() {
        for (Imposto imposto : impostos) {
            System.out.println("\nDescrição: " + imposto.getDescricao());
            System.out.println("Valor: R$" + imposto.calcularImposto());
        }
    }
}
