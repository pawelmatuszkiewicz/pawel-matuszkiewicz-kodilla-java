package com.kodilla.good.patterns.challenges;

public class EmailInformationService implements InformationService {

    @Override
    public void inform(final User user) {
        System.out.println("Email confirmation has been sent to "
                + user.getFirstName() + " " + user.getLastName() + '.');
    }
}
