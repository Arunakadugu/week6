package me.aruna.week6.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(unique=true)
    private String role;

    @ManyToMany(mappedBy = "roles",fetch=FetchType.LAZY)
    private Set<BankUserData> users;

    public UserRole(String role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<BankUserData> getUsers() {
        return users;
    }

    public void setUsers(Set<BankUserData> users) {
        this.users = users;
    }
}
