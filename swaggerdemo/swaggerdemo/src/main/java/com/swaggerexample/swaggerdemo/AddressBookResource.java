package com.swaggerexample.swaggerdemo;

import com.swaggerexample.swaggerdemo.data.request.Contact;
import com.swaggerexample.swaggerdemo.data.response.WebResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/contact")
public class AddressBookResource {

    ConcurrentHashMap<String, Contact> contacts = new ConcurrentHashMap<>();

    @GetMapping("/getContact/{id}")
    public Contact getContact(@PathVariable String id){
       return contacts.get(id);

    }

    @GetMapping("/allContacts")
    public List<Contact> getAllContacts(){
        return new ArrayList<Contact>(contacts.values());
    }

    @PostMapping("/addContact")
    @Operation(
            description = "Add Contact",
            responses = {
                    @ApiResponse(responseCode = "400",ref = "badRequestAPI"),
                    @ApiResponse(responseCode = "500", ref = "internalServerErrorAPI"),
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully Added Contact",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = {
                                            @ExampleObject(
                                                value = "{ \"code\" : 200, \"Status\" : Ok, \"Message\": \"Successfully Added Contact\" }"
                                            )
                                    }

                            )
                    )
            }

    )
    public ResponseEntity<?> addContact(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(
                    mediaType = "application/json",
                    examples = {
                            @ExampleObject(
                                    value = "{\"contactId\":\"1\",\"firstName\" : \"Abhilasha\", \"lastName\" : \"Saltanat\",\"emailAddress\":\"test@gmail.com\",\"phoneNumber\":\"345456464\"}"
                            )
                    }

    )) @RequestBody Contact contact)
    {
        contacts.put(contact.getContactId(), contact);
        return new ResponseEntity<>(new WebResponse(HttpStatus.OK.value(),
                HttpStatus.OK.getReasonPhrase(),"Successfully Added Contact"),HttpStatus.OK);
    }


}
