package com.sct.flixbus.flixbus.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"reservation"})
public class ReservationResponse {

   private boolean result;

   private ReservationWithMetaInfo reservation;

   private Cart cart;

   public boolean isResult() {
      return result;
   }

   public void setResult(boolean result) {
      this.result = result;
   }

   public CartReservation getReservation() {
      return this.cart.getReservation();
   }

   public void setReservation(ReservationWithMetaInfo reservation) {
      this.reservation = reservation;
   }

   public Cart getCart() {
      return cart;
   }

   public void setCart(Cart cart) {
      this.cart = cart;
   }
}
