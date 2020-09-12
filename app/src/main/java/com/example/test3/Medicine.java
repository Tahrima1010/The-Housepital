package com.example.test3;

public class Medicine
{ private String name;
    private String dose;

    public Medicine()
    {

    }

    public Medicine(String name,String dose){
        this.name=name;
        this.dose=dose;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }
}
