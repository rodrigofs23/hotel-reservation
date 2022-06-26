package org.com.hotel.reservation.hotels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.com.hotel.reservation.CustomerType;
import org.com.hotel.reservation.RateType;
import org.com.hotel.reservation.ReservationRequest;

import java.util.List;

@AllArgsConstructor
public class Hotel {
    @Getter
    private final String hotelName;
    private final Integer rating;
    private final List<Rate> rates;

    public Integer priceFor(RateType rateType, CustomerType customerType) {
        for (Rate rate : rates) {
            if (rate.isFor(rateType, customerType)) {
                return rate.getCost();
            }
        }
        return null; // TODO: default price if there are any rates
    }

    public Integer priceFor(ReservationRequest request) {
        return priceFor(request.getRateType(), request.getCustomerType());
    }
}
