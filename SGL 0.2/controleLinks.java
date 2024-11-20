import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//Criação da classe SistemaLinks

public class controleLinks {
    private ArrayList<cadastroLinks> links;
    private static final String ARQUIVO = "links.txt";

    public controleLinks() {
        links = new ArrayList<>();
    }

    //Busca os links salvos
    public void buscarLinks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    String url = partes[0];
                    String descricao = partes[1];
                    String assunto = partes[2];
                    novoLink(url, descricao, assunto);
                }
            }
            System.out.println("Links carregados com sucesso!");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar os links do arquivo: " + e.getMessage());
        }
    }

    // Listar links por assunto
    public void linksPorAssunto(String assunto) {
        boolean encontrou = false;
        for (cadastroLinks link : links) {
            if (link.getAssunto().equalsIgnoreCase(assunto)) {
                System.out.println(link);
                System.out.println("************");
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum link encontrado para o assunto: " + assunto + "\n");
        }
    }
    
    // Salvar links no arquivo
    public void salvarLinks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (cadastroLinks link : links) {
                writer.write(link.getUrl() + ";" + link.getDescricao() + ";" + link.getAssunto());
                writer.newLine();
            }
            System.out.println("Links salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }


    // Listar todos os links
    public void listarLinks() {
        if (links.isEmpty()) {
            System.out.println("Nenhum link cadastrado ainda.\n");
        } else {
            System.out.println("Links cadastrados:");
            for (int i = 0; i < links.size(); i++) {
                System.out.println("[" + i + "] " + links.get(i));
                System.out.println("--------------------------");
            }
        }
    }


    // Remover link
    public void removerLink(int indice) {
        if (indice >= 0 && indice < links.size()) {
            links.remove(indice);
            System.out.println("Link removido com sucesso!\n");
        } else {
            System.out.println("Índice inválido! Tente novamente.\n");
        }
    }

    // Adicionar link
    public void novoLink(String url, String descricao, String assunto) {
        cadastroLinks link = new cadastroLinks(url, descricao, assunto);
        links.add(link);
        System.out.println("Link adicionado com sucesso!\n");
    }

    // Exibir menu
    public void mostrarMenu() {
        buscarLinks(); // Carrega os links ao iniciar
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("---Sistema de Links---");
            System.out.println("1. Adicionar Link");
            System.out.println("2. Listar Todos os Links");
            System.out.println("3. Filtrar Links por Assunto");
            System.out.println("4. Remover Link");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.println("---Novo Link---");
                    System.out.print("Digite a URL: ");
                    String url = scanner.nextLine();
                    System.out.print("Digite a descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Digite o assunto: ");
                    String assunto = scanner.nextLine();
                    novoLink(url, descricao, assunto);
                    break;

                case 2:
                    System.out.println("---Listar Todos os Links---");
                    listarLinks();
                    break;

                case 3:
                    System.out.println("---Filtrar Links por Assunto---");
                    System.out.print("Digite o assunto para filtrar: ");
                    String assuntoFiltro = scanner.nextLine();
                    linksPorAssunto(assuntoFiltro);
                    break;

                case 4:
                    System.out.println("---Remover Link---");
                    listarLinks();
                    System.out.print("Digite o código do link que deseja remover: ");
                    int indice = scanner.nextInt();
                    removerLink(indice);
                    break;

                case 5:
                    System.out.println("Fechando o sistema...");
                    salvarLinks(); // Salva links ao sair
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    // Método principal para executar o sistema
    public static void main(String[] args) {
        controleLinks sistema = new controleLinks();
        sistema.mostrarMenu();
    }
}
