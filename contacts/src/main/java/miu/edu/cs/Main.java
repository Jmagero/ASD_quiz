package miu.edu.cs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import miu.edu.cs.model.Contact;
import miu.edu.cs.model.Email;
import miu.edu.cs.model.Label;
import miu.edu.cs.model.Phone;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Contact> contactList = getContacts();
        List <Contact> sortedcontactList = contactList.stream().sorted(Comparator.comparing(Contact::getLastName))
                        .toList();
//        sortedcontactList.forEach(System.out::println);
        printEmployees(sortedcontactList);

        System.out.println("Hello world!");
    }

    private  static List getContacts(){
        Contact contact1 = new Contact("David", "Sanger", "Argos LLC", "Sales Manager");
        contact1.setPhones(Arrays.asList(
                new Phone("240-133-0011", Label.Home),
                new Phone("240-112-0123", Label.Mobile)
        ));
        contact1.setEmailAdresses(Arrays.asList(
                new Email("dave.sang@gmail.com",Label.Home),
                new Email("dsanger@argos.com", Label.Work)
        ));
        Contact contact2 = new Contact("Carlos", "Jimenez", "Zappos", "Director");
        Contact contact3 = new Contact("Ali", "Gafar", "BMI Services", "HR Manager");
        contact3.setPhones(List.of(
                new Phone("412-116-9988", Label.Work)
        ));
        contact3.setEmailAdresses(List.of(
                new Email("ali@bmi.com", Label.Work)
        ));
        return Arrays.asList(
                contact1, contact2, contact3
        );
    }
    private static  void printEmployees(List<Contact> contacts){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String jsonString = objectMapper.writeValueAsString(contacts);
            System.out.print(jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}