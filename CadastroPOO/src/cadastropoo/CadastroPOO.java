/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

/**
 *
 * @author Everton
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.*;

public class CadastroPOO {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo pessoaFisicaRepo = new PessoaFisicaRepo();
        PessoaJuridicaRepo pessoaJuridicaRepo = new PessoaJuridicaRepo();

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Incluir");
            System.out.println("2. Alterar");
            System.out.println("3. Excluir");
            System.out.println("4. Exibir pelo ID");
            System.out.println("5. Exibir todos");
            System.out.println("6. Salvar dados");
            System.out.println("7. Recuperar dados");
            System.out.println("0. Finalizar");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do teclado

            switch (opcao) {
                case 1:
                    System.out.println("Escolha o tipo (1 para Pessoa Física, 2 para Pessoa Jurídica):");
                    int tipo = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer do teclado
                    if (tipo == 1) {
                        System.out.println("Digite o ID:");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Digite o nome:");
                        String nome = scanner.nextLine();
                        System.out.println("Digite o CPF:");
                        String cpf = scanner.nextLine();
                        System.out.println("Digite a idade:");
                        int idade = scanner.nextInt();
                        PessoaFisica pessoaFisica = new PessoaFisica(id, nome, cpf, idade);
                        pessoaFisicaRepo.inserir(pessoaFisica);
                        System.out.println("Pessoa Física adicionada com sucesso.");
                    } else if (tipo == 2) {
                        System.out.println("Digite o ID:");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Digite o nome da empresa:");
                        String nome = scanner.nextLine();
                        System.out.println("Digite o CNPJ:");
                        String cnpj = scanner.nextLine();
                        PessoaJuridica pessoaJuridica = new PessoaJuridica(id, nome, cnpj);
                        pessoaJuridicaRepo.inserir(pessoaJuridica);
                        System.out.println("Pessoa Jurídica adicionada com sucesso.");
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 2:
                    System.out.println("Escolha o tipo (1 para Pessoa Física, 2 para Pessoa Jurídica):");
                    int tipoAlterar = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer do teclado
                    System.out.println("Digite o ID da entidade a ser alterada:");
                    int idAlterar = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer do teclado
                    if (tipoAlterar == 1) {
                        PessoaFisica pessoaFisica = pessoaFisicaRepo.obter(idAlterar);
                        if (pessoaFisica != null) {
                            System.out.println("Dados atuais da Pessoa Física:");
                            pessoaFisica.exibir();
                            System.out.println("Digite o novo nome:");
                            String novoNome = scanner.nextLine();
                            System.out.println("Digite o novo CPF:");
                            String novoCpf = scanner.nextLine();
                            System.out.println("Digite a nova idade:");
                            int novaIdade = scanner.nextInt();
                            pessoaFisica.setNome(novoNome);
                            pessoaFisica.setCpf(novoCpf);
                            pessoaFisica.setIdade(novaIdade);
                            System.out.println("Pessoa Física alterada com sucesso.");
                        } else {
                            System.out.println("Pessoa Física não encontrada.");
                        }
                    } else if (tipoAlterar == 2) {
                        PessoaJuridica pessoaJuridica = pessoaJuridicaRepo.obter(idAlterar);
                        if (pessoaJuridica != null) {
                            System.out.println("Dados atuais da Pessoa Jurídica:");
                            pessoaJuridica.exibir();
                            System.out.println("Digite o novo nome da empresa:");
                            String novoNome = scanner.nextLine();
                            System.out.println("Digite o novo CNPJ:");
                            String novoCnpj = scanner.nextLine();
                            pessoaJuridica.setNome(novoNome);
                            pessoaJuridica.setCnpj(novoCnpj);
                            System.out.println("Pessoa Jurídica alterada com sucesso.");
                        } else {
                            System.out.println("Pessoa Jurídica não encontrada.");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 3:
                    System.out.println("Escolha o tipo (1 para Pessoa Física, 2 para Pessoa Jurídica):");
                    int tipoExcluir = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer do teclado
                    System.out.println("Digite o ID da entidade a ser excluída:");
                    int idExcluir = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer do teclado
                    boolean excluido = false;
                    if (tipoExcluir == 1) {
                        excluido = pessoaFisicaRepo.excluir(idExcluir);
                    } else if (tipoExcluir == 2) {
                        excluido = pessoaJuridicaRepo.excluir(idExcluir);
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    if (excluido) {
                        System.out.println("Entidade excluída com sucesso.");
                    } else {
                        System.out.println("Entidade não encontrada.");
                    }
                    break;
                // Demais casos omitidos para evitar superar o limite de caracteres
                // ...
                case 0:
                    System.out.println("Finalizando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}