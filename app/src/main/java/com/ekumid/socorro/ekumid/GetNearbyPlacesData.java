package com.ekumid.socorro.ekumid;

import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.List;


public class GetNearbyPlacesData extends AsyncTask<Object, String, String> {

    String googlePlacesData;
    GoogleMap mMap;
    String url;

    @Override
    protected String doInBackground(Object... params) {
        try {
            Log.d("GetNearbyPlacesData", "doInBackground entered");
            mMap = (GoogleMap) params[0];
            url = (String) params[1];
            DownloadUrl downloadUrl = new DownloadUrl();
            googlePlacesData = downloadUrl.readUrl(url);
            Log.d("GooglePlacesReadTask", "doInBackground Exit");
        } catch (Exception e) {
            Log.d("GooglePlacesReadTask", e.toString());
        }
        return googlePlacesData;
    }

    @Override
    protected void onPostExecute(String result) {
        Log.d("GooglePlacesReadTask", "onPostExecute Entered");
        List<HashMap<String, String>> nearbyPlacesList = null;
        DataParser dataParser = new DataParser();
        nearbyPlacesList =  dataParser.parse(result);
        ShowNearbyPlaces(nearbyPlacesList);
        Log.d("GooglePlacesReadTask", "onPostExecute Exit");
    }

    private void ShowNearbyPlaces(List<HashMap<String, String>> nearbyPlacesList) {
        for (int i = 0; i < nearbyPlacesList.size(); i++) {
            Log.d("onPostExecute","Entered into showing locations");
            MarkerOptions markerOptions = new MarkerOptions();
            HashMap<String, String> googlePlace = nearbyPlacesList.get(i);
            double lat = Double.parseDouble(googlePlace.get("lat"));
            double lng = Double.parseDouble(googlePlace.get("lng"));
            String placeName = googlePlace.get("place_name");
            String vicinity = googlePlace.get("vicinity");
            LatLng latLng = new LatLng(lat, lng);
            if(MapsActivity.a==1){
                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_hospital));
            }else if(MapsActivity.a==2){
                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_ambulance));
            }else if(MapsActivity.a==3){
                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_toll));
            }else if(MapsActivity.a==4){
                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_rail));
            }else if(MapsActivity.a==5){
                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_bus));
            }else if(MapsActivity.a==6){
                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_petrol));
            }else if(MapsActivity.a==7){
                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_police));
            }else if(MapsActivity.a==8){
                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_mobile));
            }else if(MapsActivity.a==9){
                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_toilet));
            }else if(MapsActivity.a==10){
                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_dept));
            }else if(MapsActivity.a==11){
                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_resto));
            }
            markerOptions.position(latLng);
            markerOptions.title(placeName + " : " + vicinity);
            mMap.addMarker(markerOptions);
            //move map camera
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(13));
        }
    }



}
