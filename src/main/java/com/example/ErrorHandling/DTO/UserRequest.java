package com.example.ErrorHandling.DTO;


import jakarta.validation.constraints.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
public class UserRequest {

    private String id;
    // Todo -> Tidak boleh null , tapi "" ,[] , 0 bisa
    @NotNull(message = "Enter A Valid Employee Name")
    private String name;

    // Todo -> Tidak boleh kosong dan null , tapi spasi kosong bisa
    @NotEmpty(message = "Must Not Be Empty and Null")
    private String hobby;

    // Todo -> integer tidak bisa pakai not Blank
    @Min(value = 18, message = "Minimum working 18")
    @Max(value= 40 , message = "Maximum working 40 age")
    private Integer age;

    // Todo -> Tidak boleh null , Kosong , Dan Hanya spasi
    @NotBlank(message = "Addres Cant'be left Empty")
    private String address;

    @NotBlank(message = "Email Cant Be Left Empty")
    @Email(message = "Please Enter A valid email ID")
    private String email;

    // Todo -> minimal dan maksimal Character
    @NotBlank(message = "Phone number is Must")
    @Size(min = 12 , max = 14 , message = "nomor hp tidak boleh kurang dari 12 dan 14")
    private String phoneNumber;

    private String roleId;


}
