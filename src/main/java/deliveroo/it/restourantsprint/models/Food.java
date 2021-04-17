package deliveroo.it.restourantsprint.models;

import java.math.BigDecimal;
import java.net.URI;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "foods")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(unique = true)
    @Size(max = 50)
    private String name;

    @NotBlank
    @NumberFormat(pattern = "#,##,###,###.##,#.#,##.#,###.#")
    private BigDecimal price;

    @Size(max = 100)
    private String category;
    @Size(max = 500)
    private String ingredients;

    @Size(max = 200)
    private String description;
    private URI image_url;
    private Boolean available;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setUri(URI image_url) {
        this.image_url = image_url;
    }

    public URI getUri() {
        return this.image_url;
    }

    public Boolean getAvailable() {
        return this.available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
