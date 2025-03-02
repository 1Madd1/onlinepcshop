package com.onlinepcshop.core.util;

import com.onlinepcshop.core.domain.entity.Storage;

import java.util.Comparator;

public class StorageComparator implements Comparator<Storage> {
    @Override
    public int compare(Storage s1, Storage s2) {
        return s1.getPrice().getAmount().compareTo(s2.getPrice().getAmount());
    }
}
