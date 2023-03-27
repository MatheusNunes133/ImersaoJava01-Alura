package org.api.requisicao;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.api.requisicao.models.ListMoviesModel;
import org.api.requisicao.models.MovieModel;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) throws Exception{

        // ============== Cria conexão e faz request ===========

        //Cria url de pesquisa na API
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";

        //Cria cliente http para conectar com o servidor da API
        HttpClient client = HttpClient.newHttpClient();

        //Cria requisição para a API
        HttpRequest request = HttpRequest.newBuilder(URI.create(url)).GET().build();

        //Manda requisição a API e Pega a resposta tratando como String
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //Refina código para resposta ficar em variável
        String bodyResponse = response.body();


        // =============== Extraindo informacoes da string retornada ==============

        //Configura variavel para transformar a String em um Objeto Java e Configura erros para propriedades desconhecidas
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //Mapeia a String recebida para o Objeto do Tipo ListMoviesModel
        ListMoviesModel movieList = objectMapper.readValue(bodyResponse, ListMoviesModel.class);

        //Retira informações requeridas para cada Objeto MovieModel dentro da lista do tipo ListMovieModel
        for( MovieModel movies : movieList.getItems()){
            System.out.println("\u001b[107m\u001b[30;1mFilme: "+movies.getTitle()+"\u001b[m");
            System.out.println("\u001b[34m\u001b[107;1mPoster: "+movies.getImage()+"\u001b[m");
            String quantStar = stars(movies.getImDbRating());
            System.out.println("\u001b[33m\u001b[107;1mAvaliacao: "+quantStar);
            System.out.println("\u001b[32mNota IMDB:"+movies.getImDbRating()+"\u001b[m");
            System.out.println();
        }
    }

    public static String stars(double imdbRating){
        int starNumber = (int) imdbRating;
        String star = "";
        for(int i = 0; i<starNumber; i++){
            star += "\uD83E\uDD29 ";
        }
        return star;
    }
}