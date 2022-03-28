package uz.pdp.models;

import static uz.pdp.utils.BaseUtil.generateUniqueID;

public class Car {
    private String modeli;
    private String brand;
    private String yurganMasofasi;
    private int bakSigimi;
    private int bakdaBenzinMiqdori;
    private int yoqilgiSarfi;
    private String carNomer;
    private boolean yoniq=false;
    private String carId;

    public Car(String modeli, String brand, String yurganMasofasi, int bakSigimi, int bakdaBenzinMiqdori, int yoqilgiSarfi, String carNomer) {
        this.modeli = modeli;
        this.brand = brand;
        this.yurganMasofasi = yurganMasofasi;
        this.bakSigimi = bakSigimi;
        this.bakdaBenzinMiqdori = bakdaBenzinMiqdori;
        this.yoqilgiSarfi = yoqilgiSarfi;
        this.carNomer = carNomer;
    }

    public int getBakdaBenzinMiqdori() {
        return bakdaBenzinMiqdori;
    }

    public void setBakdaBenzinMiqdori(int bakdaBenzinMiqdori) {
        this.bakdaBenzinMiqdori = bakdaBenzinMiqdori;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public boolean isYoniq() {
        return yoniq;
    }

    public void setYoniq(boolean yoniq) {
        this.yoniq = yoniq;
    }


    public String getCarNomer() {
        return carNomer;
    }

    public void setCarNomer(String carNomer) {
        this.carNomer = carNomer;
    }


    private String id=generateUniqueID();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModeli() {
        return modeli;
    }

    public void setModeli(String modeli) {
        this.modeli = modeli;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYurganMasofasi() {
        return yurganMasofasi;
    }

    public void setYurganMasofasi(String yurganMasofasi) {
        this.yurganMasofasi = yurganMasofasi;
    }

    public int getBakSigimi() {
        return bakSigimi;
    }

    public void setBakSigimi(int bakSigimi) {
        this.bakSigimi = bakSigimi;
    }

    public int getYoqilgiSarfi() {
        return yoqilgiSarfi;
    }

    public void setYoqilgiSarfi(int yoqilgiSarfi) {
        this.yoqilgiSarfi = yoqilgiSarfi;
    }
}
