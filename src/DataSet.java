public class DataSet {
    private String type;
    private int place;
    private int time;
    private String name;
    private String country;

    public DataSet(String ty, int p,int ti, String n, String c) {
        type = ty;
        place = p;
        time = ti;
        name = n;
        country = c;
    }
    public String getType() {
        return type;
    }
    public int getPlacement() {
        return place;
    }
    public int getTime() {
        return time;
    }
    public String getName() {
        return name;
    }
    public String getCountry() {
        return country;
    }
}
