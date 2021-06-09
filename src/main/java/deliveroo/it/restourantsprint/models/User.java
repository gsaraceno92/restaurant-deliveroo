package deliveroo.it.restourantsprint.models;

import java.sql.Timestamp;

// import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotBlank
    @Column(unique = true, name = "phone_number")
    @Size(max = 30)
    private String phone;

    @Size(max = 100)
    private String address;

    @Size(max = 100)
    private String email;

    @Column(name = "date_creation")
    private Timestamp dateCreation;

    // @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
    // private Order order;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getDateCreation() {
      return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
      this.dateCreation = dateCreation;
    }
}