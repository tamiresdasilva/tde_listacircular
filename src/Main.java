import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaCircular<Integer> listaCircular = new ListaCircular<>();

        System.out.println("\nINSERÇÕES...");
        System.out.println("Lista após a impressão (sem inserção de dados): ");
        listaCircular.imprimir();
        System.out.println("Lista após adicionar um elemento ao final:");
        listaCircular.adicionarNoFim(5);
        listaCircular.imprimir();
        System.out.println("Lista após adicionar um elemento ao começo:");
        listaCircular.adicionarNoInicio(10);
        listaCircular.imprimir();
        System.out.println("Lista após adicionar o elemento 2 na posição 1:");
        listaCircular.adicionarNaPosicao(1, 2);
        listaCircular.imprimir();

        System.out.println();

        System.out.println("BUSCAS...");
        System.out.println("Buscando o elemento da posição 2: ");
        System.out.println(listaCircular.buscar(2));;
        System.out.println("Buscando a posição do elemento 5: ");
        System.out.println(listaCircular.buscarPosicao(5));;

        System.out.println();

        System.out.println("REMOÇÕES...");
        System.out.println("Lista após remover o elemento pela posição 1: ");
        listaCircular.removerDaPosicao(1);
        listaCircular.imprimir();
        System.out.println("Lista após remover o último elemento:");
        listaCircular.removerNoFim();
        listaCircular.imprimir();
        System.out.println("Lista após remover o primeiro elemento: ");
        listaCircular.removerNoInicio();
        listaCircular.imprimir();
        System.out.println("Lista após adicionar um novo elemento ao começo:");
        listaCircular.adicionarNoInicio(10);
        listaCircular.imprimir();
        System.out.println("Lista após remover esse novo elemento por valor: ");
        listaCircular.removerPorValor(10);
        listaCircular.imprimir();
    }
}