package com.bookstore.spring_JPA.dtos;

import java.util.Set;
import java.util.UUID;


import java.util.UUID;

public record BookRecordDto(String title, UUID publisherId, Set<UUID> authorsIds, String reviewComment) {

}
