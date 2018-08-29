package org.sdrc.childinfo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the samikshya_user database table.
 * 
 */
@Entity
@Table(name="samikshya_user")
@NamedQuery(name="SamikshyaUser.findAll", query="SELECT s FROM SamikshyaUser s")
public class SamikshyaUser implements Serializable {
	private static final long serialVersionUID = 1L;
	private int userId;
	private String lastUpdatedBy;
	private Date lastUpdatedDate;
	private String userContactNo;
	private String userEmailId;
	private String userName;
	private boolean activationStatus;
	private List<SamikshyaUserRoleSchemeMapping> samikshyaUserRoleSchemeMappings;
	
	@Column(name="is_active")
	public boolean isActivationStatus() {
		return activationStatus;
	}


	public void setActivationStatus(boolean activationStatus) {
		this.activationStatus = activationStatus;
	}

	

	public SamikshyaUser() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	@Column(name="last_updated_by")
	public String getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_updated_date")
	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}


	@Column(name="user_contact_no")
	public String getUserContactNo() {
		return this.userContactNo;
	}

	public void setUserContactNo(String userContactNo) {
		this.userContactNo = userContactNo;
	}


	@Column(name="user_email_id")
	public String getUserEmailId() {
		return this.userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}


	@Column(name="user_name")
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	//bi-directional many-to-one association to SamikshyaUserRoleSchemeMapping
	@OneToMany(fetch = FetchType.LAZY,mappedBy="samikshyaUser",cascade = CascadeType.ALL)
	public List<SamikshyaUserRoleSchemeMapping> getSamikshyaUserRoleSchemeMappings() {
		return this.samikshyaUserRoleSchemeMappings;
	}

	public void setSamikshyaUserRoleSchemeMappings(List<SamikshyaUserRoleSchemeMapping> samikshyaUserRoleSchemeMappings) {
		this.samikshyaUserRoleSchemeMappings = samikshyaUserRoleSchemeMappings;
	}

	/**
	 * @return the isActive
	 */
//	@Column(name="is_active")
//	public boolean isActive() {
//		return isActive;
//	}


	/**
	 * @param isActive the isActive to set
	 */
//	public void setActive(boolean isActive) {
//		this.isActive = isActive;
//	}


	public SamikshyaUserRoleSchemeMapping addSamikshyaUserRoleSchemeMapping(SamikshyaUserRoleSchemeMapping samikshyaUserRoleSchemeMapping) {
		getSamikshyaUserRoleSchemeMappings().add(samikshyaUserRoleSchemeMapping);
		samikshyaUserRoleSchemeMapping.setSamikshyaUser(this);

		return samikshyaUserRoleSchemeMapping;
	}

	public SamikshyaUserRoleSchemeMapping removeSamikshyaUserRoleSchemeMapping(SamikshyaUserRoleSchemeMapping samikshyaUserRoleSchemeMapping) {
		getSamikshyaUserRoleSchemeMappings().remove(samikshyaUserRoleSchemeMapping);
		samikshyaUserRoleSchemeMapping.setSamikshyaUser(null);

		return samikshyaUserRoleSchemeMapping;
	}

}