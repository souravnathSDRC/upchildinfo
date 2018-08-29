/**
 * 
 */
package org.sdrc.childinfo.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */

@Entity
@Table(name="Image_Gallery")
public class ImageGallery implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int getGalleryId() {
		return galleryId;
	}

	public void setGalleryId(int galleryId) {
		this.galleryId = galleryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int galleryId;
	
	@Column(name="Image_Title")
	private String title;
	
	@Column(name="Image_Message")
	private String message;
	
	@Column(name="Image_Url")
	private String imageUrl;
	
	@Column(name="created_date")
	private Timestamp createdDate;
	
	@Column(name="created_by", length=100)
	private String createdBy;

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
}
