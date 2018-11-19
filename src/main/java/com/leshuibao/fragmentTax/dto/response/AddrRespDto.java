package com.leshuibao.fragmentTax.dto.response;

public class AddrRespDto {
    private String id;
    private String address;
    private int addressee_type;
    private String addressee_id;

    public AddrRespDto() {
    }

    public AddrRespDto(String id, String address, int addressee_type, String addressee_id) {
        this.id = id;
        this.address = address;
        this.addressee_type = addressee_type;
        this.addressee_id = addressee_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAddressee_type() {
        return addressee_type;
    }

    public void setAddressee_type(int addressee_type) {
        this.addressee_type = addressee_type;
    }

    public String getAddressee_id() {
        return addressee_id;
    }

    public void setAddressee_id(String addressee_id) {
        this.addressee_id = addressee_id;
    }
}
