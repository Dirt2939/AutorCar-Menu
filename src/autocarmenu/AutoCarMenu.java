package autocarmenu;

import java.util.ArrayList;
import java.util.Scanner;

public class AutoCarMenu {

    static String modelo, cor, placa, marca;
    static int ano, quantidadeCarros, idMod;

    static ArrayList<CarrosInfo> carros = new ArrayList<>();
    static ArrayList<CarrosInfo> carrosCache = new ArrayList<>();
    static Scanner ler = new Scanner(System.in);
    static CarrosInfo carroEncontrado = null;

    public static void main(String[] args) {

        int op = 0;

        do {

            System.out.println("\n---AutoCar Menu---");
            System.out.println("1 - Lista Carros");
            System.out.println("2 - Adicionar Carros");
            System.out.println("3 - Modificar Carro");
            System.out.println("4 - Remover Carro");
            System.out.println("5 - Sair");
            op = ler.nextInt();
            ler.nextLine();

            switch (op) {
                case 1:
                    listarCarro();
                    break;
                case 2:
                    adicionarCarro();
                    break;
                case 3:
                    modificarCarroMenu();
                    break;
                case 4:
                    break;
            }

        } while (op != 5);

    }

    public static void adicionarCarro() {
        int op = 0;

        do {
            quantidadeCarros++;
            System.out.println("Marca: ");
            marca = ler.nextLine();

            System.out.println("Modelo: ");
            modelo = ler.nextLine();

            System.out.println("Ano: ");
            ano = ler.nextInt();
            ler.nextLine();

            System.out.println("Cor: ");
            cor = ler.nextLine();

            System.out.println("Placa: ");
            placa = ler.nextLine();

            CarrosInfo novoCarro = new CarrosInfo(modelo, cor, placa, ano,
                    marca, quantidadeCarros);
            carrosCache.add(novoCarro);

            System.out.println("Automóveis adicionados:");
            for (CarrosInfo car : carrosCache) {
                System.out.println(car);
            }

            System.out.println("\n1 - Adicionar outro");
            System.out.println("2 - Confirmar escolha e salvar");
            op = ler.nextInt();
            ler.nextLine();

            if (op != 1) {
                carros.addAll(carrosCache);
                System.out.println("Adicionado(s) com sucesso!");
            }

        } while (op != 2);

    }

    public static void listarCarro() {
        int op = 0;

        do {
            System.out.println("\n---AutoCar Car List---");

            for (CarrosInfo c : carros) {
                System.out.println(c);
            }

            System.out.println("1 - Voltar");
            op = ler.nextInt();

        } while (op != 1);
    }

    public static void modificarCarroMenu() {
        String aj = "", infoMod = "";
        int op = 0;

        System.out.println("\n---AutoCar Car Mod---");
        do {

            if (carroEncontrado != null) {
                System.out.println("Quer continuar a modificar o carro anterior"
                        + "? s/n");
                System.out.println(carroEncontrado);
                String escolha = ler.nextLine();
                if (escolha.equalsIgnoreCase("s")) {
                    // Só continua
                } else {
                    System.out.println("Qual o ID do carro que voce quer modificar?");
                    System.out.println("(Caso não saiba digite: listar)");
                    aj = ler.nextLine();

                    try {
                        idMod = Integer.parseInt(aj);
                    } catch (NumberFormatException e) {
                        if (aj.equalsIgnoreCase("listar")) {
                            listarCarro();
                            aj = ""; // Reinicia a variavel de resposta
                        } else {
                            System.out.println("Erro inesperado, voltando ao menu"
                                + "...");
                            break;
                        }
                    }
                }

            } else {
                System.out.println("Qual o ID do carro que voce quer modificar?");
                System.out.println("(Caso não saiba digite: listar)");
                aj = ler.nextLine();

                try {
                    idMod = Integer.parseInt(aj);
                } catch (NumberFormatException e) {
                    if (aj.equalsIgnoreCase("listar")) {
                        listarCarro();
                    } else {
                        System.out.println("Erro inesperado, voltando ao menu"
                                + "...");
                        break;
                    }
                }
            }

            aj = ""; // Reinicia a variavel de resposta
            
            for (CarrosInfo c : carros) {
                if (c.id == idMod) {
                    System.out.println(c);
                    System.out.println("Esse é o carro desejado? (s/n)");
                    String op2 = ler.nextLine();

                    if (op2.equalsIgnoreCase("s")) {
                        carroEncontrado = c;

                        System.out.println("Digite qual informação"
                                + " queres modificar: ");
                        infoMod = ler.nextLine();

                        modificarCarro(infoMod, c);

                    } else {
                        System.out.println("Verifique na tabela...");
                        listarCarro();
                    }

                    System.out.println(c);
                    System.out.println("Correto? s/n");
                    String i = ler.nextLine();

                    if (i.equalsIgnoreCase("n")) {

                    } else {
                        System.out.println("\n---AutoCar Car Mod---");
                        System.out.println("1 - Modificar o mesmo carro");
                        System.out.println("2 - Modificar outro carro");
                        System.out.println("3 - voltar ao menu");
                        int e = ler.nextInt();
                        ler.nextLine();

                        if (e == 1) {

                        } else if (e == 2) {
                            // Só repete o loop
                        } else {
                            e = 1;
                        }

                    }

                }
            }

        } while (op != 1);
    }

    public static String modificarCarro(String info, CarrosInfo c) {
        String novaInfo = "";

        if (info.equalsIgnoreCase("modelo")) {
            System.out.println("Digite o novo modelo: ");
            c.modelo = ler.nextLine();
            return c.modelo;
        }

        return null;
    }

}
