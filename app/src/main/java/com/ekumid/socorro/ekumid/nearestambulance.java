package com.ekumid.socorro.ekumid;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by lucky on 02-04-2017.
 */

public class nearestambulance {

    LatLng latLng;
    int distance;
    String name,mobile ,rc;

    public nearestambulance(LatLng latLng, String rc, String mobile, String name, int distance) {
        this.latLng = latLng;
        this.rc = rc;
        this.mobile = mobile;
        this.name = name;
        this.distance = distance;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }
}
