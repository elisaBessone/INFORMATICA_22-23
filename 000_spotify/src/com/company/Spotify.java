package com.company;

//enum: permette di definire un tipo, public enum genere e ci metto tutti i generi possibili (esempio un a costanza con diversi valori)

import java.util.*;
import java.io.*;

public class Spotify {
    Vector<Canzone> vector_canzoni;

    public Spotify(){
        vector_canzoni = new Vector<Canzone>();
    }

    //la funzione legge il file csv e salva in un vettore di canzoni tutte le canzoni inserite nel file.
    public void leggiCanzoni(String nomeFile){
        BufferedReader reader = null;
        String currentLine;
        Canzone canzoneTemp;
        vector_canzoni.clear();
        int cnt = 0;
        //l'apertuta del file può generare 2 eccezioni.
        try{
            reader = new BufferedReader(new FileReader(nomeFile));
            //finché legge una riga del file
            while ((currentLine = reader.readLine())!= null){
                //legge solo dalla prima riga per escludere l'intestazione
                if (cnt > 0){
                    //leggo da file, escludo prima riga
                    String[] riga = currentLine.split(",");

                    //estrapolo dati dal csv e li inserisco in variabili temporanee per poi creare l'oggetto.
                    int id = Integer.parseInt(riga[0]);
                    String titolo = riga[1];
                    int anno = Integer.parseInt(riga[2]);
                    String artista = riga[3];
                    String album = riga[4];
                    Genere genere = Genere.valueOf(riga[5]);
                    float raiting = Float.parseFloat(riga[6]);
                    float stream = Float.parseFloat(riga[7]);
                    float durata = Float.parseFloat(riga[8]);

                    //creo l'oggetto e lo aggiunto al vettore canzoneTemp
                    canzoneTemp = new Canzone(id, titolo, anno, artista, album, genere, raiting, stream, durata);
                    vector_canzoni.add(canzoneTemp);

                }
                cnt ++;
            }
            System.out.println("VETTORE CANZONI:\n" + vector_canzoni);
            reader.close();
        }
        catch (IOException e){
            System.out.println(e);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
    }

    public void bubbleSort() {
        for(int i = 0; i < vector_canzoni.size(); i++) {
            boolean flag = false;
            for(int j = 0; j < vector_canzoni.size()-1; j++) {
                //Se l' elemento j e maggiore del successivo allora
                //scambiamo i valori
                if(vector_canzoni.get(j).getId()>vector_canzoni.get(j+1).getId()) {
                    Canzone k = vector_canzoni.get(j);
                    vector_canzoni.set(j, vector_canzoni.get(j+1));
                    vector_canzoni.set(j+1, k);
                    flag=true; //Lo setto a true per indicare che é avvenuto uno scambio
                }
            }
            if(!flag) break; //Se flag=false allora vuol dire che nell' ultima iterazione
            //non ci sono stati scambi, quindi il metodo può terminare
            //poiché l' array risulta ordinato
        }
    }

    //la funzione aggiunge la canzone passata come parametro nel vettore
    public void aggiungiCanzone(Canzone canzone){
        bubbleSort();

        //imposto id
        canzone.setId(vector_canzoni.lastElement().getId() + 1);
        vector_canzoni.add(canzone);
        System.out.println("Canzone aggiunta: " + canzone);
    }


    //salva tutte le modifiche nel file
    public void salva_file(String nomeFile){
        BufferedWriter writer = null;
        int cnt;
        try{
            //intestazione file
            writer = new BufferedWriter(new FileWriter(nomeFile));
            writer.write("Id,Titolo,Anno,Artista,Album,Genere,Raiting,Stream,Durata");
            writer.newLine();
            //sovrascrivo il file
            for(cnt = 0; cnt < vector_canzoni.size(); cnt++){
                writer.write(vector_canzoni.get(cnt).toString());
                writer.newLine();
            }
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    //ricerca di una canzone in base all'artista e al titolo, viene restituita se trovata
    public Canzone cercaCanzone_artistaTitolo(String artista, String titolo){
        Canzone canzone_trovata = null;

        for (int i = 0; i < vector_canzoni.size(); i++){
            String[] riga = vector_canzoni.get(i).toString().split(",");

            //confronto la riga dell'artista e la riga del titolo in maiuscolo in modo da eviatare di non trovare una canzone scritta in camel case o con maiuscolo/minuscolo
            if (riga[3].toUpperCase(Locale.ROOT).equals(artista.toUpperCase(Locale.ROOT)) && riga[1].toUpperCase(Locale.ROOT).equals(titolo.toUpperCase(Locale.ROOT))) {
                int id = Integer.parseInt(riga[0]);
                int anno = Integer.parseInt(riga[2]);
                String album = riga[4];
                Genere genere = Genere.valueOf(riga[5]);
                float raiting = Float.parseFloat(riga[6]);
                float stream = Float.parseFloat(riga[7]);
                float durata = Float.parseFloat(riga[8]);

                canzone_trovata = new Canzone(id, titolo, anno, artista, album, genere, raiting, stream, durata);
            }
        }
        //se la canzone non è stata trovata restituisce null
        return canzone_trovata;
    }

    //ricerca della canzone in base al genere
    public void cercaCanzone_genere(Genere genere) {
        Vector<Canzone> vector_generi = new Vector<Canzone>();

        boolean trovato = false;
        for (int i = 0; i < vector_canzoni.size(); i++){
            String[] riga = vector_canzoni.get(i).toString().split(",");

            //confronto la riga del genere con la classe enum
            if (Genere.valueOf(riga[5]).equals(genere)){
                /*System.out.println("Ecco l'elemento trovato: ");
                System.out.println(vector_canzoni.get(i).toString());*/

                int id = Integer.parseInt(riga[0]);
                String titolo = riga[1];
                int anno = Integer.parseInt(riga[2]);
                String artista = riga[3];
                String album = riga[4];
                float raiting = Float.parseFloat(riga[6]);
                float stream = Float.parseFloat(riga[7]);
                float durata = Float.parseFloat(riga[8]);

                //aggiungo al vettore la canzone trovata
                vector_generi.add(new Canzone(id, titolo, anno, artista, album, genere, raiting, stream, durata));
                trovato = true;
            }
        }
        if(!trovato){
            System.out.println("Non ho trovato canzoni del genere " + genere + ".");
        } else {
            System.out.println(vector_generi);
        }
    }

    //modifica il raiting di una specifica canzone ricercandola e passando il nuovo raiting
    public void modifica_raiting(String artista, String titolo, float nuovo_raiting){
        Canzone canzoneTrovata = cercaCanzone_artistaTitolo(artista, titolo);
        //se non trovo la canzone --> messaggio di errore
        if (canzoneTrovata != null){
            canzoneTrovata.setRaiting(nuovo_raiting);
            System.out.println("Raiting della canzone ricercata: " + canzoneTrovata + " Modificato a: " + nuovo_raiting);
        } else {
            System.out.println("Non posso modificare il raiting perché non ho trovato la canzone ricercata.");
        }
    }

    //viene eliminata la canzone passata come parametro se essa è presente nel vettore.
    public void eliminaCanzone(Canzone canzone){
        int indice = -1;     //posizione dell'oggetto da eliminare
        for (int i = 0; i < vector_canzoni.size(); i++){
            //se l'oggetto è uguale, salvo l'indice e poi rimuovo
            if (vector_canzoni.get(i).equals(canzone)){
                indice = i;
            }
        }
        if (indice >= 0){
            System.out.println("Canzone rimossa: " + canzone);
            vector_canzoni.remove(indice);
        } else {
            System.out.println("non posso eliminare l'elemento perché non esiste.");
        }
    }
}