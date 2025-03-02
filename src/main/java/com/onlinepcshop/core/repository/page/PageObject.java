package com.onlinepcshop.core.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class PageObject<T> {
    List<T> data;
    int page;
    int rowsPerPage;
    long rowsNumber;
    boolean descending;
    String sortBy;
}
