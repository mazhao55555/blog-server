package org.sang.bean;

import java.util.List;

public class Roles_User {
    private Long id;
    private List<Role> roles;
    private  List<User> users;

    @Override
    public String toString() {
        return "Roles_User{" +
                "id=" + id +
                ", roles=" + roles +
                ", users=" + users +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
