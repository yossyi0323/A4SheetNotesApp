package app.server.model;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="r_contents")
public class RContents {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String contentRelationId;
    private String fromIds;
    private String toIds;
    private String lineType;
    private String text;
    private String fromPoint;
    private String toPoint;
    private Date createdDate;
    private Date updatedDate;

    // Constructors (you can generate getters and setters using your IDE or manually)

    public RContents() {
    }

    public RContents(String contentRelationId, String fromIds, String toIds, String lineType, String text,
                     String fromPoint, String toPoint, Date createdDate, Date updatedDate) {
        this.contentRelationId = contentRelationId;
        this.fromIds = fromIds;
        this.toIds = toIds;
        this.lineType = lineType;
        this.text = text;
        this.fromPoint = fromPoint;
        this.toPoint = toPoint;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    // Getters and setters (you can generate these using your IDE or manually)

    public String getContentRelationId() {
        return contentRelationId;
    }

    public void setContentRelationId(String contentRelationId) {
        this.contentRelationId = contentRelationId;
    }

    public String getFromIds() {
        return fromIds;
    }

    public void setFromIds(String fromIds) {
        this.fromIds = fromIds;
    }

    public String getToIds() {
        return toIds;
    }

    public void setToIds(String toIds) {
        this.toIds = toIds;
    }

    public String getLineType() {
        return lineType;
    }

    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFromPoint() {
        return fromPoint;
    }

    public void setFromPoint(String fromPoint) {
        this.fromPoint = fromPoint;
    }

    public String getToPoint() {
        return toPoint;
    }

    public void setToPoint(String toPoint) {
        this.toPoint = toPoint;
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

    // Other methods (e.g., toString, equals, hashCode) can be added as needed
}
