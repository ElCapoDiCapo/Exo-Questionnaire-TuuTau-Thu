public class Item {
    String question, réponse;

    public Item(String question, String réponse) {
        this.question = question;
        this.réponse = réponse;
    }

    @Override
    public String toString() {
        return "question='" + question + "\n" +
                "réponse='" + réponse + '\n';
    }

    public Boolean obtenirBonneReponse(){
        return true;
    }
}
