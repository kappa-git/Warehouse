public class Notebook extends Prodotto {
    public Notebook(String produttore, String modello, String descrizione,
                    double dimensioneDisplay, double dimensioneArchiviazione,
                    double prezzoAcquisto, double prezzoVendita, int id) {
        super("Notebook", produttore, modello, descrizione, dimensioneDisplay,
                dimensioneArchiviazione, prezzoAcquisto, prezzoVendita, id);
    }

}