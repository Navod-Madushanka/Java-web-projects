package com.navod.web.nmshop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String first_name;
    private String last_name;
    private String country_region;
    private String password;
    @Column(unique = true)
    private String email;
    private String email_verified_at;
    private String verification_code;
    private String phone_number;
    private String shipping_address;
    private String billing_address;
    private String postal_code;
    private boolean active;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "user_type")
    private UserType userType = UserType.USER;

    public User() {
    }

    public User(Long id, String username, String first_name, String last_name, String country_region, String password, String email, String email_verified_at, String verification_code, String phone_number, String shipping_address, String billing_address, String postal_code, boolean active, UserType userType) {
        this.id = id;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.country_region = country_region;
        this.password = password;
        this.email = email;
        this.email_verified_at = email_verified_at;
        this.verification_code = verification_code;
        this.phone_number = phone_number;
        this.shipping_address = shipping_address;
        this.billing_address = billing_address;
        this.postal_code = postal_code;
        this.active = active;
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCountry_region() {
        return country_region;
    }

    public void setCountry_region(String country_region) {
        this.country_region = country_region;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_verified_at() {
        return email_verified_at;
    }

    public void setEmail_verified_at(String email_verified_at) {
        this.email_verified_at = email_verified_at;
    }

    public String getVerification_code() {
        return verification_code;
    }

    public void setVerification_code(String verification_code) {
        this.verification_code = verification_code;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(String shipping_address) {
        this.shipping_address = shipping_address;
    }

    public String getBilling_address() {
        return billing_address;
    }

    public void setBilling_address(String billing_address) {
        this.billing_address = billing_address;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
