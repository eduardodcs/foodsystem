package com.fiap.soat.foodsystem.adapters.dtos.pagbank;

import com.fasterxml.jackson.annotation.JsonProperty;
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

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OrderResponse {
    private String id;
    @SerializedName("reference_id")
    @JsonProperty("reference_id")
    private String referenceId;
    @SerializedName("created_at")
    @JsonProperty("created_at")
//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private Instant createdAt;
    private Customer customer;
    @SerializedName("qr_codes")
    @JsonProperty("qr_codes")
    private List<QrCode> qrCodes;
    private List<Charge> charges;
    @SerializedName("notification_urls")
    @JsonProperty("notification_urls")
    private List<String> notificationUrls;
    private List<Link> links;
}