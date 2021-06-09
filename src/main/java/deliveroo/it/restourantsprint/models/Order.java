package deliveroo.it.restourantsprint.models;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "orders")
@SecondaryTables({ @SecondaryTable(name = "users") })
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @NotBlank
  @Size(max = 50)
  private String purchase_method;
  @NotBlank
  @Size(max = 50)
  private String purchase_status;

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;

  @NumberFormat(pattern = "#,##,###,###.##,#.#,##.#,###.#")
  @Column(name = "total_price", nullable = false)
  private BigDecimal totalPrice;

  @Column(name = "order_date")
  private Timestamp orderDate;
  @Size(max = 500)
  private String description;

  @Column(name = "items", columnDefinition = "json")
  private String items;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public BigDecimal getTotalPrice() {
    return this.totalPrice;
  }

  public void setTotalPrice(BigDecimal totalPrice) {
    this.totalPrice = totalPrice;
  }

  public String getPurchaseMethod() {
    return this.purchase_method;
  }

  public void setPurchaseMethod(String purchase_method) {
    this.purchase_method = purchase_method;
  }

  public String getPurchaseStatus() {
    return this.purchase_status;
  }

  public void setPurchaseStatus(String purchase_status) {
    this.purchase_status = purchase_status;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Timestamp getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Timestamp orderDate) {
    this.orderDate = orderDate;
  }

  public String getItems() {
    return this.items;
  }

  public void setItems(String items) {
    this.items = items;
  }

}
