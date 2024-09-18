package tecnica;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Questao3 {

    public static void main(String[] args) {
    	
        try (InputStream inputStream = Questao3.class.getClassLoader().getResourceAsStream("dados.json");
            BufferedReader leitor = new BufferedReader(new InputStreamReader(inputStream))) {

            StringBuilder conteudoJson = new StringBuilder();
            String linha;

            while ((linha = leitor.readLine()) != null) {
                conteudoJson.append(linha);
            }

            JSONArray arrayJson = new JSONArray(conteudoJson.toString());

            List<Double> valores = new ArrayList<>();

            for (int i = 0; i < arrayJson.length(); i++) {
                JSONObject objetoJson = arrayJson.getJSONObject(i);
                double valor = objetoJson.getDouble("valor");

                if (valor > 0) {
                    valores.add(valor);
                }
            }

            double menorValor = valores.stream().min(Double::compare).orElse(0.0);
            double maiorValor = valores.stream().max(Double::compare).orElse(0.0);

            double somaTotal = valores.stream().mapToDouble(Double::doubleValue).sum();
            double mediaMensal = somaTotal / valores.size();
            
            long diasAcimaMedia = valores.stream().filter(valor -> valor > mediaMensal).count();

            System.out.println(menorValor);
            System.out.println(maiorValor);
            System.out.println(diasAcimaMedia);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}