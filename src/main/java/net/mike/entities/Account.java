package net.mike.entities;

import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
@NamedQuery(name = "Account.getAll", query = "SELECT p FROM Account p")
public class Account implements Serializable {
	
	@Id
    @Column(name = "id")
	private int id;
	@Column(name = "email")
	private EmailField email;
	@Column(name = "password")
	private PasswordField password;
	@Column(name = "name")
	private String name;
	
	public EmailField getEmail() {
		return email;
	}
	public void setEmail(EmailField email) {
		this.email = email;
	}
	public PasswordField getPassword() {
		return password;
	}
	public void setPassword(PasswordField password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Account(EmailField email, PasswordField password, String name) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
	
	
	
}
