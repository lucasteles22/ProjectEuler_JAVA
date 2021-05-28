package br.com.solution_007.rules;

@FunctionalInterface
public interface Rule {
    Boolean check(Long number, Long comparable);
}
