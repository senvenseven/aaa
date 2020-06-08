package shuben;

import java.sql.Date;

public class Literature{
	private long id;
	private String author;
	private String title;
	private String category;
	private String publisher;
	private Date publishTime;
	private String volumeNumber;
	private String issueNumber;
	private long citedNumber;
	public void setId(long id) {
	      this.id=id;
	}
	public void setAuthor(String author) {
	      this.author=author;
	}
	public void setTitle(String title) {
	      this.title=title;
	}
	public void setCategory(String category) {
	      this.category=category;
	}
	public void setPublisher(String publisher) {
	      this.publisher=publisher;
	}
	public void setPublishTime(Date publishTime) {
	      this.publishTime=publishTime;
	}
	public void setVolumeNumber(String volumeNumber) {
	      this.volumeNumber=volumeNumber;
	}
	public void setIssueNumber(String issueNumber) {
	      this.issueNumber=issueNumber;
	}
	public void setCitedNumber(long citedNumber) {
	      this.citedNumber=citedNumber;
	}
	public long getId() {
	      return id;
	}
	public String getAuthor() {
	      return author;
	}
	public String getTitle() {
	      return title;
	}
	public String getCategory() {
	      return category;
	}
	public String getPublisher() {
	      return publisher;
	}
	public Date getPublishTime() {
	      return publishTime;
	}
	public String getVolumeNumber() {
	      return volumeNumber;
	}
	public String getIssueNumber() {
	      return issueNumber;
	}
	public long getCitedNumber() {
	      return citedNumber;
	}
}
