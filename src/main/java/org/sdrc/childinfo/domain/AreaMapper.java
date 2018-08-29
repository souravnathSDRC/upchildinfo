package org.sdrc.childinfo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the area_mapper database table.
 * 
 */
@Entity
@Table(name="area_mapper")
@NamedQuery(name="AreaMapper.findAll", query="SELECT s FROM AreaMapper s")
public class AreaMapper implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String childCode;
	private String parentCode;
	private String area_name;

	public AreaMapper() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Column(name="child_code")
	public String getChildCode() {
		return this.childCode;
	}

	public void setChildCode(String childCode) {
		this.childCode = childCode;
	}


	@Column(name="parent_code")
	public String getParentCode() {
		return this.parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	@Column(name="area_name")
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}

}