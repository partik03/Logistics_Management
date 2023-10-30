package com.logistics.web.models;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class Razorpay {

    @Getter @NotNull
    private String razorpay_payment_id;

    @Getter
    private String razorpay_order_id;

    @Getter
    private String razorpay_signature;
}
