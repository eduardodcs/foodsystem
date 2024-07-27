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
public class QrCode {
    private String id;
    @SerializedName("expiration_date")
    @JsonProperty("expiration_date")
//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private Instant expirationDate;
    private Amount amount;
    private String text;
    private List<String> arrangements;
    private List<Link> links;
}
