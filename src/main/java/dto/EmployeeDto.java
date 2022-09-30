package dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeDto {

    private String name;

    private String city;

    private String created;

    public EmployeeDto(String name, String city) {
        this.name = name;
        this.city = city;
    }


    @Override
    public String toString() {
        return String.format("{Employee info} | Created - %s, Name - %s, City - %s.", created, name, city );
    }
}
