/**
 * 
 */
package org.sdrc.childinfo.model;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */
public class NewsLetterModel {
	private int newsLetterId;

	private String newsTitle;

	private String newsMessage;

	public int getNewsLetterId() {
		return newsLetterId;
	}

	public void setNewsLetterId(int newsLetterId) {
		this.newsLetterId = newsLetterId;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsMessage() {
		return newsMessage;
	}

	public void setNewsMessage(String newsMessage) {
		this.newsMessage = newsMessage;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	private String createdDate;

	private String createdBy;
}
