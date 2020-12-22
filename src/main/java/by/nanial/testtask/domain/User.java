package by.nanial.testtask.domain;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class User implements Serializable {

    static final long SerialVersionUID = 3707L;
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String name;
    private String surname;
    private String email;
    private List<String> phoneNumbers;
    private List<Role> roles;

    public User() {
        this.id = count.incrementAndGet();
    }

    public User(String name, String surname, String email, List<String> phoneNumbers,
                List<Role> roles) {
        this.id = count.incrementAndGet();
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
        this.roles = roles;
    }
    public User(String name, String surname,  List<String> phoneNumbers,
                List<Role> roles) {
        this.id = count.incrementAndGet();
        this.name = name;
        this.surname = surname;
        this.phoneNumbers = phoneNumbers;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getId() != user.getId()) return false;
        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        if (getSurname() != null ? !getSurname().equals(user.getSurname()) : user.getSurname() != null) return false;
        if (getEmail() != null ? !getEmail().equals(user.getEmail()) : user.getEmail() != null) return false;
        if (getPhoneNumbers() != null ? !getPhoneNumbers().equals(user.getPhoneNumbers()) : user.getPhoneNumbers() != null)
            return false;
        return getRoles() != null ? getRoles().equals(user.getRoles()) : user.getRoles() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPhoneNumbers() != null ? getPhoneNumbers().hashCode() : 0);
        result = 31 * result + (getRoles() != null ? getRoles().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                ", roles=" + roles +
                '}';
    }
}
