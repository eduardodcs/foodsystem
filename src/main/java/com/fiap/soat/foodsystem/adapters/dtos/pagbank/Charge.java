package com.fiap.soat.foodsystem.adapters.dtos.pagbank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Charge {
    private String id;
    @SerializedName("reference_id")
    private String referenceId;
    private String status;
    @SerializedName("created_at")
//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private Instant createdAt;
    @SerializedName("paid_at")
    private LocalDateTime paidAt;
    private Amount amount;
    @SerializedName("payment_response")
    private PaymentResponse paymentResponse;
    @SerializedName("payment_method")
    private PaymentMethod paymentMethod;
    private List<Link> links;
    private Map<String, Object> metadata;
}
