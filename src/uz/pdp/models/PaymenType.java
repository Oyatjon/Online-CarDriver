package uz.pdp.models;

import static uz.pdp.utils.BaseUtil.generateUniqueID;

public class PaymenType {
    private String name;
    private int miqdori;
    private String id=generateUniqueID();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PaymenType(String name, int miqdori) {
        this.name = name;
        this.miqdori = miqdori;
    }

    public PaymenType(String name) {
        this.name = name;
    }

    public int getMiqdori() {
        return miqdori;
    }

    public void setMiqdori(int miqdori) {
        this.miqdori = miqdori;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
