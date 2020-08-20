package com.example.test3;


//To store the data of the List, we will use a data model class.
public class Model {
    String title;
    String description;
    int icon;//id hisabe store hoy
    //constructor initialize attributes
    public Model(String title,String description,int icon)
    {
        this.title=title;
        this.description=description;
        this.icon=icon;
    }
    //use getters method to get those attributes
    public String getTitle() {
        return this. title;
    }

    public String getDescription() {
        return this.description;
    }

    public int getIcon() {

        return this.icon;
    }
}



