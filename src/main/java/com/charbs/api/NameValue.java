package com.charbs.api;

import java.io.Serializable;
//import javax.persistence.*;
//import javax.xml.bind.annotation.XmlRootElement;

//import java.util.Set;
 
//@Entity
//@NamedQuery(name = "findValue",
//            query = "SELECT nv " +
//                    "FROM name_value nv " +
//                    "WHERE nv.name = :name")
//@XmlRootElement
public class NameValue implements Serializable {
    private static final long serialVersionUID = 1L;
 
//    @Id
    private long id;
 
//    @Column(name="NAME")
    private String name;
 
//    @Column(name="VALUE")
    private String value;
 	 
//	    @OneToMany(mappedBy="customer", cascade={CascadeType.ALL})
//	    private Set<phonenumber> phoneNumbers;
 
    public long getId() {
        return this.id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getName() {
        return this.name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getValue() {
        return this.value;
    }
 
    public void setValue(String value) {
        this.value = value;
    }
}
