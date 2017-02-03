
package com.app.ndiazgranados.catalog.model.web;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImContentType {

    @SerializedName("attributes")
    @Expose
    private Attributes__ attributes;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ImContentType() {
    }

    /**
     * 
     * @param attributes
     */
    public ImContentType(Attributes__ attributes) {
        this.attributes = attributes;
    }

    /**
     * 
     * @return
     *     The attributes
     */
    public Attributes__ getAttributes() {
        return attributes;
    }

    /**
     * 
     * @param attributes
     *     The attributes
     */
    public void setAttributes(Attributes__ attributes) {
        this.attributes = attributes;
    }

}
