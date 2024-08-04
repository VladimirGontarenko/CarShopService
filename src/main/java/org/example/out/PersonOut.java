package org.example.out;

import org.example.dto.PersonDto;

import java.util.Map;

public class PersonOut {
    public void getAllClients(Map<String, PersonDto> personsMap) {
        if (!personsMap.isEmpty()) {
            for (Map.Entry<String, PersonDto> person : personsMap.entrySet()) {
                if (person.getValue().getRoleUser().getRoleUser().equals("CLIENT")) {
                    System.out.println(person);
                }
            }
        }
    }

    public void getAllEmployee(Map<String, PersonDto> personsMap) {
        if (!personsMap.isEmpty()) {
            for (Map.Entry<String, PersonDto> person : personsMap.entrySet()) {
                if (person.getValue().getRoleUser().getRoleUser().equals("MANAGER")||person.getValue().getRoleUser().getRoleUser().equals("ADMIN")) {
                    System.out.println(person);
                }
            }
        }
    }

    public boolean getPersonForLogin(String login, Map<String, PersonDto> personsMap) {
        return personsMap.containsKey(login);
    }
}
