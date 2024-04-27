import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConversorMoneda {

    private String API_URL = "https://v6.exchangerate-api.com/v6/702baebb459f10e018777b56/latest/";

    public double conversor(String fromCurrency, String toCurrency, double amount) {
        try {
            URL url = new URL(API_URL + fromCurrency);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JsonObject jsonObject = new Gson().fromJson(response.toString(), JsonObject.class);
            double exchangeRate = jsonObject.getAsJsonObject("conversion_rates").get(toCurrency).getAsDouble();
            connection.disconnect();
            return amount * exchangeRate;
        } catch (IOException e) {
            System.out.println("Error al conectar con la API: " + e.getMessage());
            return -1; // Retornar un valor negativo para indicar un error
        }
    }
}
