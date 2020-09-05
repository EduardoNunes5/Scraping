package entity;

import java.util.Objects;

/**
 * Classe que representa uma informacao tecnica de algum produto.
 * Toda informacao tecnica possui um nome e uma descricao sobre ela,
 * seja de estar ou nao presente no produto, ou qual o modelo utilizado pelo
 * produto.
 */
public class TechnicalInformation {

    /** Nome da informacao tecnica   */
    private String name;

    /** Descricao sobre a informacao tecnica no produto*/
    private String description;


    /**
     * Construtor de uma informacao tecnica a partir de seu nome e descricao.
     * @param name String - Nome da informacao tecnica.
     * @param description String - Descricao da informacao tecnica.
     */
    public TechnicalInformation(String name, String description){
        this.name = name;
        this.description = description;
    }

    /**
     * Representacao textual de uma informacao tecnica.
     * @return String - retorna uma representacao textual do proprio objeto.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.name + "   ---------   ");
        sb.append(this.description +'\n');
        return sb.toString();
    }

}
