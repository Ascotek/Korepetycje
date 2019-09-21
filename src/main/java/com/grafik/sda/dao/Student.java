package com.grafik.sda.dao;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;
    String imie;
    String nazwisko;
    int klasa;

    @Enumerated(EnumType.STRING)
    Przedmiot przedmiot;

    public Student(String imie, String nazwisko, int klasa, Przedmiot przedmiot) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.klasa = klasa;
        this.przedmiot = przedmiot;
    }


    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Przedmiot getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(Przedmiot przedmiot) {
        this.przedmiot = przedmiot;
    }

    public int getKlasa() {
        return klasa;
    }

    public void setKlasa(int klasa) {
        this.klasa = klasa;
    }
}
