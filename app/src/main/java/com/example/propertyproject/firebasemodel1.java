package com.example.propertyproject;

public class firebasemodel1 {

    private String contractorfield;
    private String contractorname;
    private String contractorarea;
    private String contractornumber;
    private String contractorrate;

    public firebasemodel1()
    {

    }

    public firebasemodel1(String contractorfield, String contractorname, String contractorarea, String contractornumber, String contractorrate)
    {
        this.contractorfield = contractorfield;
        this.contractorname = contractorname;
        this.contractorarea = contractorarea;
        this.contractornumber = contractornumber;
        this.contractorrate = contractorrate;
    }

    public String getContractorfield() {
        return contractorfield;
    }

    public void setContractorfield(String contractorfield) {
        this.contractorfield = contractorfield;
    }

    public String getContractorname() {
        return contractorname;
    }

    public void setContractorname(String contractorname) {
        this.contractorname = contractorname;
    }

    public String getContractorarea() {
        return contractorarea;
    }

    public void setContractorarea(String contractorarea) {
        this.contractorarea = contractorarea;
    }

    public String getContractornumber() {
        return contractornumber;
    }

    public void setContractornumber(String contractornumber) {
        this.contractornumber = contractornumber;
    }

    public String getContractorrate() {
        return contractorrate;
    }

    public void setContractorrate(String contractorrate) {
        this.contractorrate = contractorrate;
    }
}
