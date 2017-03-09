package com.nixsolutions.model;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
@Entity
@Table(name = "document")
public class Document implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private Integer documentID;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "document_type_id", referencedColumnName = "document_type_id")
    private DocumentType documentType;
    @Column(name = "series")
    private String series;
    @Column(name = "number")
    private Integer number;
    @Column(name = "issued_by")
    private String issuedBy;
    @Column(name = "date_of_issue")
    private Date dateOfIssue;

    public Document() {
    }

    public Document(Integer documentID, DocumentType documentType, String series, Integer number, String issuedBy, Date dateOfIssue) {
        this.documentID = documentID;
        this.documentType = documentType;
        this.series = series;
        this.number = number;
        this.issuedBy = issuedBy;
        this.dateOfIssue = dateOfIssue;
    }

    public Integer getDocumentID() {
        return documentID;
    }

    public void setDocumentID(Integer documentID) {
        this.documentID = documentID;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentID=" + documentID +
                ", documentType=" + documentType +
                ", series='" + series + '\'' +
                ", number=" + number +
                ", issuedBy='" + issuedBy + '\'' +
                ", dateOfIssue=" + dateOfIssue +
                '}';
    }
}
