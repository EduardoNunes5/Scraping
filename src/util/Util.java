package util;

/**
 * Classe de utilidades
 */
public class Util {

    /**
     * Faz uma conversao monetaria  REAL-BR de String para Double.
     * Remove R $ caso houver, tira todos os pontos e substitui virgula por ponto, assim parseando
     * para double.
     * *
     * @param money String - representacao monetaria em real.
     * @return Double - representacao do real em double.
     */
    public static Double StringToDouble(String money){
        money =money.replace("R", "");
        money = money.replace("$", "");
        money = money.trim();
        money = money.replaceAll("\\.", "");
        money = money.replace(",", ".");
        return Double.parseDouble(money);
    }
}
