package com.example.bookstore.repository.specification;

import com.example.bookstore.entity.Author;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class AuthorSpecification {

    public static Specification<Author> findByCriteria(String firstname, String lastname, String secondName) {
        return (Root<Author> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (firstname != null && !firstname.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("firstname"), firstname));
            }
            if (lastname != null && !lastname.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("lastname"), lastname));
            }
            if (secondName != null && !secondName.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("secondName"), secondName));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
