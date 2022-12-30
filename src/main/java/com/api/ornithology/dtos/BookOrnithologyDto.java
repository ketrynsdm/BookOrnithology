package com.api.ornithology.dtos;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class BookOrnithologyDto {

    @NotBlank
    private String ornithologyModel;

    @NotBlank
    @Size(min = 1, max = 30)
    private String identifiedBird;

    @NotBlank
    private String birdNamePIL;

    @NotBlank
    private String birdSize;

    @NotBlank
    private String genre;

    @NotBlank
    private String birdNote;

    @NotBlank
    private String birdColor;

    @NotBlank
    private String whereTheBirdWasSeen;

    @NotNull
    private Date whenTheBirdWasSeen;

    @NotBlank
    private String habitat;

    @NotBlank
    private String birdFamily;

    public BookOrnithologyDto() {

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
