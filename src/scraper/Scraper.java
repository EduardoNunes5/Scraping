package scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Classe que representa um 'raspador', ele faz uso da biblioteca
 * Jsoup para adquirir informacoes de um site na web
 */
public class Scraper {

    /**
     * Retorna um documento html adquirido a partir de uma url ou lanca uma excecao.
     * @param url String - url a ser buscada na web.
     * @return Document - documento da pagina web encontrada.
     */
    public static Document search(String url) {
        try{
            return Jsoup.connect(url).get();
        }
        catch(IOException ioe){
            throw new RuntimeException(ioe.getMessage());
        }
    }

    /**
     * Encontra o primeiro elemento de um elemento dado o nome de sua classe e retorna
     * seu texto ou null caso nao seja encontrado.
     * @param document Document - Documento html a procurar a palavra.
     * @param word String - Classe ou classes a ser procurada.
     * @return String - Retorna uma representacao textual de um elemento.
     */
    public static String searchTextByClassName(Document document, String word) {
        return document.getElementsByClass(word).first().text();
    }

    /**
     * Procura todos os elementos a partir da marcacao html de um elemento.
     *
     * Obs.: Dados de imagens nao sao recuperadas.
     * @param document Document - Documento html com os elementos procurados.
     * @param tag String - Marcacao html dos elementos a serem procurados.
     * @return Elements - Elementos HTML da biblioteca jsoup.
     */
    public static Elements searchElementsByTag(Document document, String tag){
        Elements elements = document.getElementsByTag(tag);
        for(int i = 0; i < elements.size(); i ++){
            Element currentElement = elements.get(i);
            if(currentElement.text().equalsIgnoreCase("Observações") || currentElement.text().equalsIgnoreCase("Imagem")){
                elements.remove(i);
            }
        }
        return elements;
    }

}
