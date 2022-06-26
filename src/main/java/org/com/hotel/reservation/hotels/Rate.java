package org.com.hotel.reservation.hotels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.com.hotel.reservation.CustomerType;
import org.com.hotel.reservation.RateType;

@AllArgsConstructor
public class Rate {
    private final RateType rateType;
    private final CustomerType customerType;

    @Getter
    private final Integer cost;

    public boolean isFor(RateType rateType, CustomerType customerType) {
        return this.rateType.equals(rateType) && this.customerType.equals(customerType);
    }
}
