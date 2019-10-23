package cn.stats.tjdk.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "daka")
public class Daka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String uid;

    private String tag;

    private Date date;

    private String inRange;

    public Daka(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInRange() {
        return inRange;
    }

    public void setInRange(String inRange) {
        this.inRange = inRange;
    }
}
