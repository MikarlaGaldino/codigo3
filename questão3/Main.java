import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

 public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Informe o número do contrato: ");
            int numeroContrato = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Informe a data do contrato (dd/MM/yyyy): ");
            String dataContratoStr = scanner.nextLine();
            LocalDate dataContrato = LocalDate.parse(dataContratoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            System.out.print("Informe o valor total do contrato: ");
            double valorTotalContrato = scanner.nextDouble();

            System.out.print("Informe o número de meses para parcelamento: ");
            int numeroMeses = scanner.nextInt();


            System.out.println("\n--- Parcelas do Contrato ---\n");
            double valorParcela = valorTotalContrato / numeroMeses;
            LocalDate dataParcela = dataContrato.plusMonths(1);

            for (int i = 1; i <= numeroMeses; i++) {

                double juros = valorParcela * 0.01;
                double taxaPagamento = valorParcela * 0.02;
                double valorTotalParcela = valorParcela + juros + taxaPagamento;


                System.out.printf("Parcela %d - Data de vencimento: %s - Valor a ser pago: R$ %.2f\n",
                                  i, dataParcela.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), valorTotalParcela);

               
                dataParcela = dataParcela.plusMonths(1);
            }

        } catch (DateTimeParseException | NumberFormatException e) {
            System.out.println("Erro na entrada de dados. Verifique se os dados estão no formato correto.");
        } finally {
            scanner.close();
        }
    }
}



