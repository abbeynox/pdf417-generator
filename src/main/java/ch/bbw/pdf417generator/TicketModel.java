package ch.bbw.pdf417generator;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TicketModel {
    private String surname;
    private String lastname;
    private String seatNumber;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date departureTime;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date arrivalTime;
    private String fromLocation;
    private String toLocation;
    private String flightNumber;
    private int gender;
    private String genderString;
    private String genderEmoji;
    private String gate;
    private String flightCompany;
    private BufferedImage pdf417Code;
    private String pdf417Image;
    private String timeNow;

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSeatNumber() {
        char[] letters =  {'A', 'B', 'C', 'D'};
        double randomLetter = Math.round(Math.random()*(4 - 1) + 1);
        char choosenLetter;
        if (randomLetter == 1) {
            choosenLetter = letters[0];
        }else if (randomLetter == 2) {
            choosenLetter = letters[1];
        }else if (randomLetter == 3) {
            choosenLetter = letters[2];
        }else if (randomLetter == 4) {
            choosenLetter = letters[3];
        }else {
            choosenLetter = letters[0];
        }
        System.out.println(choosenLetter + " wurde ausgewählt");
        seatNumber = Long.toString(Math.round((Math.random()*(90 - 1)) + 1)) + choosenLetter;
        System.out.println(seatNumber + " ist die SItznummer");
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Date getDepartureTime() {
        System.out.println(departureTime);
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getFlightNumber() {
        flightNumber = Long.toString(Math.round((Math.random()*(99999999 - 9999999)) + 9999999));
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getGenderstring() {
        if (this.gender == 1) {
            this.genderString = "M";
            this.genderEmoji = "\uD83D\uDE4D\u200D♂️";
        }
        else if (this.gender == 2) {
            this.genderString = "W";
            this.genderEmoji = "\uD83D\uDE4D\u200D♀️";
        }
        else if (this.gender == 3) {
            this.genderString = "D";
            this.genderEmoji = "\uD83D\uDE4E";
        }
        else {
            System.out.println("Es gab ein Problem mit der Auswahl des Geschlechts.");
        }
        return genderString;
    }

    public String getGenderEmoji() {
        return genderEmoji;
    }

    public void setGenderEmoji(String genderEmoji) {
        this.genderEmoji = genderEmoji;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getFlightCompany() {
        return flightCompany;
    }

    public void setFlightCompany(String flightCompany) {
        this.flightCompany = flightCompany;
    }

    public BufferedImage getPdf417Code() {
        return pdf417Code;
    }

    public void setPdf417Code(BufferedImage pdf417Code) {
        this.pdf417Code = pdf417Code;
    }

    public String getPdf417Image() {
        CodeGenerator generator = new CodeGenerator();

        generator.generateCode(this.surname + ' ' + this.lastname + ' ' + this.genderString + ' ' + this.seatNumber + ' ' + this.fromLocation + ' ' + this.toLocation); // Provisorisch
        return pdf417Image;
    }

    public void setPdf417Image(String pdf417Image) {
        this.pdf417Image = pdf417Image;
    }

    public String getTimeNow() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd, HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        timeNow = dtf.format(now);
        System.out.println(timeNow);
        return timeNow;

    }
    /*
    @Override
    public String toString() {
        return flightNumber + ' ' + surname + ' ' + lastname + ' ' + gender + ' ' + seatNumber + ' ' + departureTime + ' ' + arrivalTime + ' ' + fromLocation + ' ' + toLocation + ' ' + gate;
    } */

    @Override
    public String toString() { // Achtung: Da PDF417 nicht allzu grosser Speicherplatz, to String Methode möglichst kurz halten
        return
               surname + ' ' + lastname + ' ' + seatNumber + ' ' + fromLocation + ' ' + toLocation + ' '+ departureTime + ' ' + arrivalTime + ' ' + timeNow ;

    }
}
