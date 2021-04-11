package com.krisa.data;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Manufacturer {
    @Id
    @SequenceGenerator(name = "manufacturerIdSeq")
    @GeneratedValue(generator = "manufacturerIdSeq")
    private Long manufacturerId;
    @Column
    @NotBlank
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "manufacturer")
    @JsonManagedReference
    private List<Car> cars;

    public Manufacturer() {
    }

    public Manufacturer(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Manufacture{" + "id=" + manufacturerId + ", name='" + name + "}";
    }

}
