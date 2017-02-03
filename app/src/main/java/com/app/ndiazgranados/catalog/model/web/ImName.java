
package com.app.ndiazgranados.catalog.model.web;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImName {

    @SerializedName("label")
    @Expose
    private String label;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ImName() {
    }

    /**
     * 
     * @param label
     */
    public ImName(String label) {
        this.label = label;
    }

    /**
     * 
     * @return
     *     The label
     */
    public String getLabel() {
        return label;
    }

    /**
     * 
     * @param label
     *     The label
     */
    public void setLabel(String label) {
        this.label = label;
    }

}
