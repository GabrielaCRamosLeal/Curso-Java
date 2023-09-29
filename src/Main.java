import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        System.out.printf("Digite o limite do seu cartão: ");
        double limite = ler.nextDouble();

        Cartao cartao = new Cartao(limite);

        int sair = 1;
        while (sair != 0){
            System.out.printf("O que deseja comprar? ");
            String descricao = ler.next();

            System.out.printf("Digite o valor da compra. ");
            Double valor = ler.nextDouble();

            Compra compra = new Compra(descricao, valor);
            //boolean compraRealizada = cartao.lancaCompra(compra);

            if (cartao.lancaCompra(compra)){
                System.out.println(
                           """
                           Compra realizada! :)
                           Agora seu saldo é de %s reais.
                           """.formatted(cartao.getSaldo()));

                System.out.printf("Para continuar digite 1, caso queira encerrar digite 0. ");
                sair = ler.nextInt();
            }
            else {
                System.out.println("Saldo insuficiente para esta compra. :(");
                System.out.printf("Para continuar digite 1, caso queira encerrar digite 0. ");
                sair = ler.nextInt();
            }
        }
        Collections.sort(cartao.getCompras());
        for (Compra c : cartao.getCompras()){
            System.out.println("""
                ******************************
                APURADO DAS SUAS COMPRAS
                
                Produto: %s de %s reais.
                
                *******************************
                """.formatted(c.getDescricao(),c.getValor()));
        }
        System.out.println("Saldo final: " + cartao.getSaldo());
    }
}