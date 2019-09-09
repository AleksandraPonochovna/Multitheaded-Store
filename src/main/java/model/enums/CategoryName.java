package model.enums;

public enum CategoryName {

    VIDEO_PRODUCTS("video products"),
    MUSIC_PRODUCTS("music products"),
    DRESSES("dresses"),
    FOOTWEAR("footwear");

    protected String categoryTitle;

    CategoryName(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public static CategoryName fromString(String categoryTitle) {
        for (CategoryName condition : CategoryName.values()) {
            if (condition.categoryTitle.equalsIgnoreCase(categoryTitle)) {
                return condition;
            }
        }
        return FOOTWEAR;
    }

    public String toString() {
        return categoryTitle;
    }

}
