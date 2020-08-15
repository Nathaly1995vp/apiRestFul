/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.nathaly.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nathaly
 */
@Entity
@Table(name = "PERSON")
@XmlRootElement
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 20)
    @Column(name = "IDENTIFICATION_NUMBER")
    private String identificationNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FULLNAME")
    private String fullName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BIRTH")
    @Temporal(TemporalType.DATE)
    private Date birth;

    @JoinColumn(name = "IDMOTHER", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Person idMother;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idMother")
    private Collection<Person> motherCollection;

    @JoinColumn(name = "IDFATHER", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Person idFather;
     @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idFather")
    private Collection<Person> fatherCollection;
     
    public Person() {
    }

    public void adopt(Person child) {
        if (child != null) {
            if (child.getIdFather() != null) {
                child.setIdFather(this);
            } else if (child.getIdMother() != null) {
                child.setIdMother(this);
            }
        }
    }

    public Person(Integer id, String identificationNumber, String fullName, Date Birth, Person idMother, Person idFather) {
        this.id = id;
        this.identificationNumber = identificationNumber;
        this.fullName = fullName;
        this.birth = Birth;
        this.idMother = idMother;
        this.idFather = idFather;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date Birth) {
        this.birth = Birth;
    }

    public Person getIdMother() {
        return idMother;
    }

    public void setIdMother(Person idMother) {
        this.idMother = idMother;
    }

    public Person getIdFather() {
        return idFather;
    }

    public void setIdFather(Person idFather) {
        this.idFather = idFather;
    }

    @XmlTransient
    public Collection<Person> getMotherCollection() {
        return motherCollection;
    }

    public void setMotherCollection(Collection<Person> motherCollection) {
        this.motherCollection = motherCollection;
    }

    @XmlTransient
    public Collection<Person> getFatherCollection() {
        return fatherCollection;
    }

    public void setFatherCollection(Collection<Person> fatherCollection) {
        this.fatherCollection = fatherCollection;
    }

}
