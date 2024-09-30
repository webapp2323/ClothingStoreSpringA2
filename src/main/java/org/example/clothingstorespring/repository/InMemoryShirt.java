//package org.example.clothingstorespring.repository;
//
//
//import org.example.clothingstorespring.model.Shirt;
//
//import org.springframework.stereotype.Repository;
//
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.IntStream;
//
//@Repository
//public class InMemoryShirt {
//    private final List<Shirt> SHIRTS = new ArrayList<Shirt>();
//
//    public List<Shirt> getAllShirts() {
//        return SHIRTS;
//    }
//
//    public Shirt getShirtById(Long id) {
//        return SHIRTS.stream()
//                .filter(shirt -> shirt.getId().equals(id))
//                .findFirst()
//                .orElse(null);
//    }
//
//
//    public Shirt addShirt(Shirt shirt) {
//        SHIRTS.add(shirt);
//        return shirt;
//    }
//
//
//    public Shirt updateShirt(Shirt shirt) {
//        var shirtIndex = IntStream.range(0, SHIRTS.size())
//                .filter(Index -> SHIRTS.get(Index).getId().equals(shirt.getId()))
//                .findFirst()
//                .orElse(-1);
//        if (shirtIndex != -1) {
//            SHIRTS.set(shirtIndex, shirt);
//            return shirt;
//
//        }
//        return null;
//    }
//
//
//    public void deleteShirt(Shirt shirt) {
//        SHIRTS.removeIf(s -> s.getId().equals(shirt.getId()));
//    }
//
//        }
//
