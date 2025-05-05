package com.siguiendolaspatitas.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    

    @NotNull(message="Se requiere un nombre")
	@Size(max=40, message="el nombre ingresado demasiado largo")
	private String name;
	
	@NotNull(message="Se requiere un apellido")
	@Size(max=40, message="el apellido ingresado demasiado largo")
	private String lastName;
	
	@NotEmpty(message="Email is required.")
	@Email(message="Invalid email")
	private String email;
	
	@NotEmpty(message="Password is required.")
	@Size(min=6, message="Password needs at least 6 chars")
	private String password;
	
	@Transient
	@NotEmpty(message="Confirmation is required.")
	@Size(min=6, message="Confirmation needs at least 6 chars")
	private String confirm;

    @OneToMany(mappedBy="owner",fetch=FetchType.LAZY)
	private List<Pet> petsInAdoption;

    @Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;

    public User() {
        // CONSTRUCTOR
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
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

    public List<Pet> getPets() {
        return petsInAdoption;
    }
    public void setPets(List<Pet> petsInAdoption) {
        this.petsInAdoption = petsInAdoption;
    }
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", password="
                + password + ", confirm=" + confirm + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
            }
}
