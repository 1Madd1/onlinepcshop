//package com.onlinepcshop.adapters.persistance.repository.jpa.filter;
//
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.function.Predicate;
//
//
//public class VlasnikSearchSpecification {
//    public static Predicate<VlasnikDao> getPredicate(Map<String, String[]> criteria) {
//        Predicate<VlasnikDao> predicate = vlasnik -> true;
//
//        for (Entry<String, String[]> entry : criteria.entrySet()) {
//            predicate = predicate.and(getSpecification(entry.getKey(), entry.getValue()));
//        }
//        return predicate;
//    }
//
//    public static Predicate<VlasnikDao> getSpecification(String filedName, String[] values) {
//        switch (filedName) {
//            case "ime": {
//                Predicate<VlasnikDao> predicate = v -> true;
//                for (String value : values) {
//                    predicate = predicate.and(
//                            vlasnik -> {
//                                if (vlasnik.getIme() != null) {
//                                    String imePrezime = vlasnik.getIme() + " " + vlasnik.getPrezime();
//                                    return imePrezime.toLowerCase().contains(value.toLowerCase());
//                                }
//                                return vlasnik.getNaziv().toLowerCase().contains(value.toLowerCase());
//                            });
//                }
//                return predicate;
//            }
//            case "maticniBroj": {
//                Predicate<VlasnikDao> predicate = v -> false;
//                for (String value : values) {
//                    predicate = predicate.or(
//                            vlasnik -> vlasnik.getMaticniBroj().contains(value));
//                }
//                return predicate;
//            }
//            case "tip": {
//                Predicate<VlasnikDao> predicate = v -> false;
//                for (String value : values) {
//                    predicate = predicate.or(
//                            vlasnik -> vlasnik.getTip().contains(value));
//                }
//                return predicate;
//            }
//            case "pib": {
//                Predicate<VlasnikDao> predicate = v -> false;
//                for (String value : values) {
//                    predicate = predicate.or(
//                            vlasnik -> vlasnik.getPib().contains(value));
//                }
//                return predicate;
//
//            }
//            case "brojPasosa": {
//                Predicate<VlasnikDao> predicate = v -> false;
//                for (String value : values) {
//                    predicate = predicate.or(
//                            vlasnik -> vlasnik.getBrojPasosa().contains(value));
//                }
//                return predicate;
//
//            }
//            case "brojIsprave": {
//                Predicate<VlasnikDao> predicate = v-> false;
//                for(String value:values) {
//                    predicate = predicate.or(v ->
//                            (v.getBrojPasosa() != null && v.getBrojPasosa().contains(value))
//                                    || (v.getBrojLicneKarte() != null && v.getBrojLicneKarte().contains(value))
//                                    || (v.getMaticniBroj() != null && v.getMaticniBroj().contains(value))
//                    );
//                }
//                return predicate;
//            }
//            default: {
//                return vlasnik -> true;
//            }
//        }
//    }
//}
