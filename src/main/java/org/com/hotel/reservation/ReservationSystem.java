package org.com.hotel.reservation;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Collections2;
import org.com.hotel.reservation.hotels.Hotels;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class ReservationSystem {

    private final List<ReservationRequest> reservationRequests;
    private final Hotels hotels;

    public ReservationSystem(List<String> lines, Hotels hotels) {
        this.hotels = hotels;
        this.reservationRequests = reservationRequestsFrom(lines);
    }

    private List<ReservationRequest> reservationRequestsFrom(List<String> lines) {
        return newArrayList(Collections2.transform(lines, reservationRequestFromLine()));
    }

    private Function<? super String, ReservationRequest> reservationRequestFromLine() {
        return (Function<String, ReservationRequest>) ReservationRequest::new;
    }

    public String reservationResults() {
        Joiner joiner = Joiner.on("\n");
        return joiner.join(Collections2.transform(reservationRequests, toHotelsWithBestRateForRequest()));
    }

    private Function<? super ReservationRequest, String> toHotelsWithBestRateForRequest() {
        return (Function<ReservationRequest, String>) hotels::hotelWithBestRateFor;
    }
}
