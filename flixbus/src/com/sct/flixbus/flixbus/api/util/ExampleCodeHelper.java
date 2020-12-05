package com.sct.flixbus.flixbus.api.util;

import com.sct.flixbus.flixbus.api.domain.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides some functions and constants used
 * throughout the example code. There is probably
 * not much here you would consider to use in
 * production.
 *
 */
public class ExampleCodeHelper {

    public static final String INTEGRATION_EMAIL    = "YOUR_INTEGRATION_EMAIL";
    public static final String INTEGRATION_PASSWORD = "YOUR_INTEGRATION_PASSWORD";
    public static final String INTEGRATION_TOKEN    = "YOUR_INTEGRATION_TOKEN";
    public static final String INTEGRATION_SERVER   = "https://api-dev.flixbus.com";

    public static final int STATION_ID_BERLIN   = 88;
    public static final int STATION_ID_MUNICH   = 94;

    public static TripSearchRequest getTripSearchRequest(int fromStation, int toStation, int daysInAdvance) {
        LocalDate departureDate = LocalDate.now().plusDays(daysInAdvance);
        DateTimeFormatter europeanDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String departure = europeanDateFormatter.format(departureDate);

        TripStation from = new TripStation();
        from.setId(fromStation);

        TripStation to = new TripStation();
        to.setId(toStation);

        return new TripSearchRequest(departure, from, to);
    }

    public static PaymentListRequest getPaymentListRequest(ReservationResponse reservationResponse,
                                                           AuthenticationResponse authResponse){
        return new PaymentListRequest(reservationResponse.getReservation(), authResponse.getToken());
    }

    public static PaymentStartRequest getPaymentStartRequest(ReservationResponse reservationResponse,
                                                             AuthenticationResponse authResponse) {
        return new PaymentStartRequest(reservationResponse.getReservation(), authResponse.getToken());
    }

    public static PaymentCommitRequest getPaymentCommitRequest(ReservationResponse reservationResponse,
                                                               PaymentStartResponse paymentStartResponse,
                                                               AuthenticationResponse authResponse) {
        return new PaymentCommitRequest(reservationResponse.getReservation(), paymentStartResponse.getPayment_id(),
                authResponse.getToken());
    }

    public static ReservationRequest getReservationRequest(TripItem tripItemToBook, AuthenticationResponse authResponse) {
        return new ReservationRequest(tripItemToBook.getUid(), authResponse.getToken());
    }

    public static PassengerDetailsRequest getPassengerDetailsRequest(CartReservation reservation) {
        return new PassengerDetailsRequest(reservation);
    }

    public static AddPassengerDetailsRequest getAddPassengerDetailsRequest(PassengerDetailsResponse passengerDetailsResponse,
                                                                           CartReservation reservation) {
        List<Passenger> passengers = new ArrayList<>();
        for (PassengerTrip passengerTrip : passengerDetailsResponse.getTrips()) {
            Passenger passenger = passengerTrip.getPassenger(0);
            passenger.setBirthdate("01.01.1970");
            passenger.setFirstname("Arthur");
            passenger.setLastname("Dent");
            passenger.setPhone("+49301234567890");

            passengers.add(passenger);
        }

        PassengerRequest passengerRequest = new PassengerRequest(reservation, "atmosfair", true, passengers);

        return new AddPassengerDetailsRequest(reservation.getId(), passengerRequest);
    }
}
