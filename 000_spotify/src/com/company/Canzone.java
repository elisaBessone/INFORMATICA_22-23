package com.company;

import java.util.Objects;

public class Canzone {
    private int id;
    private String titolo;
    private int anno;
    private String artista;
    private String album;
    private Genere genere;
    private float raiting;
    private float stream;
    private float durata;

    public Canzone(){
        this.id = 0;
        this.titolo = "";
        this.anno = 0;
        this.artista = "";
        this.album = "";
        this.genere = null;
        this.raiting = 0;
        this.stream = 0;
        this.durata = 0;
    }

    public Canzone(int id, String titolo, int anno, String artista, String album, Genere genere, float raiting, float stream, float durata){
        this.id = id;
        this.titolo = titolo;
        this.anno = anno;
        this.artista = artista;
        this.album = album;
        this.genere = genere;
        this.raiting = raiting;
        this.stream = stream;
        this.durata = durata;
    }

    @Override
    public String toString() {
        return (id + "," +titolo + "," + anno + "," + artista + "," + album + "," + genere + "," + raiting + "," + stream + "," + durata);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Canzone canzone = (Canzone) o;
        return id == canzone.id && anno == canzone.anno && Float.compare(canzone.raiting, raiting) == 0 && Float.compare(canzone.stream, stream) == 0 && Float.compare(canzone.durata, durata) == 0 && Objects.equals(titolo, canzone.titolo) && Objects.equals(artista, canzone.artista) && Objects.equals(album, canzone.album) && genere == canzone.genere;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titolo, anno, artista, album, genere, raiting, stream, durata);
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public float getRaiting() {
        return raiting;
    }

    public void setRaiting(float raiting) {
        this.raiting = raiting;
    }

    public float getStream() {
        return stream;
    }

    public void setStream(float stream) {
        this.stream = stream;
    }

    public float getDurata() {
        return durata;
    }

    public void setDurata(float durata) {
        this.durata = durata;
    }
}
