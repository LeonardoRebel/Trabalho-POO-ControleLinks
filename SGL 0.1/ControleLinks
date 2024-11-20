import java.util.ArrayList;
import java.util.Scanner;

//Criação da classe controleLinks
public class controleLinks {
    private ArrayList<Link> links;

    public controleLinks() {
        links = new ArrayList<>();
    }

    // Adicionar link
    public void adicionarLink(String url, String descricao, String assunto) {
        Link link = new Link(url, descricao, assunto);
        links.add(link);
        System.out.println("Link adicionado!\n");
    }

    // Listar links
    public void listarLinks() {
        if (links.isEmpty()) {
            System.out.println("nenhum link encontrado.\n");
        } else {
            System.out.println("Links cadastrados:");
            for (Link link : links) {
                System.out.println(link);
                System.out.println("--------------------------");
            }
        }
    }

    // Listar links por assunto
    public void linksPorAssunto(String assunto) {
        boolean encontrou = false;
        for (Link link : links) {
            if (link.getAssunto().equalsIgnoreCase(assunto)) {
                System.out.println(link);
                System.out.println("--------------------------");
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum link encontrado para: " + assunto + "\n");
        }
    }

    // Mostrar menu
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("---Sistema de links---");
            System.out.println("1. Novo link");
            System.out.println("2. Listar links");
            System.out.println("3. Filtrar links por Assunto");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("---Novo link---");
                    System.out.print("Digite a URL: ");
                    String url = scanner.nextLine();

                    System.out.print("Digite a descrição: ");
                    String descricao = scanner.nextLine();

                    System.out.print("Digite o assunto: ");
                    String assunto = scanner.nextLine();

                    adicionarLink(url, descricao, assunto);
                    break;

                case 2:
                    System.out.println("---Listar links---");
                    listarLinks();
                    break;

                case 3:
                    System.out.println("---Filtrar Links por Assunto---");
                    System.out.print("Digite o assunto: ");
                    String assuntoFiltro = scanner.nextLine();
                    linksPorAssunto(assuntoFiltro);
                    break;

                case 4:
                    System.out.println("Fechando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.\n");
            }
        } while (opcao != 4);

        scanner.close();
    }
}
