package com.game.items;

public class Item {
    private int Id;
    private int hpValue;
    private String type;
    private String itemName;
    private String description;
    private boolean keyItem = true;




    public Item(int id, int hpValue, String type, String itemName, String description, boolean keyItem) {
        Id = id;
        this.hpValue = hpValue;
        this.itemName = itemName;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Item{" +
                "Id=" + Id +
                ", hpValue=" + hpValue +
                ", type='" + type + '\'' +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", keyItem=" + keyItem +
                '}';
    }
}

