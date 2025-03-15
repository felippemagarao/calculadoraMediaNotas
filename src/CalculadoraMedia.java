import java.util.Scanner;

/**
 * Classe da calculadora.
 */
public final class CalculadoraMedia {
  /**
  * Regra de Negócio.
  * Definição da média mínima exigida pela instituição.
  */
  private static final double MEDIA_MINIMA = 7.0;

  /**
   * Inicializa o programa.
   */
  private CalculadoraMedia(){
    throw new UnsupportedOperationException("Esta é uma classe utilitária " +
            "e não pode ser instanciada.");
  }
  public static void executar() {
    Scanner scanner = new Scanner(System.in);
    boolean continuar = true;

    while (continuar) {
      System.out.println("Escolha uma opção:");
      System.out.println("1 - Calcular média");
      System.out.println("2 - Fechar o programa");

      int escolha = scanner.nextInt();
      scanner.nextLine();

      switch (escolha) {
        case 1:
          calcularMedia(scanner);
          break;
        case 2:
          continuar = false;
          System.out.println("Encerrando o programa.");
          break;
        default:
          System.out.println("Opção inválida. Tente novamente.");
      }
    }

    scanner.close();
  }

  private static void calcularMedia(final Scanner scanner) {
    System.out.println("Digite o nome do aluno: ");
    final String aluno = scanner.nextLine();

    System.out.println("Digite a nota da AP1:");
    double notaAp1 = scanner.nextDouble();

    System.out.println("Digite a nota da AP2:");
    double notaAp2 = scanner.nextDouble();

    double media = calcularMediaNotas(notaAp1, notaAp2);
    System.out.println("Média inicial: " + media);


    if (media < MEDIA_MINIMA) {
      System.out.println("Aluno(a) ficou abaixo da média! "
                +
                "Digite a nota da AS:");
      double notaAs = scanner.nextDouble();

      if (notaAp1 < notaAp2) {
        media = calcularMediaNotas(notaAs, notaAp2);
      } else {
        media = calcularMediaNotas(notaAp1, notaAs);
      }
    }

    System.out.println("A média final do(a) aluno(a) "
            + aluno + " é " + media);
  }

  private static double calcularMediaNotas(final double nota1,
                                             final double nota2) {
    return (nota1 + nota2) / 2;
  }
}
