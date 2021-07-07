package com.game.items;

public class Item {
    private int Id;
    private int hpValue;
    private String type;
    private String itemName;
    private String location;
    private String description;
    private boolean keyItem = false;


    //Default constructor for Jackson JSON objects
    public Item() {
        super();
    }

    public Item(int id, int hpValue, String type, String itemName, String location, String description, boolean keyItem) {
        Id = id;
        this.hpValue = hpValue;
        this.type = type;
        this.itemName = itemName;
        this.location = location;
        this.description = description;
        this.keyItem = keyItem;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getHpValue() {
        return hpValue;
    }

    public void setHpValue(int hpValue) {
        this.hpValue = hpValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isKeyItem() {
        return keyItem;
    }

    public void setKeyItem(boolean keyItem) {
        this.keyItem = keyItem;
    }

    @Override
    public String toString() {
        return "Item{" +
                "Id=" + Id +
                ", hpValue=" + hpValue +
                ", type='" + type + '\'' +
                ", itemName='" + itemName + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", keyItem=" + keyItem +
                '}';
    }
}

