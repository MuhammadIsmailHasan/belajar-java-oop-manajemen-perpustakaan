package entity;

public enum TransactionStatus {

    ACTIVE ("Book has been borrowing"),
    NONACTIVE ("Book was returned");

    private String description;

    TransactionStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
