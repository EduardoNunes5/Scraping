import entity.Product;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import scraper.Scraper;
import util.Util;

/**
 * Classe que contem o main do projeto.
 * A biblioteca utilizada para extrair dados da web foi a JSOUP.
 * Neste programa foi extraido dados de um produto do ecommerce chamado Carrefour,
 * como seu nome, preco, descricao e dados tecnicos.
 * */
public class Main {
    public static void main(String[] args) {

        String url = "https://www.carrefour.com.br/Maquina-de-Lavar-Electrolux-10-5Kg-Branca-Turbo-Economia-LAC11-110V/p/5112621";

        Document document = Scraper.search(url);

        String title = Scraper.searchTextByClassName(document,"title-product");
        String price = Scraper.searchTextByClassName(document, "priceBig");
        String description = Scraper.searchTextByClassName(document, "summary");
        Elements productInfo = Scraper.searchElementsByTag(document,"td");

        double castedPrice = Util.StringToDouble(price);
        Product product = new Product(title,castedPrice,description);

        addTechnicalInformation(productInfo, product);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(product);


    }

    /**
     * Usa o metodo de adicionar informacao tecnica de Produto.
     * Considerando que os dados tecnicos e sua descricoes sao separados por colunas no site
     * do carrefour, os dados e descricoes sao postos de 2 a 2 na colecao de Elementos da JSOUP.
     * @param productInfo Elements - colecao de elementos de marcacao de coluna html (TD)
     * @param prod Product - produto a ter as informacoes adicionadas.
     */
    public static void addTechnicalInformation(Elements productInfo, Product prod){
        for(int i = 0; i < productInfo.size()-1; i+=2){
            String currentInfo = productInfo.get(i).text();
            String currentInfoDescription = productInfo.get(i+1).text();
            prod.addTechInfo(currentInfo,currentInfoDescription);
        }
    }
}
