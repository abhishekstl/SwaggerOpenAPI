package com.swaggerexample.swaggerdemo.data.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"contactId","firstName","lastName", "address", "phoneNumber","emailAddress"})
public class Contact {

    @JsonProperty("contactId")
    private String contactId;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("address")
    private String address;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("emailAddress")
    private String emailAddress;

//    public Contact(){
//
//    }
//
//    public Contact(String contactId, String firstName, String lastName, String address, String phoneNumber, String emailAddress) {
//        this.contactId = contactId;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.address = address;
//        this.phoneNumber = phoneNumber;
//        this.emailAddress = emailAddress;
//    }

//    public String getContactId() {
//        return contactId;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public String getEmailAddress() {
//        return emailAddress;
//    }
//
//    public void setContactId(String contactId) {
//        this.contactId = contactId;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public void setEmailAddress(String emailAddress) {
//        this.emailAddress = emailAddress;
//    }

}
