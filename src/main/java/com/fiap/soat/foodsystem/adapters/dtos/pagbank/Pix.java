package com.fiap.soat.foodsystem.adapters.dtos.pagbank;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Pix {
    @SerializedName("notification_id")
    private String notificationId;
    @SerializedName("end_to_end_id")
    private String endToEndId;
    private Holder holder;
}
