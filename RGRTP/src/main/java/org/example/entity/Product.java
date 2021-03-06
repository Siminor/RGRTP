package org.example.entity;


import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//автоматический генератор айди
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "number", nullable = true)
    private Integer number;
    @Column(name = "amount", nullable = true)
    private Integer amount;
    @Column(name = "type_of_product", nullable = true, length = 45)
    private String typeOfProduct;

    @ManyToOne
    @JoinColumn(name="id_staff", referencedColumnName = "id")
    private Seller seller;

    @ManyToOne
    @JoinColumn(name="id_reservation")
     private Basket basket;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }


    public String getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(String typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }

    public Basket getReservation() {
        return basket;
    }

    public void setReservation(Basket basket) {
        this.basket = basket;
    }

    public Seller getStaff() {
        return seller;
    }

    public void setStaff(Seller seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", number=" + number +
                ", amount=" + amount +
                ", typeOfProduct='" + typeOfProduct + '\'' +
                ", seller=" + seller +
                ", basket=" + basket +
                '}';
    }
}
