package com.api.ornithology.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Entity
@Table(name = "Book_Ornithology")
public class OrnithologyModel implements Serializable {
    private final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="ID_GENERATOR", sequenceName="book_ornithology_id_seq",initialValue=1,allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_GENERATOR")
    private Long id;
    @Column(nullable = false, length = 10)
    private String ornithologyModel;

    @Column(nullable = false, length = 30)
    private String identifiedBird;
    @Column(nullable = false, length = 120)
    private String birdNamePIL;
    @Column(nullable = false, length = 50)
    private String birdSize;
    @Column(nullable = false, length = 20)
    private String genre;
    @Column(nullable = false, length = 200)
    private String birdNote;
    @Column(nullable = false, length = 20)
    private String birdColor;
    @Column(nullable = false)
    private String whereTheBirdWasSeen;
    @Column(nullable = false)
    private Date whenTheBirdWasSeen = new Date();

    @Column(nullable = false, length = 6)
    private Date dateTime = Calendar.getInstance(TimeZone.getTimeZone("pt-BR")).getTime();
    @Column(nullable = false, length = 30)
    private String habitat;
    @Column(nullable = false, length = 30)
    private String birdFamily;


    public OrnithologyModel() {

    }

    public long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrnithologyModel() {
        return ornithologyModel;
    }

    public void setOrnithologyModel(String ornithologyModel) {
        this.ornithologyModel = ornithologyModel;
    }

    public String getIdentifiedBird() {
        return identifiedBird;
    }

    public void setIdentifiedBird(String identifiedBird) {
        this.identifiedBird = identifiedBird;
    }

    public String getBirdNamePIL() {
        return birdNamePIL;
    }

    public void setBirdNamePIL(String birdNamePIL) {
        this.birdNamePIL = birdNamePIL;
    }

    public String getBirdSize() {
        return birdSize;
    }

    public void setBirdSize(String birdSize) {
        this.birdSize = birdSize;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getBirdNote() {
        return birdNote;
    }

    public void setBirdNote(String birdNote) {
        this.birdNote = birdNote;
    }

    public String getBirdColor() {
        return birdColor;
    }

    public void setBirdColor(String birdColor) {
        this.birdColor = birdColor;
    }

    public String getWhereTheBirdWasSeen() {
        return whereTheBirdWasSeen;
    }

    public void setWhereTheBirdWasSeen(String whereTheBirdWasSeen) {
        this.whereTheBirdWasSeen = whereTheBirdWasSeen;
    }

    public Date getWhenTheBirdWasSeen() {
        return whenTheBirdWasSeen;
    }

    public void setWhenTheBirdWasSeen(Date whenTheBirdWasSeen) {
        this.whenTheBirdWasSeen = whenTheBirdWasSeen;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getBirdFamily() {
        return birdFamily;
    }

    public void setBirdFamily(String birdFamily) {
        this.birdFamily = birdFamily;
    }
}
