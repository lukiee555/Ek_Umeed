package com.ekumid.socorro.ekumid;

/**
 * Created by lucky on 29-03-2017.
 */

public class ListItem {
    String PlaceName,Distance,Address,ImageUrl;

    public ListItem() {
    }

    public ListItem(String placeName,  String address, String imageUrl,String distance) {
        PlaceName = placeName;
        Address = address;
        ImageUrl = imageUrl;
        Distance=distance;
    }

    public String getPlaceName() {
        return PlaceName;
    }

    public void setPlaceName(String placeName) {
        PlaceName = placeName;
    }


    public String getDistance() {
        return Distance;
    }

    public void setDistance(String distance) {
        Distance = distance;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
