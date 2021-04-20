package stream_proje01;

public class Ogrenci {
    private String ad;
    private String soyad;
    private int yas;
    private double diplomaNotu;
    private String cinsiyet;

    public Ogrenci(String ad, String soyad, int yas, double diplomaNotu, String cinsiyet) {
        this.ad = ad;
        this.soyad = soyad;
        this.yas = yas;
        this.diplomaNotu = diplomaNotu;
        this.cinsiyet = cinsiyet;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public double getDiplomaNotu() {
        return diplomaNotu;
    }

    public void setDiplomaNotu(double diplimaNotu) {
        this.diplomaNotu = diplimaNotu;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    @Override
    public String toString() {
        return "ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", yaş=" + yas +
                ", diploma Notu=" + diplomaNotu +
                ", cinsiyet='" + cinsiyet + '\'';
    }
}
