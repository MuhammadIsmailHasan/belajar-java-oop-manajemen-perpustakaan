package entity;

public enum TransactionStatus {

    ACTIVE ("Book is not return"),
    NONACTIVE ("Book already return");

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
