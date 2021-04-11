package com.krisa.data;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Car {
    @Id
    @SequenceGenerator(name = "carIdSeq")
    @GeneratedValue(generator = "carIdSeq")
    private Long carId;
    @Column
    private String model;
    @Column
    private Integer year;
    @Column
    private String color;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manufactureid", referencedColumnName = "manufacturerId", foreignKey = @ForeignKey(name = "manufacturerId_fk"))
    @JsonBackReference
    private Manufacturer manufacturer;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + carId + ", model='" + model + '\'' + ", year=" + year + ", color='" + color + '\''
                + '}';
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
