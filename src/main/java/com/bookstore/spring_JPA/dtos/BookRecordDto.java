package com.bookstore.spring_JPA.dtos;

public record BookRecordDto(String title, UUID publisherId, Set<UUID> authorsIds, String reviewComment) {

}
