package ru.atf.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "ads")
public class Ads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    //ссылка
    private String link;
    //Название
    @Column(length = 500)
    private String name;
    //текст
    @Column(length = 2000, nullable = true)
    private String content;
    //телефон
    @Column(length = 50000, nullable = true)
    private String phone;
    //дата добавления
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(nullable = true)
    private String profileLink;

    @Column(nullable = true)
    private String profileName;
    /*@ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name = "profile_id")//, referencedColumnName = "id"
    private Profile profile;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }*/ //Не работает рекурсивно

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProfileLink() {
        return profileLink;
    }

    public void setProfileLink(String profileLink) {
        this.profileLink = profileLink;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    @Override
    public String toString() {
        return "Ads{" +
                "id=" + id +
                ", link='" + link + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", phone='" + phone + '\'' +
                ", date=" + date +
                ", profileLink='" + profileLink + '\'' +
                ", profileName='" + profileName + '\'' +
                '}';
    }
}
