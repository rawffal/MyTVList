
package com.example.nahson.mytvlist.model.SeasonNumber;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class GuestStar {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("credit_id")
    @Expose
    private String creditId;
    @SerializedName("character")
    @Expose
    private String character;
    @SerializedName("order")
    @Expose
    private int order;
    @SerializedName("profile_path")
    @Expose
    private String profilePath;

    /**
     * @return The id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The creditId
     */
    public String getCreditId() {
        return creditId;
    }

    /**
     * @param creditId The credit_id
     */
    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    /**
     * @return The character
     */
    public String getCharacter() {
        return character;
    }

    /**
     * @param character The character
     */
    public void setCharacter(String character) {
        this.character = character;
    }

    /**
     * @return The order
     */
    public int getOrder() {
        return order;
    }

    /**
     * @param order The order
     */
    public void setOrder(int order) {
        this.order = order;
    }

    /**
     * @return The profilePath
     */
    public String getProfilePath() {
        return profilePath;
    }

    /**
     * @param profilePath The profile_path
     */
    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

}
