package com.siguiendolaspatitas.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String photo;

    @NotNull(message="Se requiere un nombre")
	@Size(max=40, message="el nombre ingresado demasiado largo")
    private String name;

    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="especies")
    private String especie;

    @NotNull(message="Se requiere genero")
    private String gender;

    @NotNull(message="Se requiere una edad")
    private String age;

    @NotNull(message="Se requiere un tamaño")
    @Size(max=10, message="el tamaño ingresado demasiado largo")
    private String size;

    @NotNull(message="Se requiere un estado de salud y si tiene alguna otra observacion (pude ser sobre su salud o su comportamiento)")
    private String description;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="users")
    private User owner;
    
    @Column(updatable=false) 
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
		
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;

    public Pet() {
        // CONSTRUCTOR
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    @Override
    public String toString() {
        return "Pet [id=" + id + ", photo=" + photo + ", name=" + name + ", especie=" + especie + ", gender=" + gender + ", age=" + age + ", size=" + size + ", description=" + description + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
}

}
