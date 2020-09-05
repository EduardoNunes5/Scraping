package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Essa classe representa um produto. Todo produto possui
 * um preco, um nome, uma descricao e uma lista de informacoes tecnicas.
 */
public class Product {
    /** Preco do produto.  */
    private double price;
    /** Nome do produto.   */
    private String name;
    /** Descricao do produto. */
    private String description;
    /** Lista de informacoes tecnicas do produto.*/
    private List<TechnicalInformation> techInfo;

    /**
     * Construtor de um produto a partir de um nome, preco e descricao.
     * @param name String - Nome do produto.
     * @param price double - preco do produto.
     * @param description String - Descricao do produto.
     */
    public Product(String name, double price,String description) {
        this.price = price;
        this.name = name;
        this.description = description;
        techInfo = new ArrayList<>();
    }

    /**
     * Adiciona uma informacao tecnica ao produto a partir do nome da informacao tecnica e
     * uma descricao sobre este dado no produto.
     *
     * @param data String - nome da especificacao tecnica
     * @param description String - descricao da especificacao tecnica
     */
    public void addTechInfo(String data, String description){
        if(name.trim().equals("") || data.trim().equals("")) return;
        TechnicalInformation ti = new TechnicalInformation(data, description);
        if(!techInfo.contains(ti))
            this.techInfo.add(ti);
    }

    /**
     * Retorna a representacao textual de um produto.
     * @return String - representacao textual do produto.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome do produto: ");
        sb.append(this.name + "\n");
        sb.append("Preco: ");
        sb.append(this.price +"\n");
        sb.append("Descricao: ");
        sb.append(this.description + "\n\n\n");
        sb.append("------------DADOS ESPECIFICOS DO PRODUTO------------\n\n");
        String allTechInfo = "";
        for(TechnicalInformation ti : this.techInfo){
            allTechInfo += ti.toString();
        }

        return sb.toString() + allTechInfo;
    }

}
