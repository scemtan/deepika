package com.sct.flixbus.flixbus.api.domain;

public class OrderResponse {

    private int code;

    private String message;
    private String order_uid;

    private OrderInfo order;

    private OrderInfoResourceLinks _links;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOrder_uid() {
        return order_uid;
    }

    public void setOrder_uid(String order_uid) {
        this.order_uid = order_uid;
    }

    public OrderInfo getOrder() {
        return order;
    }

    public void setOrder(OrderInfo order) {
        this.order = order;
    }

    public OrderInfoResourceLinks get_links() {
        return _links;
    }

    public void set_links(OrderInfoResourceLinks _links) {
        this._links = _links;
    }

    @Override
    public String toString() {
        StringBuilder bookingData = new StringBuilder("Booking data:");

        bookingData.append("\n Trips");
        for (OrderInfoTrip trip : this.order.getTrips()) {
            bookingData.append(
                    String.format("\n - %s (%s) -> %s (%s) (%d passengers)  ",
                            trip.getDeparture_station().getName(),
                            trip.getDeparture().getLocalizedDateTime(),
                            trip.getArrival_station().getName(),
                            trip.getArrival().getLocalizedDateTime(),
                            trip.getPassengers().size()
                    )
            );
        }

        bookingData.append("\n Ticket  as PDF: ").append(this.order.getReminder_link());
        bookingData.append("\n QR-Code as PDF: ").append(this.order.getQr_image());

        return bookingData.toString();
    }
}
