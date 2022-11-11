package com.company;

public class Main {

    public static void main(String[] args) {
	    Spotify spotify = new Spotify();

        //LEGGO DA FILE LE CANZONI INSERITE
        String nomeFile = "C:\\Users\\utente\\Desktop\\Scuola\\Classe5\\INFORMATICA\\000_spotify\\dati1.csv";
        spotify.leggiCanzoni(nomeFile);

        //INSERIRE UNA NUOVA CANZONE
        //Canzone canzone = new Canzone(0, "titolo2", 1965, "artista", "album", Genere.JAZZ, 54, 647, 64 );

        //CERCARE UNA CANZONE IN BASE AL NOME E ALL'ARTISTA
        Canzone canzone_trovata = spotify.cercaCanzone_artistaTitolo("artista", "titolo");
        if (canzone_trovata != null) {
            System.out.println("Canzone trovata: " + canzone_trovata);
        } else {
            System.out.println("Canzone NON trovata: ");

        }
        //CERCARE UNA CANZONE IN BASE AL GENERE
        spotify.cercaCanzone_genere(Genere.JAZZ);
        //spotify.salva_file(nomeFile);

        //AGGIUNGO UNA CANZONE
        Canzone canzone1 = new Canzone(0, "titolo1", 1965, "artista1", "album1", Genere.METAL, 4, 456, 4 );
        spotify.aggiungiCanzone(canzone1);
        spotify.salva_file(nomeFile);

        Canzone canzone2 = new Canzone(0, "titolo2", 1965, "artista2", "album2", Genere.POP, 4584, 54, 238 );
        spotify.aggiungiCanzone(canzone2);

        //SALVA SU FILE
        spotify.salva_file(nomeFile);

        //MODIFICA RAITING
        spotify.modifica_raiting("artista2", "titolo2", 98);
        spotify.salva_file(nomeFile);
        spotify.leggiCanzoni(nomeFile);

        //ELIMINA CANZONE
        spotify.eliminaCanzone(canzone1);
        spotify.salva_file(nomeFile);
        spotify.leggiCanzoni(nomeFile);
    }
}

