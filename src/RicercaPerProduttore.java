public ArrayList<Prodotto> ricercaPerProduttore(String produttore) {
    ArrayList<Prodotto> risultati = new ArrayList<>();

        for (Prodotto prodotto : listaProdotti){
        if(prodotto.produttore.equalsIgnoreCase(produttore)){
        risultati.add(prodotto);
        }
        }

        if (risultati.isEmpty()) {
        System.out.println("Nessun dispositivo trovato per il produttore: " + produttore);
        }

        return risultati;
        }

