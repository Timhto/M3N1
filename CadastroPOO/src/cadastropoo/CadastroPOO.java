/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

/**
 *
 * @author Everton
 */
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

public class CadastroPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Repositório de pessoas físicas
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();

            PessoaFisica pessoaFisica1 = new PessoaFisica(1, "Everton", "12345678901", 36);
            PessoaFisica pessoaFisica2 = new PessoaFisica(2, "Sirlene", "98765432101", 35);

            repo1.inserir(pessoaFisica1);
            repo1.inserir(pessoaFisica2);

            repo1.persistir("pessoasFisicas.dat");

            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            repo2.recuperar("pessoasFisicas.dat");

            System.out.println("Pessoas Físicas recuperadas:");
            for (PessoaFisica pessoa : repo2.obterTodos()) {
                pessoa.exibir();
                System.out.println();
            }

            // Repositório de pessoas jurídicas
            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();

            PessoaJuridica pessoaJuridica1 = new PessoaJuridica(1, "Isomonte s/a", "12345678901234");
            PessoaJuridica pessoaJuridica2 = new PessoaJuridica(2, "Delp", "98765432109876");

            repo3.inserir(pessoaJuridica1);
            repo3.inserir(pessoaJuridica2);

            repo3.persistir("pessoasJuridicas.dat");

            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            repo4.recuperar("pessoasJuridicas.dat");

            System.out.println("Pessoas Jurídicas recuperadas:");
            for (PessoaJuridica pessoa : repo4.obterTodos()) {
                pessoa.exibir();
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // TODO code application logic here
}
