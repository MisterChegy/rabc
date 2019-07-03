package com.chegy.model;
// Generated 2019-6-19 8:46:25 by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Position generated by hbm2java
 */
@Entity
@Table(name = "position", catalog = "rbac")
public class Position implements java.io.Serializable {

	private Integer id;
	private Depart depart;
	private Position position;
	private String pname;
	private Set<Salary> salaries = new HashSet<Salary>(0);
	private Set<Position> positions = new HashSet<Position>(0);
	
	
	public Position() {
	}

	public Position(String pname) {
		this.pname = pname;
	}

	public Position(Depart depart, Position position, String pname, Set<Salary> salaries, Set<Position> positions) {
		this.depart = depart;
		this.position = position;
		this.pname = pname;
		this.salaries = salaries;
		this.positions = positions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "depart_id")
	public Depart getDepart() {
		return this.depart;
	}

	public void setDepart(Depart depart) {
		this.depart = depart;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pid")
	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@Column(name = "pname", nullable = false, length = 8)
	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "position")
	public Set<Salary> getSalaries() {
		return this.salaries;
	}

	public void setSalaries(Set<Salary> salaries) {
		this.salaries = salaries;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "position")
	public Set<Position> getPositions() {
		return this.positions;
	}

	public void setPositions(Set<Position> positions) {
		this.positions = positions;
	}
	
	
	
}
