package com.company.solution_010.rules;

@FunctionalInterface
public interface Rule {

    Boolean check(Long number, Long comparable);
}
