package com.example.demo.model;
import java.util.Date;

public class RFrameContent {
    private String frameId;
    private String contentId;
    private Date createdDate;
    private Date updatedDate;

    public RFrameContent() {
    }

    public RFrameContent(String frameId, String contentId, Date createdDate, Date updatedDate) {
        this.frameId = frameId;
        this.contentId = contentId;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public String getFrameId() {
        return frameId;
    }

    public void setFrameId(String frameId) {
        this.frameId = frameId;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
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
