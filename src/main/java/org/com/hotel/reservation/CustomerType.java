package org.com.hotel.reservation;

public enum CustomerType {
    Rewards,
    Regular;

    public static CustomerType from(String rawRequest) {
        if (rawRequest.contains(Rewards.name())) {
            return Rewards;
        }
        return Regular;
    }
}
