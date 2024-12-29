package com.karthik.fd.restaurant.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "restaurant")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = false)
public class Restaurant extends Recorder {

    @NotBlank
    @Column(name = "rest_name", length = 100, nullable = false)
    private String name;

    @NotBlank
    @Size(max = 255)
    @Column(name = "address", nullable = false)
    private String address;

    @NotBlank
    @Size(min = 10, max = 10)
    @Column(name = "contact", length = 10, nullable = false)
    private String contact;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<MenuItem> menuItems;

}
