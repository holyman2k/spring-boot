package com.charliewu.common.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Charlie Wu on 2017-02-08.
 */
@Entity
public class Greeting {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String label;


    //
    // constructor
    //


    public Greeting() {}

    public Greeting(String label) {
        this.label = label;
    }

    //
    // getter and setters
    //

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
