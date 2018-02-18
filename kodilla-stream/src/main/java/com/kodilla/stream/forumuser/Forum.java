package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> forumUserList = new ArrayList<>();

    public Forum() {
        forumUserList.add(new ForumUser(1, "user1", 'M',
                LocalDate.of(1983,12,7), 21));
        forumUserList.add(new ForumUser(2, "user2", 'M',
                LocalDate.of(1977,5,11), 115));
        forumUserList.add(new ForumUser(3, "user3", 'F',
                LocalDate.of(2000,8,31), 3));
        forumUserList.add(new ForumUser(4, "user4", 'M',
                LocalDate.of(1960,4,22), 0));
        forumUserList.add(new ForumUser(5, "user5", 'M',
                LocalDate.of(2000,9,9), 11));
        forumUserList.add(new ForumUser(6, "user6", 'F',
                LocalDate.of(1954,1,18), 201));
        forumUserList.add(new ForumUser(7, "user7", 'M',
                LocalDate.of(1998,2,18), 38));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(forumUserList);
    }
}
