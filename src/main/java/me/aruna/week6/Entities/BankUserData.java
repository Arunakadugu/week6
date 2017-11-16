package me.aruna.week6.Entities;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


@Entity

public class BankUserData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Email
    @NotEmpty
    private String userName;

    private String password;

    private String firstName;

    private String lastName;

    private boolean enabled;

    private String email;

    private String account;

    private String saving;

    private String primary;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<UserRole> roles;

    public BankUserData() {
        roles= new HashSet<UserRole>() ;

    }





    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSaving() {
        return saving;
    }

    public void setSaving(String saving) {
        this.saving = saving;
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }
    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public void addRoles(UserRole userRole)
    {
        roles.add(userRole);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
