import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorMoneda conversorMoneda = new ConversorMoneda();
        boolean running = true;

        while (running){

            System.out.println("*************************************************");
            System.out.println("----------------- Conversor de Moneda --------------------");

            System.out.println("""
                    Selecciones el tipó de conversion:
                    
                    1. USD a COP
                    2. COP a USD
                    3. BRL a USD
                    4. USD a BRL
                    5. salir""");

            System.out.println("Elige una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:
                    hacerConversion(conversorMoneda,"USD","COP");
                    break;
                case 2:
                    hacerConversion(conversorMoneda, "COP", "USD");
                    break;
                case 3:
                    hacerConversion(conversorMoneda,"BRL","USD");
                    break;
                case 4:
                    hacerConversion(conversorMoneda,"USD","BRL");
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("opcion no valida, por favor elige una opcion valida");



            }
        }
        System.out.println("Gracias por utilizar nuestra apicacion de conversion de moneda");

    }

    private static void hacerConversion(ConversorMoneda conversorMoneda, String fromCurrency, String toCurrency){
        Scanner scanner= new Scanner(System.in);
        System.out.println("ingrese la cantidad a convertir desde " + fromCurrency + " a " + toCurrency + ":");
        double amount = scanner.nextDouble();

        double monedaConvertida = conversorMoneda.conversor(fromCurrency,toCurrency,amount);
        if (monedaConvertida >= 0){
            System.out.println(amount +" " + fromCurrency + "equivale a " + monedaConvertida + " " + toCurrency);
        }else {
            System.out.println("hubo un error al convertir la moneda");
        }
    }
}
