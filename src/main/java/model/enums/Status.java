package model.enums;

public enum Status {

    AVAILABLE("available"),
    ABSENT("absent"),
    EXPECTED("expected");

    protected String status;

    Status(String status) {
        this.status = status;
    }

    public static Status fromString(String name) {
        for (Status condition : Status.values()) {
            if (condition.status.equalsIgnoreCase(name)) {
                return condition;
            }
        }
        return AVAILABLE;
    }

    public String toString() {
        return status;
    }

}
