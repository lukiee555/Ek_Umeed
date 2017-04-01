package com.ekumid.socorro.ekumid;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by lucky on 02-04-2017.
 */

public class nearestambulance {

    LatLng latLng;
    int distance;

    public nearestambulance(LatLng latLng, int distance) {
        this.latLng = latLng;
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
}
