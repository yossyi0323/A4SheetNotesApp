package app.server.model;import java.util.Date;

public class TContent {
    private String contentId;
    private String contentType;
    private String body;
    private Date createdDate;
    private Date updatedDate;

    public TContent() {
    }

    public TContent(String contentId, String contentType, String body, Date createdDate, Date updatedDate) {
        this.contentId = contentId;
        this.contentType = contentType;
        this.body = body;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
