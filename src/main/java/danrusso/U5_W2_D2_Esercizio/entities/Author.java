package danrusso.U5_W2_D2_Esercizio.entities;

import java.util.Random;

public class Author {
    private long id;
    private String name;
    private String surname;
    private String email;
    private String DOB;
    private String avatar;

    public Author(String name, String surname, String email, String DOB) {
        Random rand = new Random();
        this.id = rand.nextInt(1, 10000);
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.DOB = DOB;
        this.avatar = "https://ui-avatars.com/api/?name=" + name + "+" + surname;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", DOB='" + DOB + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
