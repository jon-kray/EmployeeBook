package model;

import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode
@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class Employee {

    private long id;

    private String name;

    private String city;

    private LocalDateTime created;


    public Employee(@NonNull String name, String city) {
        this.name = name;
        this.city = city;
        this.created = LocalDateTime.now();

    }
}
