package net.mike.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="autopart")
@NamedQuery(name = "AutoPart.getAll", query = "SELECT p FROM AutoPart p")
public class AutoPart implements Serializable {
	
	/**
	 * 
	 */
	
	@Id
    @Column(name = "id")
	private int id;
	@Column(name="nomenklatura")
	private String nomenklatura;
	@Column(name="leaderCode")
	private String leaderCode;
	@Column(name="manufacturer")
	private String manufacturer;
	@Column(name="price")
	private String price;
	@Column(name="unit")
	private String unit;
	
	public AutoPart() {}
	
	public AutoPart(String nomenklatura, String leaderCode, String manufacturer, String price) {
		super();
		this.nomenklatura = nomenklatura;
		this.leaderCode = leaderCode;
		this.manufacturer = manufacturer;
		this.price = price;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String getLeaderCode() {
		return leaderCode;
	}
	public void setLeaderCode(String leaderCode) {
		this.leaderCode = leaderCode;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getNomenklatura() {
		return nomenklatura;
	}
	public void setNomenklatura(String nomenklatura) {
		this.nomenklatura = nomenklatura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((leaderCode == null) ? 0 : leaderCode.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((nomenklatura == null) ? 0 : nomenklatura.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		return result;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoPart other = (AutoPart) obj;
		if (id != other.id)
			return false;
		if (leaderCode == null) {
			if (other.leaderCode != null)
				return false;
		} else if (!leaderCode.equals(other.leaderCode))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (nomenklatura == null) {
			if (other.nomenklatura != null)
				return false;
		} else if (!nomenklatura.equals(other.nomenklatura))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		return true;
	}
	
}
