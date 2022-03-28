package uz.pdp.models;

public class OilMark {
   private String marka;
   private int narxi;

    public OilMark(String marka, int narxi) {
        this.marka = marka;
        this.narxi = narxi;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getNarxi() {
        return narxi;
    }

    public void setNarxi(int narxi) {
        this.narxi = narxi;
    }
}
