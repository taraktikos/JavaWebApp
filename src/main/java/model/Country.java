package model;

public class Country {

    private int id;
    private String name;
    private String code;
    private String longCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLongCode() {
        return longCode;
    }

    public void setLongCode(String longCode) {
        this.longCode = longCode;
    }
}
