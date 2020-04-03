package com.example.whiteboardnew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckParkingActivity extends AppCompatActivity implements OnMapReadyCallback {

    private final String PARKING_SOUTH_1 = "Elliott Jaques Parking";  // new LatLng(51.532335, -0.467996)
    private final String PARKING_SOUTH_2 = "Russell Parking";  // new LatLng(51.531698, -0.468975)
    private final String PARKING_SOUTH_3 = "South loop road parking";  // new LatLng(51.530907, -0.471785)
    private final String PARKING_SOUTH_4 = "Medical Centre/Tower D parking ";  // new LatLng(51.531023, -0.472384)
    private final String PARKING_SOUTH_5 = "Joseph Lowe/Tower C Parking";  // new LatLng(51.530973, -0.472250)
    private final String PARKING_SOUTH_6 = "Wilfred Brown Parking";  // new LatLng(51.531793, -0.475562)
    private final String PARKING_SOUTH_7 = "Gaskell Parking";  // new LatLng(51.532899, -0.477520)
    private final String PARKING_NORTH_1 = "Chadwick Parking";  // new LatLng(51.533773, -0.478987)
    private final String PARKING_NORTH_2 = "Topping Lane Parking";  // new LatLng(51.533880, -0.477136)
    private final String PARKING_NORTH_3 = "Heinz Wolff Parking";  // new LatLng(51.534443, -0.475392)
    private final String PARKING_NORTH_4 = "North Loop Road Parking";  // new LatLng(51.534562, -0.473971)
    private final String PARKING_NORTH_5 = "Bragg Parking";  // new LatLng(51.534746, -0.472576)
    private final String PARKING_NORTH_6 = "Wolfson Centre Parking";  // new LatLng(51.534532, -0.472266)
    private final String PARKING_NORTH_7 = "The Quad Parking";  // new LatLng(51.533785, -0.471722)
    private final String PARKING_NORTH_8 = "St Johns Parking";  // new LatLng(51.534059, -0.470679)
    private final String PARKING_NORTH_9 = "Eastern Gateway Parking";  // new LatLng(51.534137, -0.470028)

    private final LatLng PARKING_SOUTH_1_LATLNG = new LatLng(51.532335, -0.467996);
    private final LatLng PARKING_SOUTH_2_LATLNG = new LatLng(51.531698, -0.468975);
    private final LatLng PARKING_SOUTH_3_LATLNG = new LatLng(51.530907, -0.471785);
    private final LatLng PARKING_SOUTH_4_LATLNG = new LatLng(51.531023, -0.472384);
    private final LatLng PARKING_SOUTH_5_LATLNG = new LatLng(51.530973, -0.472250);
    private final LatLng PARKING_SOUTH_6_LATLNG = new LatLng(51.533026, -0.474711);
    private final LatLng PARKING_SOUTH_7_LATLNG = new LatLng(51.532899, -0.477520);
    private final LatLng PARKING_NORTH_1_LATLNG = new LatLng(51.533773, -0.478987);
    private final LatLng PARKING_NORTH_2_LATLNG = new LatLng(51.533880, -0.477136);
    private final LatLng PARKING_NORTH_3_LATLNG = new LatLng(51.534443, -0.475392);
    private final LatLng PARKING_NORTH_4_LATLNG = new LatLng(51.534562, -0.473971);
    private final LatLng PARKING_NORTH_5_LATLNG = new LatLng(51.534746, -0.472576);
    private final LatLng PARKING_NORTH_6_LATLNG = new LatLng(51.534532, -0.472266);
    private final LatLng PARKING_NORTH_7_LATLNG = new LatLng(51.533785, -0.471722);
    private final LatLng PARKING_NORTH_8_LATLNG = new LatLng(51.534059, -0.470679);
    private final LatLng PARKING_NORTH_9_LATLNG = new LatLng(51.534137, -0.470028);

    private final int TERRAIN_ELEVATION = 40; // Meters
    private Spinner sItems;
    private GoogleMap mMap;
    private Map<String, LatLng[]> parkingMap;
    private Map<LatLng, String> coordsWithNames;
    private Map<String, LatLng> buildingCoord;

    private void init() {
        sItems = findViewById(R.id.Select_Building);

        parkingMap = new HashMap<>();
        coordsWithNames = new HashMap<>();
        buildingCoord = new HashMap<>();

        coordsWithNames.put(PARKING_SOUTH_1_LATLNG, PARKING_SOUTH_1);
        coordsWithNames.put(PARKING_SOUTH_2_LATLNG, PARKING_SOUTH_2);
        coordsWithNames.put(PARKING_SOUTH_3_LATLNG, PARKING_SOUTH_3);
        coordsWithNames.put(PARKING_SOUTH_4_LATLNG, PARKING_SOUTH_4);
        coordsWithNames.put(PARKING_SOUTH_5_LATLNG, PARKING_SOUTH_5);
        coordsWithNames.put(PARKING_SOUTH_6_LATLNG, PARKING_SOUTH_6);
        coordsWithNames.put(PARKING_SOUTH_7_LATLNG, PARKING_SOUTH_7);
        coordsWithNames.put(PARKING_NORTH_1_LATLNG, PARKING_NORTH_1);
        coordsWithNames.put(PARKING_NORTH_2_LATLNG, PARKING_NORTH_2);
        coordsWithNames.put(PARKING_NORTH_3_LATLNG, PARKING_NORTH_3);
        coordsWithNames.put(PARKING_NORTH_4_LATLNG, PARKING_NORTH_4);
        coordsWithNames.put(PARKING_NORTH_5_LATLNG, PARKING_NORTH_5);
        coordsWithNames.put(PARKING_NORTH_6_LATLNG, PARKING_NORTH_6);
        coordsWithNames.put(PARKING_NORTH_7_LATLNG, PARKING_NORTH_7);
        coordsWithNames.put(PARKING_NORTH_8_LATLNG, PARKING_NORTH_8);

        parkingMap.put("Marry Seacole", new LatLng[]{PARKING_SOUTH_1_LATLNG, PARKING_SOUTH_2_LATLNG});                  // "Marry Seacole"            51.532737, -0.468488 (LatLng)  PS1 - 121 feets; PS2 - 328 feets
        parkingMap.put("Russel", new LatLng[]{PARKING_SOUTH_1_LATLNG, PARKING_SOUTH_2_LATLNG});                         // "Russel"                   51.532118, -0.468417 (LatLng)  PS1 - 79 feets; PS2 - 528 feets
        parkingMap.put("Elliott Jaques", new LatLng[]{PARKING_SOUTH_1_LATLNG, PARKING_SOUTH_2_LATLNG});                 // "Elliott Jaques"           51.532345, -0.467581 (LatLng) PS1 - 164 feets PS2 - 528 feets
        parkingMap.put("AMPC", new LatLng[]{PARKING_SOUTH_1_LATLNG, PARKING_SOUTH_2_LATLNG});                           // "AMPC"                     51.531266, -0.468566 (LatLng) PS1 - 528 feets PS2 - 223 feets
        parkingMap.put("Gardiner", new LatLng[]{PARKING_SOUTH_1_LATLNG, PARKING_SOUTH_2_LATLNG});                       // "Gardiner"                 51.531427, -0.467942, (LatLng) PS1 - 364 feets PS2 - 1056 feets
        parkingMap.put("AMCC", new LatLng[]{PARKING_SOUTH_1_LATLNG, PARKING_SOUTH_2_LATLNG});                           // "AMCC"                     51.531408, -0.467204, (LatLng) PS1 - 469 feets PS2 - 1056 feets
        parkingMap.put("Medical Centre", new LatLng[]{PARKING_SOUTH_3_LATLNG, PARKING_SOUTH_4_LATLNG});                 // "Medical Centre"           51.531853, -0.472270, (LatLng) PS3 - 100 feets PS4 - 36 feets
        parkingMap.put("Tower D", new LatLng[]{PARKING_SOUTH_3_LATLNG, PARKING_SOUTH_4_LATLNG});                        // "Tower D,                  51.531477, -0.472633, (LatLng) PS3 - 84 feets PS4 - 23 feets
        parkingMap.put("Tower C", new LatLng[]{PARKING_SOUTH_4_LATLNG, PARKING_SOUTH_5_LATLNG});                        // "Tower C,                  51.531357, -0.473048, (LatLng) PS4 - 23 feets PS5 - 36 feets
        parkingMap.put("Joseph Lowe", new LatLng[]{PARKING_SOUTH_4_LATLNG, PARKING_SOUTH_5_LATLNG});                    // "Joseph Lowe,              51.530887, -0.473897, (LatLng) PS4 - 528 feets PS5 - 125 feet
        parkingMap.put("Antonin Artaud", new LatLng[]{PARKING_SOUTH_5_LATLNG, PARKING_SOUTH_6_LATLNG});                 // "Antonin Artuad,           51.530949, -0.474806, (LatLng) PS5 - 1056 feets PS6 - 65 feet
        parkingMap.put("Tower B", new LatLng[]{PARKING_SOUTH_5_LATLNG, PARKING_SOUTH_6_LATLNG});                        // "Tower B,                  51.531374, -0.474360, (LatLng) PS5 - 1056 feets PS6 - 50 feet
        parkingMap.put("Tower A", new LatLng[]{PARKING_SOUTH_5_LATLNG, PARKING_SOUTH_6_LATLNG});                        // "Tower A,                  51.531955, -0.474006, (LatLng) PS5 - 1584 feets PS6 - 30 feet
        parkingMap.put("Howell", new LatLng[]{PARKING_SOUTH_5_LATLNG, PARKING_SOUTH_6_LATLNG});                         // "Howell,                   51.531955, -0.474006, (LatLng) PS5 - 62 feets PS6 - 35 feet
        parkingMap.put("Marle Jahoda", new LatLng[]{PARKING_SOUTH_7_LATLNG, PARKING_NORTH_2_LATLNG});                   // "Marle Jahoda,             51.532988, -0.476617, (LatLng) PS7 - 63 feets PN2 - 528 feet
        parkingMap.put("Gaskell", new LatLng[]{PARKING_SOUTH_7_LATLNG, PARKING_NORTH_1_LATLNG});                        // "Gaskell,                  51.532950, -0.477679, (LatLng) PS7 - 70 feets PN1 - 1056 feet
        parkingMap.put("Chadwick", new LatLng[]{PARKING_SOUTH_7_LATLNG, PARKING_NORTH_1_LATLNG});                       // "Chadwick,                 51.532840, -0.478345, (LatLng) PS7 - 62 feets PN1 - 1056 feet
        parkingMap.put("Heinz Wolff", new LatLng[]{PARKING_NORTH_3_LATLNG, PARKING_NORTH_4_LATLNG});                    // "Heinz Wolf,               51.534103, -0.474944, (LatLng) PN3 - 112 feets PN4 - 110 feet
        parkingMap.put("Design & Print Service", new LatLng[]{PARKING_NORTH_3_LATLNG, PARKING_NORTH_4_LATLNG});         // "Design & Print Service,   51.534103, -0.474944, (LatLng) PN3 - 135 feets PN4 - 130 feet
        parkingMap.put("Bragg", new LatLng[]{PARKING_NORTH_4_LATLNG, PARKING_NORTH_5_LATLNG});                          // "Bragg,                    51.534563, -0.473067, (LatLng) PN4 - 75 feets PN5 - 40 feet
        parkingMap.put("Wolfson centre", new LatLng[]{PARKING_NORTH_5_LATLNG, PARKING_NORTH_6_LATLNG});                 // "Wolfson centre,           51.534563, -0.473067, (LatLng) PN4 - 75 feets PN5 - 40 feet
        parkingMap.put("Quad North", new LatLng[]{PARKING_NORTH_5_LATLNG, PARKING_NORTH_6_LATLNG});                     // "Quad North,               51.533809, -0.472703, (LatLng) PN5 - 528 feets PN6 - 1584 feet
        parkingMap.put("The Quad", new LatLng[]{PARKING_NORTH_6_LATLNG, PARKING_NORTH_7_LATLNG});                       // "The Quad,                 51.533426, -0.472035, (LatLng) PN6 - 1056 feets PN7 - 44 feet
        parkingMap.put("St Johns", new LatLng[]{PARKING_NORTH_7_LATLNG, PARKING_NORTH_8_LATLNG});                       // "St Johns,                 51.534435, -0.469519, (LatLng) PN7 - 1056 feets PN8 - 40 feet
        parkingMap.put("Eastern Gateway", new LatLng[]{PARKING_NORTH_8_LATLNG, PARKING_NORTH_9_LATLNG});                // "Eastern Gateway,          51.533412, -0.468692, (LatLng) PN8 - 528 feets PN9 - 50 feet/
        parkingMap.put("Wilfred Brown", new LatLng[]{PARKING_SOUTH_6_LATLNG});                                          // "Wilfred Brown,            51.532670, -0.475400, (LatLng) PN6 - 224 feets
        parkingMap.put("Micheal Sterling", new LatLng[]{PARKING_SOUTH_6_LATLNG});                                       // "Micheal Sterling,         51.534563, -0.473067, (LatLng) PN6 - 528 feets
        parkingMap.put("Bannerman Centre", new LatLng[]{PARKING_SOUTH_6_LATLNG});                                       // "Bannerman Centre,         51.532894, -0.474158, (LatLng) PN6 - 1056 feets PN5 -
        parkingMap.put("Lecture Centre", new LatLng[]{PARKING_SOUTH_6_LATLNG});                                         // "Lecture Centre,           51.532869, -0.472884, (LatLng) PN6 - 1300 feets
        parkingMap.put("Arts centre", new LatLng[]{PARKING_SOUTH_6_LATLNG});                                            // "Arts centre,              51.532995, -0.472094, (LatLng) PN6 - 1505 feets

        buildingCoord.put("Marry Seacole", new LatLng(51.532737, -0.468488));
        buildingCoord.put("Russel", new LatLng(51.532118, -0.468417));
        buildingCoord.put("Elliott Jaques", new LatLng(51.532345, -0.467581));
        buildingCoord.put("AMPC", new LatLng(51.531266, -0.468566));
        buildingCoord.put("Gardiner", new LatLng(51.531427, -0.467942));
        buildingCoord.put("AMCC", new LatLng(51.531408, -0.467204));
        buildingCoord.put("Medical Centre", new LatLng(51.531853, -0.472270));
        buildingCoord.put("Tower D", new LatLng(51.531477, -0.472633));
        buildingCoord.put("Tower C", new LatLng(51.531357, -0.473048));
        buildingCoord.put("Joseph Lowe", new LatLng(51.530887, -0.473897));
        buildingCoord.put("Antonin Artuad", new LatLng(51.530949, -0.474806));
        buildingCoord.put("Tower B", new LatLng(51.531374, -0.474360));
        buildingCoord.put("Tower A", new LatLng(51.531955, -0.474006));
        buildingCoord.put("Howell", new LatLng(51.531955, -0.474006));
        buildingCoord.put("Marle Jahoda", new LatLng(51.532988, -0.476617));
        buildingCoord.put("Gaskell", new LatLng(51.532950, -0.477679));
        buildingCoord.put("Chadwick", new LatLng(51.532840, -0.478345));
        buildingCoord.put("Heinz Wolff", new LatLng(51.534103, -0.474944));
        buildingCoord.put("Design & Print Service", new LatLng(51.534103, -0.474944));
        buildingCoord.put("Bragg", new LatLng(51.534563, -0.473067));
        buildingCoord.put("Wolfson centre", new LatLng(51.534563, -0.473067));
        buildingCoord.put("Quad North", new LatLng(51.533809, -0.472703));
        buildingCoord.put("The Quad", new LatLng(51.533426, -0.472035));
        buildingCoord.put("St Johns", new LatLng(51.534435, -0.469519));
        buildingCoord.put("Eastern Gateway", new LatLng(51.533412, -0.468692));
        buildingCoord.put("Wilfred Brown", new LatLng(51.532670, -0.475400));
        buildingCoord.put("Micheal Sterling", new LatLng(51.534563, -0.473067));
        buildingCoord.put("Bannerman Centre", new LatLng(51.532894, -0.474158));
        buildingCoord.put("Lecture Centre", new LatLng(51.532869, -0.472884));
        buildingCoord.put("Arts centre", new LatLng(51.532995, -0.472094));

        List<String> allBuildings = new ArrayList<>(parkingMap.keySet());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, allBuildings);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sItems.setAdapter(adapter);

        sItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mMap.clear();
                String nameOfBuilding = sItems.getSelectedItem().toString();
                LatLng[] closeParkings = parkingMap.get(nameOfBuilding);
                for (LatLng coord : closeParkings) {
                    Marker parkingSpot = mMap.addMarker(new MarkerOptions()
                            .position(coord)
                            .title(coordsWithNames.get(coord))
                            .snippet("Distance: " + distance(coord.latitude,
                                    buildingCoord.get(nameOfBuilding).latitude,
                                    coord.longitude,
                                    buildingCoord.get(nameOfBuilding).longitude,
                                    TERRAIN_ELEVATION,
                                    TERRAIN_ELEVATION) + "m").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                    parkingSpot.showInfoWindow();
                }

                Marker lessonBuilding = mMap.addMarker(new MarkerOptions()
                        .position(buildingCoord.get(nameOfBuilding))
                        .title(nameOfBuilding));
                lessonBuilding.showInfoWindow();

                CameraUpdate center = CameraUpdateFactory.newLatLngZoom(lessonBuilding.getPosition(), 17);

                mMap.animateCamera(center);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_parking);
        init();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

    /**
     * Calculate distance between two points in latitude and longitude taking
     * into account height difference. If you are not interested in height
     * difference pass 0.0. Uses Haversine method as its base.
     *
     * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
     * el2 End altitude in meters
     * @returns Distance in Meters
     */
    public static long distance(double lat1, double lat2, double lon1,
                                double lon2, double el1, double el2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.round(Math.sqrt(distance));
    }
}