package com.sct.flixbus.flixbus.api;

import com.sct.flixbus.flixbus.api.domain.*;

import static com.sct.flixbus.flixbus.api.util.ExampleCodeHelper.*;

/**
 * This example covers the main use cases of our Public
 * API from trip search, thru reservation creation and
 * payment to retrieval of final booking data.
 *
 * It creates a booking for 1 Adult on a return trip.
 *
 * Please find detailed information on the method comments
 * below.
 *
 * For constants and helper functions please see
 * the {@link com.flixbus.api.util.ExampleCodeHelper}.
 */
public class BookingExample {

    public static void main(String[] args) {
        try {
            // first we need to be authenticated
            AuthenticationRequest  authRequest  = new AuthenticationRequest(INTEGRATION_EMAIL, INTEGRATION_PASSWORD);
            AuthenticationResponse authResponse = PublicApiClient.authenticate(authRequest);

            // create a reservation (with the outward trip)
            ReservationResponse reservationResponse = createReservation(authResponse);
            System.out.println("- reservation created");

            // add the return trip to a reservation (we could add even more trips to the reservation)
            reservationResponse = addTripToReservation(authResponse, reservationResponse);
            System.out.println("- trip added to reservation");

            // add passenger details to the reservation
            addPassengerDetailsToReservation(reservationResponse);
            System.out.println("- passenger added to reservation");

            // finalize payment, which creates the booking
            PaymentCommitResponse paymentCommitResponse = finalizePayment(reservationResponse, authResponse);
            System.out.println("- payment finalized (booking created)");

            // retrieve booking data
            OrderResponse orderResponse = retrieveBookingData(paymentCommitResponse, authResponse);
            System.out.println(orderResponse.toString());
        } catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * In order to create a reservation we need to provide
     * exactly 1 trip. If we need more trips on our
     * reservation we must add it later.
     */
    private static ReservationResponse createReservation(AuthenticationResponse authResponse) throws Exception {
        // we need a search response, to pick a TripItem to be booked
        TripSearchRequest  searchRequest  = getTripSearchRequest(STATION_ID_BERLIN, STATION_ID_MUNICH, 30);
        TripSearchResponse searchResponse = PublicApiClient.tripSearch(searchRequest);

        // we create the reservation
        TripItem tripItemToBook               = searchResponse.getTrip(0).getTripItem(0);
        ReservationRequest reservationRequest = getReservationRequest(tripItemToBook, authResponse);

        return PublicApiClient.createReservation(reservationRequest);
    }

    /**
     * As mentioned above a reservation can have multiple trips.
     * Here we add a return trip for the reservation we created
     * earlier.
     */
    private static ReservationResponse addTripToReservation(AuthenticationResponse authResponse,
                                                            ReservationResponse reservationResponse) throws Exception {
        // we add a (return) trip to the reservation
        TripSearchRequest searchRequest   = getTripSearchRequest(STATION_ID_MUNICH, STATION_ID_BERLIN, 32);
        TripSearchResponse searchResponse = PublicApiClient.tripSearch(searchRequest);

        TripItem tripItemToBook                = searchResponse.getTrip(0).getTripItem(1);
        ReservationRequest reservationRequest  = getReservationRequest(tripItemToBook, authResponse);
        reservationRequest.setReservation(reservationResponse.getReservation());

        return PublicApiClient.createReservation(reservationRequest);
    }

    /**
     * After having added all trips to the reservation we add
     * passenger details. The number of passengers may vary
     * from trip to trip. E.g. on the first trip you may have only
     * 1 passenger and on the trip back there could be 2 passengers.
     *
     * For the sake of simplicity in this example we have the same
     * single passenger on both trips of the reservation.
     */
    private static void addPassengerDetailsToReservation(ReservationResponse reservationResponse) throws Exception {
        // first we need to get a passenger details object
        PassengerDetailsRequest passengerDetailsRequest   = getPassengerDetailsRequest(reservationResponse.getReservation());
        PassengerDetailsResponse passengerDetailsResponse = PublicApiClient.getPassengerDetails(passengerDetailsRequest);

        // now we can add passenger details
        AddPassengerDetailsRequest addPassengerDetailsRequest =
                getAddPassengerDetailsRequest(passengerDetailsResponse, reservationResponse.getReservation());

        PublicApiClient.addPassengerDetails(addPassengerDetailsRequest);
    }

    /**
     * In order to create a booking we need to finalize
     * the payment which is done in 3 steps.
     */
    private static PaymentCommitResponse finalizePayment(ReservationResponse reservationResponse,
                                                         AuthenticationResponse authResponse) throws Exception {
        // list payment methods
        PaymentListRequest paymentListRequest   = getPaymentListRequest(reservationResponse, authResponse);
        PaymentListResponse paymentListResponse = PublicApiClient.getPaymentList(paymentListRequest);

        // start payment
        PaymentStartRequest paymentStartRequest   = getPaymentStartRequest(reservationResponse, authResponse);
        PaymentStartResponse paymentStartResponse = PublicApiClient.startPayment(paymentStartRequest);

        // commit payment
        PaymentCommitRequest paymentCommitRequest   =
                getPaymentCommitRequest(reservationResponse, paymentStartResponse, authResponse);
        PaymentCommitResponse paymentCommitResponse = PublicApiClient.commitPayment(paymentCommitRequest);

        return paymentCommitResponse;
    }

    /**
     * Now that the booking is created we can retrieve
     * all its data like ticket pdf/QRcode and travel
     * data.
     */
    private static OrderResponse retrieveBookingData(PaymentCommitResponse paymentCommitResponse,
                                                     AuthenticationResponse authResponse) throws Exception {
        OrderInfoRequest orderInfoRequest = new OrderInfoRequest(paymentCommitResponse);
        OrderResponse orderResponse       = PublicApiClient.getOrderInfo(orderInfoRequest);
        return orderResponse;
    }
}
