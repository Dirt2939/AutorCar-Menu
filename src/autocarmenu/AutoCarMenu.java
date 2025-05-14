package autocarmenu;

import java.util.ArrayList;
import java.util.Scanner;

public class AutoCarMenu {

    static String modelo, cor, placa, marca;
    static int ano, quantidadeCarros;

    static ArrayList<CarrosInfo> carros = new ArrayList<>();
    static ArrayList<CarrosInfo> carrosCache = new ArrayList<>();
    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {

        int op = 0;

        do {

            System.out.println("\n---AutoCar Menu---");
            System.out.println("1 - Lista Carros");
            System.out.println("2 - Adicionar Carros");
            System.out.println("4 - Sair");
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
            
            System.out.println("1 - Pesquisar carro");
            System.out.println("1 - Modificar Carro");
            System.out.println("2 - Remover Carro");
            System.out.println("3 - Voltar ao menu");
            op = ler.nextInt();

        } while (op != 3);
    }
    
    public static void modificarCarro() {
        int op = 0;
        System.out.println("\n---AutoCar Car Mod---");
    }

}
