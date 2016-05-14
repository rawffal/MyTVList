
package com.example.nahson.mytvlist.model.TVID;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class CreatedBy {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
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
